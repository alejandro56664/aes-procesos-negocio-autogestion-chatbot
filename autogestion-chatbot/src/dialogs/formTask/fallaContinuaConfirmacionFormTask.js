
const {
  ChoiceFactory,
  ChoicePrompt,
  ComponentDialog,
  ConfirmPrompt,
  DialogSet,
  DialogTurnStatus,
  WaterfallDialog
} = require('botbuilder-dialogs');

const WATERFALL_DIALOG = 'WATERFALL_DIALOG_FCC';

const FALLA_CONTINUA_CHOICE_PROMPT = 'FALLA_CONTINUA_CHOICE_PROMPT';

class FallaContinuaConfirmacionFormTask extends ComponentDialog {
  constructor(userState, procesoBPM) {
      super('fallaContinuaConfirmacionFormTask');

      this.procesoBPM = procesoBPM;

      this.addDialog(new ChoicePrompt(FALLA_CONTINUA_CHOICE_PROMPT));


      this.addDialog(new WaterfallDialog(WATERFALL_DIALOG, [
          this.fallaContinuaConfirmacion.bind(this),
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

  async fallaContinuaConfirmacion(step) {
      
      // WaterfallStep always finishes with the end of the Waterfall or with another dialog; here it is a Prompt Dialog.
      // Running a prompt here means the next WaterfallStep will be run when the users response is received.
      return await step.prompt(FALLA_CONTINUA_CHOICE_PROMPT, {
          prompt: '¿La falla que reportaste persiste?',
          choices: ChoiceFactory.toChoices(['Continua', '¡Ya se arregló!'])
      });
  }


  async summaryStep(step) {
    let fallaContinua =  step.result.value === 'Continua'
      
    try{
        console.log(`Se va a ejecutar la tarea BPM ${this.idTarea}, con resultado: ${fallaContinua}`)
        await this.procesoBPM.ejecutarTareaUsuario(this.idTarea, {accionesAutomaticasEfectivas: !fallaContinua})
        await step.context.sendActivity('Gracia por tu respuesta, por favor espera un momento.')
    } catch(ex){
        console.log(ex)
        await step.context.sendActivity('Parece que hubo un problema procesando tu respuesta, por favor intentalo mas tarde');
    }

      // WaterfallStep always finishes with the end of the Waterfall or with another dialog, here it is the end.
      return await step.endDialog();
  }


  //auxiliar para integrar con BPN
  asignBPMTask(taskId) {
      this.idTarea = taskId;
  }

}

module.exports.FallaContinuaConfirmacionFormTask = FallaContinuaConfirmacionFormTask;