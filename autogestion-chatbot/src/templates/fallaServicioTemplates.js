module.exports.fallaServicioTemplates = [
  {
    id: "msg_usuario_no_registrado",
    content: "No aparece ningún servicio asociado a tu número de documento de identidad. Recuerda que este es el canal de soporte técnico de Empresa de Telecomunicaciones Colombia."
  },
  {
    id: "msg_estado_servicio",
    content: "Hola {nombre}, tu servicio se encuentra {estadoServicio}. Tu valor a pagar es {valorPagar}, preferiblemente antes del {fechaCorte}"
  },
  {
    id: "msg_servicio_bloqueado_HADA",
    content: "Hola {nombre}, tu servicio se encuentra actualmente {estadoServicioHADA}. Por el siguiente motivo: {motivoBloqueoHADA}"
  },
  {
    id: "msg_servicio_suspendido",
    content: "Hola \uD83D\uDC4B {nombre}, tu servicio se encuentra actualmente {estadoFinancieroServicio}. Por el siguiente motivo: {motivoSuspension}. Para mayor informacion, por favor comuniquese a la linea 01 8000 xxxx."
  },
  {
    id: "msg_solicitud_reactivacion",
    content: "Hola \uD83D\uDC4B {nombre}, verificamos que te encuentras a paz y salvo con la compañía, pero el servicio aparece en estado '{estadoFinancieroServicio}', se enviará automaticamente una solicitud de reactivación para puedas disfrutar de tus servicios lo mas pronto posible."
  },
  {
    id: "msg_servicio_averias",
    content: "Hola \uD83D\uDC4B {nombre}, tu servicio tiene actualmente la siguiente avería reportada: '{titulo}', descripción: '{descripcion}', con una fecha estimada para su resolución para: {fechaEstimadaResolucion}. Estamos trabajando para darte una pronta solución."
  },
  {
    id: "msg_servicio_peticiones",
    content: "Hola \uD83D\uDC4B {nombre}, tu servicio tiene actualmente la siguiente petición reportada: '{titulo}', descripción: '{descripcion}', con una fecha estimada para su resolución para: {fechaEstimadaResolucion}. Estamos trabajando para darte una pronta solución."
  },
  {
    id: "msg_falla_masiva",
    content: "Hola \uD83D\uDC4B {nombre}, tu servicio esta afectado una falla masiva identificada: '{descripcion}', con una fecha estimada para su resolución para: {fechaEstimadaResolucion}. Estamos trabajando para darte una pronta solución."
  },
  {
    id: "msg_generacion_averia",
    content: "Hola \uD83D\uDC4B {nombre}, hemos realizado algunas acciones automaticas para resolver tu problema, pero al parecer este persiste. Hemos generado una avería a tu linea y nos estaremos contactando contigo para darte una pronta solución"
  },
  {
    id: "msg_falla_resuelta_automaticamente",
    content: "Nos complace mucho que tu falla se haya resuelto, recuerda, cuando tengas algún inconveniente con tus servicios fijos o moviles, estamos aquí 24/7 para servirte y lo mejor todo fué automaticamente! \uD83D\uDE0A"
  },
  {
    id: "msg_falla_resuelta",
    content: "Nos complace mucho que tu falla se haya resuelto, recuerda, cuando tengas algún inconveniente con tus servicios fijos o moviles, estamos aquí 24/7 para servirte. \uD83D\uDE0A"
  },
  {
    id:"msg_generacion_PQR",
    content: "Hola \uD83D\uDC4B {nombre}, lamentamos no poder resolver tu problema resolver tu problema, pero al parecer este persiste. Hemos generado una Petición con id: {idIncidenciaGenerada} asociada a tu linea y nos estaremos contactando contigo para darte una pronta solución"
 
  },
  {
    id: "fallaContinuaConfirmacionRequest",
    content: "Hemos realizado algunas acciones para tratar de corregir tu problema, así que te invitamos a que verifiques tus servicios ¿Vale?"
  },
  {
    id: "satisfaccionUsuarioRequest",
    content: "Para nosotros es muy importante tu opinión. Nos gustaría que nos respondieras una pregunta ¿Te parece?"
  }
]