
const {
  ChoiceFactory,
  ChoicePrompt,
  ComponentDialog,
  ConfirmPrompt,
  DialogSet,
  DialogTurnStatus,
  NumberPrompt,
  TextPrompt,
  WaterfallDialog
} = require('botbuilder-dialogs');
const { ReporteFallaServicio } = require('../entities/reporteFallaServicio');
const { Validators } = require('../commons/validators')

const WATERFALL_DIALOG = 'WATERFALL_DIALOG';

const REPORTE_FALLA_SERVICIO = 'REPORTE_FALLA_SERVICIO';

/*
tipoDocumento TIPO_DOCUMENTO_PROMPT; 
numeroDocumento NUMERO_DOCUMENTO_PROMPT;
descripcionFalla DESCRIPCION_FALLA_PROMPT;
tipoServicio TIPO_SERVICIO_PROMPT;
idServicio ID_SERVICIO_PROMPT;
correo electronico (opcional) EMAIL_PROMPT
*/
const TIPO_DOCUMENTO_CHOICE_PROMPT = 'TIPO_DOCUMENTO_CHOICE_PROMPT';
const NUMERO_DOCUMENTO_PROMPT = 'NUMERO_DOCUMENTO_PROMPT';
const TIPO_SERVICIO_CHOICE_PROMPT = 'TIPO_SERVICIO_CHOICE_PROMPT';
const ID_SERVICIO_PROMPT = 'ID_SERVICIO_PROMPT';
const DESCRIPCION_FALLA_PROMPT = 'DESCRIPCION_FALLA_PROMPT';
const CONFIRM_EMAIL_PROMPT = 'CONFIRM_EMAIL_PROMPT';
const EMAIL_PROMPT = 'EMAIL_PROMPT';
const FINAL_CONFIRM_PROMPT = 'FINAL_CONFIRM_PROMPT';

class ReporteFallaServicioDialog extends ComponentDialog {
  constructor(userState, procesoBPM) {
      super('reporteFallaServicioDialog');

      this.validators = new Validators();

      this.procesoBPM = procesoBPM;

      this.reporteFallaServicio = userState.createProperty(REPORTE_FALLA_SERVICIO);

      this.addDialog(new ChoicePrompt(TIPO_DOCUMENTO_CHOICE_PROMPT));
      this.addDialog(new NumberPrompt(NUMERO_DOCUMENTO_PROMPT, this.validators.numeroDocumentoPromptValidator));
      this.addDialog(new ChoicePrompt(TIPO_SERVICIO_CHOICE_PROMPT));
      this.addDialog(new TextPrompt(ID_SERVICIO_PROMPT, this.validators.msisdnOLineaFijaPromptValidator));
      this.addDialog(new TextPrompt(DESCRIPCION_FALLA_PROMPT));
      this.addDialog(new ConfirmPrompt(CONFIRM_EMAIL_PROMPT));
      this.addDialog(new TextPrompt(EMAIL_PROMPT, this.validators.emailValidator));
      this.addDialog(new ConfirmPrompt(FINAL_CONFIRM_PROMPT));

      this.addDialog(new WaterfallDialog(WATERFALL_DIALOG, [
          this.tipoDocumentoStep.bind(this),
          this.numeroDocumentoStep.bind(this),
          this.tipoServicioStep.bind(this),
          this.idServicioStep.bind(this),
          this.descripcionFallaStep.bind(this),
          this.confirmEmailStep.bind(this),
          this.emailStep.bind(this),
          this.finalConfirmStep.bind(this),
          this.summaryStep.bind(this)
      ]));

      this.initialDialogId = WATERFALL_DIALOG;
  }

  /**
   * The run method handles the incoming activity (in the form of a TurnContext) and passes it through the dialog system.
   * If no dialog is active, it will start the default dialog.
   * @param {*} turnContext
   * @param {*} accessor
   */
  async run(turnContext, accessor) {
      const dialogSet = new DialogSet(accessor);
      dialogSet.add(this);

      const dialogContext = await dialogSet.createContext(turnContext);
      const results = await dialogContext.continueDialog();
      if (results.status === DialogTurnStatus.empty) {
          await dialogContext.beginDialog(this.id);
      }
  }

  async tipoDocumentoStep(step) {
      
      // We can send messages to the user at any point in the WaterfallStep.
      await step.context.sendActivity(`Bienvenido al canal de reporte de fallas técnicas. \uD83D\uDC4B Te solicitaremos algunos datos para entender mejor tu problema.`);

      // WaterfallStep always finishes with the end of the Waterfall or with another dialog; here it is a Prompt Dialog.
      // Running a prompt here means the next WaterfallStep will be run when the users response is received.
      return await step.prompt(TIPO_DOCUMENTO_CHOICE_PROMPT, {
          prompt: 'Primero indicanos tú tipo de documento:',
          choices: ChoiceFactory.toChoices(['CC', 'CE'])
      });
  }

  async numeroDocumentoStep(step) {
      step.values.tipoDocumentoIdentidad = step.result.value;
      return await step.prompt(NUMERO_DOCUMENTO_PROMPT, 'Por favor escribe tú número de documento (Ej: 1096111222)');
  }

  async tipoServicioStep(step) {
        step.values.numeroDocumentoIdentidad = step.result;
        return await step.prompt(TIPO_SERVICIO_CHOICE_PROMPT, {
            prompt: '¡Bien! ahora cuentame que servicio esta presentando fallas',
            choices: ChoiceFactory.toChoices(['Fijo', 'Móvil'])
        });
    }

    async idServicioStep(step) {
        step.values.tipoServicio = step.result.value;
        return await step.prompt(ID_SERVICIO_PROMPT, 'Vale, ¿cuál es el número de la linea? (escribelo sin espacios y sin puntos)');
    }

    async descripcionFallaStep(step) {
        step.values.idServicio = step.result;
        return await step.prompt(DESCRIPCION_FALLA_PROMPT, '¡Ya falta poco para terminar! por último, describeme muy brevemente la falla');
    }

    async confirmEmailStep(step) {
        step.values.descripcionFalla = step.result;
        console.log(step.values.descripcionFalla)
        // WaterfallStep always finishes with the end of the Waterfall or with another dialog, here it is a Prompt Dialog.
        return await step.prompt(CONFIRM_EMAIL_PROMPT, {prompt:'¿Deseas que se te envíe el resumen de esta interacción por correo?',choices: ChoiceFactory.toChoices(['si', 'no'])} );
    }

  async emailStep(step) {
      if (step.result) {
          // User said "yes" so we will be prompting for the age.
          // WaterfallStep always finishes with the end of the Waterfall or with another dialog, here it is a Prompt Dialog.
          const promptOptions = { prompt: 'Por favor escribe tu correo electrónico', retryPrompt: 'El correo debe incluir un simbolo "@" y nombre de dominio (Ejemplo tunombre@hotmail.co)' };

          return await step.prompt(EMAIL_PROMPT, promptOptions);
      } else {
          // User said "no" so we will skip the next step. Give -1 as the age.
          return await step.next(-1);
      }
  }

  async finalConfirmStep(step) {
    step.values.email = step.result;
    
    let msg = step.values.email === -1 ? 'Vale, no pasa nada tambíen te estaremos informando por este canal. ' : `El historial de esta incidencia sera enviada a tu correo electrónico ${ step.values.email }.`;
    msg =     'Te presento un resumen de la información que nos haz dado hasta el momento: '
            + `Tu documento es ${ step.values.tipoDocumentoIdentidad } ${ step.values.numeroDocumentoIdentidad }. `
            + `Haz registrado una incidencia de falla tecnica en tu servicio ${step.values.tipoServicio} ${step.values.idServicio}. `
            
    await step.context.sendActivity(msg);

    // WaterfallStep always finishes with the end of the Waterfall or with another dialog, here it is a Prompt Dialog.
    return await step.prompt(FINAL_CONFIRM_PROMPT, '¿Estan todos los datos correctos?', ['si', 'no'] );
  }



  async summaryStep(step) {
    if (step.result) {
        const reporteFallaServicio = await this.reporteFallaServicio.get(step.context, new ReporteFallaServicio());

        reporteFallaServicio.tipoDocumentoIdentidad = step.values.tipoDocumentoIdentidad;
        reporteFallaServicio.numeroDocumentoIdentidad = step.values.numeroDocumentoIdentidad;
        reporteFallaServicio.tipoServicio = step.values.tipoServicio;
        reporteFallaServicio.idServicio = step.values.idServicio;
        reporteFallaServicio.descripcionFalla = step.values.descripcionFalla;
        reporteFallaServicio.email = step.values.email;

        reporteFallaServicio.fromId = step.context.activity.from.id
        reporteFallaServicio.conversationId = step.context.activity.conversation.id

         await step.context.sendActivity('Validaré con nuestros sistemas la incidencia que estas reportanto.');
         try{
            await this.procesoBPM.iniciarCaso(reporteFallaServicio)
            await step.context.sendActivity('Enhorabuena, la resolución de tu solicitud puede tomar unos minutos, te pedimos un poco de paciencia.')
         } catch(ex){
            await step.context.sendActivity('Parece que hubo un problema procesando tu solicitud, por favor intentalo mas tarde');
         }
    } else {
          await step.context.sendActivity('¡Oh no! Pero no te preocupes podemos intentarlo de nuevo.');
      }

      // WaterfallStep always finishes with the end of the Waterfall or with another dialog, here it is the end.
      return await step.endDialog();
  }
}

module.exports.ReporteFallaServicioDialog = ReporteFallaServicioDialog;