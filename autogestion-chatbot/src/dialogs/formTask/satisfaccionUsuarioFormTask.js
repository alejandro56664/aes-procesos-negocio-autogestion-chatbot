
const {
  ChoiceFactory,
  ChoicePrompt,
  ComponentDialog,
  ConfirmPrompt,
  DialogSet,
  DialogTurnStatus,
  WaterfallDialog
} = require('botbuilder-dialogs');

const WATERFALL_DIALOG = 'WATERFALL_DIALOG_NSU';

const SATISFACCION_USUARIO_CHOICE_PROMPT = 'SATISFACCION_USUARIO_CHOICE_PROMPT';

class SatisfaccionUsuarioFormTask extends ComponentDialog {
  constructor(userState, procesoBPM) {
      super('satisfaccionUsuarioFormTask');

      this.procesoBPM = procesoBPM;

      this.addDialog(new ChoicePrompt(SATISFACCION_USUARIO_CHOICE_PROMPT));


      this.addDialog(new WaterfallDialog(WATERFALL_DIALOG, [
          this.satisfaccionUsuario.bind(this),
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

  async satisfaccionUsuario(step) {
      
      // WaterfallStep always finishes with the end of the Waterfall or with another dialog; here it is a Prompt Dialog.
      // Running a prompt here means the next WaterfallStep will be run when the users response is received.
      return await step.prompt(SATISFACCION_USUARIO_CHOICE_PROMPT, {
          prompt: '¿Cómo te pareció la experiencia en este canal?',
          choices: ChoiceFactory.toChoices(['\ud83d\udc4d ¡Super!', '\ud83d\udc4e Meh'])
      });
  }


  async summaryStep(step) {
    let satisfaccion =  step.result.value === '\ud83d\udc4d ¡Super!' ? 'POSITIVO': 'NEGATIVO'
      
    try{
        console.log(`Se va a ejecutar la tarea BPM ${this.idTarea}, con resultado: ${satisfaccion}`)
        await this.procesoBPM.ejecutarTareaUsuario(this.idTarea, {satisfaccion: satisfaccion})
        await step.context.sendActivity('Gracias por ayudarnos a mejorar')
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

module.exports.SatisfaccionUsuarioFormTask = SatisfaccionUsuarioFormTask;