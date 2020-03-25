
class ReporteFallaServicio {
  constructor(tipoDocumentoIdentidad, numeroDocumentoIdentidad, tipoServicio, idServicio, descripcionFalla, email, fromId, conversationId) {
      this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
      this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
      this.tipoServicio = tipoServicio;
      this.idServicio = idServicio;
      this.descripcionFalla = descripcionFalla;
      this.email = email;
      //this data is util for reply
      this.fromId = fromId;
      this.conversationId = conversationId;
  }
}

module.exports.ReporteFallaServicio = ReporteFallaServicio;