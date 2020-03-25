
const { fallaServicioTemplates } = require('./fallaServicioTemplates')

class TemplateManager {

  constructor(){
    this.templates = fallaServicioTemplates;
  }

  findTemplateAndReplaceParams(templateId, params) {
      let template = this.templates.filter((template) => template.id === templateId)
      let result
      if(template){
        result = template[0].content;
        if(params) {
          let key
          for(const param of params){
            key = '{'+param.name+'}'; 
            result = result.replace(key, param.value)
          }
        }
      } else {
        throw new Error(`TemplateManager no hay template asociado al templateId: ${templateId}`)
      }

      return result;
  }
}

module.exports = { TemplateManager };
