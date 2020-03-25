
const axios = require('axios');
const qs = require('qs');
let defaultConfig = {
  host:  process.env.BPM_HOST || 'localhost',
  port:  process.env.BPM_PORT || 8080
}

class BonitaIntegration {

  constructor(config) {
    //cargamos valores por defecto
    this.config = config || defaultConfig
    this.host = `http://${this.config.host}:${this.config.port}`
  }

  async login(username, password) {
    this.username = username
    this.password = password
    let urlLogin = `${this.host}/bonita/loginservice`

    const data = { 
      'username': username,
      'password': password,
      'redirect': false
    }

    const options = {
      method: 'POST',
      headers: { 'content-type': 'application/x-www-form-urlencoded' },
      data: qs.stringify(data),
      url: urlLogin,
      withCredentials: true
    }

    let result = await axios(options)
    this.cookies = result.headers['set-cookie']
    console.log('Se hace login en el bpm de bonita')
    return
    //hacer request a POST pathLogin
    //Content-Type: application/x-www-form-urlencoded
    //body
    //username: username
    //password: password
    //redirect: false
    //obtener las cookies y guardarlas
  }

  async startCase(processId, data){
    let urlStartCase = `${this.host}/bonita/API/bpm/process/${processId}/instantiation`

    const options = {
      method: 'POST',
      headers: { 
        'X-Bonita-API-Token': this.getTokenFromCookies(this.cookies),
        Cookie: this.cookies.join(';')
      },
      url: urlStartCase,
      withCredentials: true,
      data: data
    }
    await axios(options)
    return
    //hacer request a POST pathStartCase
    //header: X-Bonita-API-Token: sacar de la cookie
    //mandar cookies guardadas
  }

  async executeUserTask(userTaskId, data){
    let urlExecuteTask= `${this.host}/bonita/API/bpm/userTask/${userTaskId}/execution?assign=true`

    const options = {
      method: 'POST',
      headers: { 
        'X-Bonita-API-Token': this.getTokenFromCookies(this.cookies),
        Cookie: this.cookies.join(';')
      },
      url: urlExecuteTask,
      withCredentials: true,
      data: data
    }
    await axios(options)
    console.log(`Se envia la tarea: ${userTaskId} para su ejecución con la data: ${data}`)
    return
    //hacer request a POST pathStartCase
    //header: X-Bonita-API-Token: sacar de la cookie
    //mandar cookies guardadas
  }

  async getContextTask(userTaskId, varName){
    let link = await this.getLinkContextTask(userTaskId, varName)
    console.log(`Se obtiene el link: ${link} la variable de negocio ${varName} en el contexto de la tarea: ${userTaskId}`)
    return await this.getContextTaskWithLink(link)
  }

  async getLinkContextTask(userTaskId, varName){
    let urlLinkGetContextTask= `${this.host}/bonita/API/bpm/userTask/${userTaskId}/context`

    const options = {
      method: 'GET',
      headers: { 
        'X-Bonita-API-Token': this.getTokenFromCookies(this.cookies),
        Cookie: this.cookies.join(';')
      },
      url: urlLinkGetContextTask,
      withCredentials: true
    }

    //obtenemos el link
    let response = await axios(options)
    let link;
    //filtrar los objetos hasta obtener el nombre
    varName = varName + '_ref';
    for(const businessVarName in response.data){
      if(businessVarName === varName){
        link = response.data[businessVarName].link;
        break;
      }
    }
    
    
    return link;
  }

  async getContextTaskWithLink(link){
    let urlLink= `${this.host}/bonita/${link}`
    const options = {
      method: 'GET',
      headers: { 
        'X-Bonita-API-Token': this.getTokenFromCookies(this.cookies),
        Cookie: this.cookies.join(';')
      },
      url: urlLink,
      withCredentials: true
    }
    let result = await axios(options)
    return result.data
  }


  async getProcessIdByName(processName){
    let firstTenProcess = await this.getProcess(10)
    let id;
    //filtrar los objetos hasta obtener el nombre
    for(const process of firstTenProcess){
      if(process.name === processName){
        id = process.id;
        return id
      }
    }
  }

  async getProcess(limit){
    let urlGetProcess= `${this.host}/bonita/API/bpm/process?p=0&c=${limit}`

    const options = {
      method: 'GET',
      headers: { 
        'X-Bonita-API-Token': this.getTokenFromCookies(this.cookies),
        Cookie: this.cookies.join(';')
      },
      url: urlGetProcess,
      withCredentials: true
    }

    //obtenemos el link
    let response = await axios(options)
    return response.data

  }

  getTokenFromCookies(cookies) {
    //TODO: insecure 
    return cookies[2].split(';')[0].split('=')[1]
  }
}


module.exports = { BonitaIntegration };