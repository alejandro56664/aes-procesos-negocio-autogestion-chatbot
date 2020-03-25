
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
  const { RegistroPQR } = require('../entities/registroPQR');
  const { Validators } = require('../commons/validators')
  
  const WATERFALL_DIALOG = 'WATERFALL_DIALOG';
  
  const REGISTRO_PQR = 'REGISTRO_PQR';
  
  /*
  tipoDocumento TIPO_DOCUMENTO_PROMPT; 
  numeroDocumento NUMERO_DOCUMENTO_PROMPT;
  confirmCUN CONFIRM_CUN_PROMPT ;
  numeroRadicado NUMERO_RADICADO_PROMPT;
  confirmReposicion CONFIRM_REPOSICION_PROMPT;
  motivo MOTIVO_PROMPT
  */
  const TIPO_DOCUMENTO_CHOICE_PROMPT = 'TIPO_DOCUMENTO_CHOICE_PROMPT';
  const NUMERO_DOCUMENTO_PROMPT = 'NUMERO_DOCUMENTO_PROMPT';
  const CONFIRM_CUN_PROMPT = 'CONFIRM_CUN_PROMPT';
  const NUMERO_RADICADO_PROMPT = 'NUMERO_RADICADO_PROMPT';
  const MOTIVO_PROMPT = 'MOTIVO_PROMPT';
  const CONFIRM_RECLAMO_PROMPT = 'CONFIRM_RECLAMO_PROMPT';
  const RECLAMO_PROMPT = 'RECLAMO_PROMPT';
  const RETURN_PROMPT = 'RETURN_PROMPT';
  const FINAL_CONFIRM_PROMPT = 'FINAL_CONFIRM_PROMPT';
  
  class RegistroPQRDialog extends ComponentDialog {
    constructor(userState, procesoBPM) {
        super('registroPQRDialog');
        
        this.procesoBPM = procesoBPM;
        this.validators = new Validators();
  
        this.registroPQR = userState.createProperty(REGISTRO_PQR);
  
        this.addDialog(new ChoicePrompt(TIPO_DOCUMENTO_CHOICE_PROMPT));
        this.addDialog(new NumberPrompt(NUMERO_DOCUMENTO_PROMPT, this.validators.numeroDocumentoPromptValidator));
        this.addDialog(new ConfirmPrompt(CONFIRM_CUN_PROMPT));
        this.addDialog(new NumberPrompt(NUMERO_RADICADO_PROMPT, this.validators.numeroRadicadoPromptValidator));
        this.addDialog(new TextPrompt(MOTIVO_PROMPT, this.validators.emailValidator));
        this.addDialog(new ConfirmPrompt(CONFIRM_RECLAMO_PROMPT));
        this.addDialog(new ConfirmPrompt(RETURN_PROMPT));
        this.addDialog(new ConfirmPrompt(FINAL_CONFIRM_PROMPT));
        this.addDialog(new ConfirmPrompt(RECLAMO_PROMPT));
        
  
        this.addDialog(new WaterfallDialog(WATERFALL_DIALOG, [
            this.tipoDocumentoStep.bind(this),
            this.numeroDocumentoStep.bind(this),
            this.confirmCunStep.bind(this),
        // this.numeroRadicadoStep.bind(this),
            this.confirmReclamoStep.bind(this),
            this.motivoStep.bind(this),
            this.reclamoStep.bind(this),
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
        console.log(step)
        // We can send messages to the user at any point in the WaterfallStep.
        await step.context.sendActivity(`Hola! \uD83D\uDC4B Bienvenido al canal de atención de peticiones, quejas y reclamos de Movistar. A continuación, te solicitaremos algunos datos para atender tu solicitud. \uD83D\uDE0A`);
  
        // WaterfallStep always finishes with the end of the Waterfall or with another dialog; here it is a Prompt Dialog.
        // Running a prompt here means the next WaterfallStep will be run when the users response is received.
        return await step.prompt(TIPO_DOCUMENTO_CHOICE_PROMPT, {
            prompt: 'Por favor, indicanos tú tipo de documento de identificacion:',
            choices: ChoiceFactory.toChoices(['\ud83d\udccd C.C.', '\ud83c\udf0e C.E.'])
        });
    }
  
    async numeroDocumentoStep(step) {
        step.values.tipoDocumentoIdentidad = step.result.value;
        return await step.prompt(NUMERO_DOCUMENTO_PROMPT, 'Por favor escribe tú número de documento (Ejemplo: 9999999999)');
    }
  
  //QUITÉ DESDE AQUI

    async confirmCunStep(step) {
        step.values.numeroDocumentoIdentidad = step.result;
        return await step.prompt(CONFIRM_CUN_PROMPT, '¿Deseas consultar el estado de una reclamación ya radicada?',['si', 'no'] );
    }
        
    async confirmReclamoStep(step){
        step.values.confirmCUN = step.result;
        if (step.values.confirmCUN) { 
            return await step.prompt(NUMERO_RADICADO_PROMPT, 'Por favor escribe el CUN (Código Unico Numerico) que deseas consultar:');
        }else{
            return await step.prompt(MOTIVO_PROMPT, 'Escribe detalladamente el motivo de tu solicitud:');
        }
    }
    
    async motivoStep(step) {
        if (step.values.confirmCUN) { 
            step.values.numeroCUN = step.result;
            return await step.prompt(CONFIRM_RECLAMO_PROMPT, '¿Deseas RECLAMO****?',['si', 'no'] );
        }else{
            step.values.motivo = step.result;
            return await step.next(-1);
        }
    }

    async reclamoStep(step){
        if (step.values.confirmCUN) { 
            step.values.reclamo = step.result;
            if (step.values.reclamo){
                return await step.prompt(MOTIVO_PROMPT, 'Escribe detalladamente el reclamo:');
            }else{
                step.values.motivo = "";
                //return await step.prompt(RETURN_PROMPT, 'Escribe OK2');
              // await step.context.sendActivity('ok en un segundo arenderemos tu peticion');
              return await step.next(-1);
            }
            
        } else {
            return await step.next(-1);
        }
    }

    //step.values.confitrmRadicod = step.result;
  
    async finalConfirmStep(step) {
        if (step.values.reclamo){
            step.values.motivo = step.result;
        }

      let msg = step.values.email === -1 ? 'Tambíen te estaremos informando por este canal. ' : `El historial de esta incidencia sera enviada a tu correo electrónico ${ step.values.email }.`;
      msg =     'Te presento un resumen de la información que nos haz dado hasta el momento: '
              + `Haz registrado la PQR con número radicado ${step.values.numeroRadicado} `
              + `identificado con ${ step.values.tipoDocumentoIdentidad } ${ step.values.numeroDocumentoIdentidad }`
              
      await step.context.sendActivity(msg);
  
      // WaterfallStep always finishes with the end of the Waterfall or with another dialog, here it is a Prompt Dialog.
      return await step.prompt(FINAL_CONFIRM_PROMPT, '¿Esta información es correcta?', ['si', 'no'] );
    }
  
    async summaryStep(step) {
      if (step.result) {
          const registroPQR = await this.registroPQR.get(step.context, new RegistroPQR());
  
          console.log(step)
  
        //  registroPQR.tipoDocumentoIdentidad = step.values.tipoDocumentoIdentidad;
          registroPQR.numeroDocumentoIdentidad = step.values.numeroDocumentoIdentidad;
          registroPQR.numeroCUN = step.values.numeroCUN;
          registroPQR.motivoPQR = step.values.motivo;
          registroPQR.fromId = step.context.activity.from.id
          registroPQR.conversationId = step.context.activity.conversation.id
  
          await step.context.sendActivity('Registraremos tu solicitud en nuestro sistema para dar inicio a su gestión.');
           try{
              await this.procesoBPM.iniciarCaso(registroPQR)
              await step.context.sendActivity('Muy bien! Tu solicitud ha sido registrada exitosamente, la resolución de tu solicitud puede tomar unos minutos, te pedimos un poco de paciencia.')
           } catch(ex){
              await step.context.sendActivity('Parece que hubo un problema registrando tu solicitud, por favor intentalo mas tarde');
           }
           
      } else {
            await step.context.sendActivity('¡Oh no! Pero no te preocupes podemos intentarlo de nuevo.');
        }
  
        // WaterfallStep always finishes with the end of the Waterfall or with another dialog, here it is the end.
        return await step.endDialog();
    }
  }
  
  module.exports.RegistroPQRDialog = RegistroPQRDialog;