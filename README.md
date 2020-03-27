# Entrega Final Procesos de Negocio 2020

## Introducción

En este repositorio se guardan todos los componentes construidos para la entrega final de la materia procesos de negocio del año 2020-I. 
El proceso consiste en el manejo automático del reporte de fallas fijas y móviles para una empresa de Telecomunicación y su gestión a través de un
canal digital como WhatsApp.

En el repositorio ponemos a disposición:
- el proyecto de bonita
- el chatbot
- la capa de integración
- el script de setup de la base de datos (con datos de prueba)
- proyecto en Postman para probar servicios REST
- proyecto en SOAPUI para probar servicios SOAP
- proyecto de PowerBI
- algo de documentación como diagramas y una presentación.

Para finalizar, se puede ver algunas explicaciones en video [aquí](https://www.youtube.com/playlist?list=PLVpdjqPRHvN48MK2RlaElaxpPITc0hSp8)


## Instalación DOCKER

Fuente: https://www.hostinger.com/tutorials/how-to-install-and-use-docker-on-ubuntu/

sudo apt-get install  curl apt-transport-https ca-certificates software-properties-common

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

sudo apt update

sudo apt install docker-ce

## Instalación DOCKER-COMPOSE

Fuente: https://phoenixnap.com/kb/install-docker-compose-ubuntu

Importante para revisar las versiones: https://github.com/docker/compose/releases

sudo curl -L "https://github.com/docker/compose/releases/download/1.24.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose

docker-compose -version

## Componentes

- Integración con redes sociales: Twilio - WhatsApp
- Salesforce      Ok
- DROOLs          Ok
- Bonita          Ok
- Docker          Ok
- PowerBI	      Ok

## Configuración Bonita

Fuente: https://hub.docker.com/_/bonita/

En el portal de Azure hay que garantizar en el blade de Configuración > Redes que las reglas de firewall para el puerto 8080 esten abiertas

Vamos a usar la configuración del stack de bonita + postgres SQL

Run sudo docker stack deploy -c bonita-stack.yml bonita-stack (or docker-compose -f bonita-stack.yml up), wait for it to initialize completely, and visit http://swarm-ip:8080, http://localhost:8080, or http://host-ip:8080 (as appropriate).

Nosotros usamos:

sudo docker-compose -f bonita-stack.yml up -d

Entramos al link
http://52.179.152.232:8080/bonita

usuario: tech_user, pass: secret

## Configuración DROOLS - KIE Server

Fuente: <https://medium.com/@hasnat.saeed/setup-jboss-drools-workbench-and-kie-execution-server-on-wildfly-14-on-ubuntu-18-04-using-docker-e87b10f301ad>

sudo docker-compose -f drools-stack.yml up -d

Entramos al link
<http://52.179.152.232:8081/business-central/kie-wb.jsp>
usuario: admin, pass: admin

<http://52.179.152.232:8180/kie-server/services/rest/server>

A mas detalle:
sudo docker run -p 8081:8080 -p 8001:8001 -e JAVA_OPTS="-server -Xms1024m -Xmx1024m -Djava.net.preferIPv4Stack=true -Dfile.encoding=UTF-8" -v /home/ubuntu/wb_git:/opt/jboss/wildfly/bin/.niogit:Z -d --name drools-workbench jboss/drools-workbench-showcase:latest

sudo docker run -p 8180:8080 -d --name kie-server --link drools-workbench:kie-wb jboss/kie-server-showcase:latest

## Configuración clientes de prueba

### Lineas Moviles

- 3176455488: CC 1096035442, cliente registrado, activo.Jairo Alexei Macias,
- 3176455489: CC 1096035443, cliente registrado, inactivo, bloqueado en HADA, James Alexander Molina
- 3176455490: CC 1096035444, cliente registrado, inactivo, no bloqueado en HADA, suspendido, John Armando Montoya
- 3176455491: CC 1096035445, cliente registrado, inactivo, no bloqueado en HADA, suspendido a paz y salvo, Jhonatan Alejandro Moreno
- 3176455492: CC 1096035446, cliente registrado, inactivo, no bloqueado en HADA, no suspendido, con averias, Jhon Alexander Mora
- 3176455493: CC 1096035447, cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, Jheison Alejandro Morales

### Lineas fijas

- 0318340954: CC 1096035441, cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, peticion en curso, Maria Botero
- 0318340955: CC 1096035440, cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, sin peticion en curso, con - falla masiva, Mariana Boso
- 0318340956: CC 1096035439, cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, sin peticion en curso, sin  falla masiva Marta Buena
- 0318340957: CC 1096035438, cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, sin peticion en curso, sin falla masiva Marina Bastidas,
- 0318340958: CC 1096035437, cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, sin peticion en curso, sin falla masiva Marbel Baca

## Auditoria Codigos

- ST001: VALIDAR_CLIENTE
- ST002: FIN_USUARIO_NO_REGISTRADO
- ST003: VALIDAR_ESTADO_GENERAL_SERVICIO
- ST004: VALIDAR_ESTADO_SERVICIO_HADA
- ST005: FIN_CLIENTE_SERVICIO_ACTIVO
- ST006: VALIDAR_ESTADO_FINANCIERO_HADA
- ST007: FIN_INFORMAR_SERVICIO_BLOQUEADO
- ST009: VERIFICAR_SERVICIO_AVERIAS
- ST010: FIN_SOLICITUD_REACTIVACION
- ST013: VERIFICAR_PETICIONES
- ST014: FIN_SERVICIO_CON_PETICIONES_ABIERTAS
- ST015: VERIFICAR_FALLA_MASIVA
- ST016: VALIDAR_REGLAS_NEGOCIO
- ST017: FIN_SERVICIO_AFECTADO_FALLA_MASIVA
- ST023: FIN_GENERACION_AVERIA
- ST024: FIN_FALLA_RESUELTA_AUTOMATICAMENTE
- ST026: FIN_FALLA_RESUELTA_ASESOR
- ST027: FIN_GENARACION_PETICION

### Finales
- ST001: FIN_USUARIO_NO_REGISTRADO
- ST005: FIN_CLIENTE_SERVICIO_ACTIVO
- ST007: FIN_INFORMAR_SERVICIO_BLOQUEADO
- ST010: FIN_SOLICITUD_REACTIVACION
- ST014: FIN_SERVICIO_CON_PETICIONES_ABIERTAS
- ST017: FIN_SERVICIO_AFECTADO_FALLA_MASIVA
- ST023: FIN_GENERACION_AVERIA
- ST024: FIN_FALLA_RESUELTA_AUTOMATICAMENTE
- ST026: FIN_FALLA_RESUELTA_ASESOR
- ST027: FIN_GENARACION_PETICION
## Twilio Sandbox

join dangerous-percent
