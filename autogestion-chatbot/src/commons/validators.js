class Validators {
  async msisdnOLineaFijaPromptValidator(promptContext) {
    // This condition is our validation rule. You can also change the value at this point.
    return promptContext.recognized.succeeded && true
  }

  async emailValidator(promptContext) {
    // This condition is our validation rule. You can also change the value at this point.
    return promptContext.recognized.succeeded && true
  }

  async numeroDocumentoPromptValidator(promptContext) {
    // This condition is our validation rule. You can also change the value at this point.
    return promptContext.recognized.succeeded && true
  }

  async numeroRadicadoPromptValidator(promptContext) {
    // This condition is our validation rule. You can also change the value at this point.
    return promptContext.recognized.succeeded && true
  }
}

module.exports.Validators = Validators;