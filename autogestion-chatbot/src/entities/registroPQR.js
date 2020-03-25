
class RegistroPQR {
  constructor(tipoDocumentoIdentidad, numeroDocumentoIdentidad, nombres, apellidos, direccionResidencia, numeroRadicado, email, fromId, conversationId) {
      this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
      this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
      this.nombres = nombres;
      this.apellidos = apellidos;
      this.direccionResidencia = direccionResidencia;
      this.numeroRadicado = numeroRadicado;
      this.email = email;
      //this data is util for reply
      this.fromId = fromId;
      this.conversationId = conversationId;
  }
}

module.exports.RegistroPQR = RegistroPQR;