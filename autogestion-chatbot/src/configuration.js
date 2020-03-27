module.exports.Configuration = {
  botframeworkAdapter:{
      appId: process.env.MicrosoftAppId,
      appPassword: process.env.MicrosoftAppPassword
  },
  twilioWhatsAppAdapter: {
      accountSid: 'AC68f2221e23cf2c9cad5ba5cb201e09db', // Account SID
      authToken: 'e86dda4d8f654f931b13637f158a72ee', // Auth Token
      phoneNumber: 'whatsapp:+14155238886', // The From parameter consisting of whatsapp: followed by the sending WhatsApp number (using E.164 formatting)
      endpointUrl: 'https://5c09811b.ngrok.io/api/whatsapp/messages' // Endpoint URL you configured in the sandbox, used for validation
  },
  bpm: { 
    bpmUsername: 'autogestion.bot', 
    bpmPassword: 'bpm', 
    processName: 'autogestion-reporte-fallas-backup'
  },
  bonita: {
    host:  process.env.BPM_HOST || 'localhost',
    port:  process.env.BPM_PORT || 8080
  },
  defaultChannel: 'whatsapp' //botframework
  
};