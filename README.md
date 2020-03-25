#Entrega Final Procesos de Negocio 2020
##Instalación DOCKER

Fuente: https://www.hostinger.com/tutorials/how-to-install-and-use-docker-on-ubuntu/

sudo apt-get install  curl apt-transport-https ca-certificates software-properties-common

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

sudo apt update

sudo apt install docker-ce

##Instalación DOCKER-COMPOSE

Fuente: https://phoenixnap.com/kb/install-docker-compose-ubuntu

Importante para revisar las versiones: https://github.com/docker/compose/releases

sudo curl -L "https://github.com/docker/compose/releases/download/1.24.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose

docker-compose -version


##Componentes 


Integración con redes sociales: Facebook, Twitter

Motor de Reglas de Negocio (Open Rules, Visual Rules, ILog Rules, Drools)
Complex Event Processing: Esper
herramienta BI: Pentaho
Gestion Documental: Alfresco, esta parte se realiza con el motor de procesos Activity
ERP: Openbravo
CRM: Salesforce web

Instalados:



Openbravo
Alfresco

Salesforce
Shiddi
DROOLs          Ok
Bonita          Ok
Docker          Ok



##Configuración Bonita

Fuente: https://hub.docker.com/_/bonita/

En el portal de Azure hay que garantizar en el blade de Configuración > Redes que las reglas de firewall para el puerto 8080 esten abiertas

Vamos a usar la configuración del stack de bonita + postgres SQL

Run sudo docker stack deploy -c bonita-stack.yml bonita-stack (or docker-compose -f bonita-stack.yml up), wait for it to initialize completely, and visit http://swarm-ip:8080, http://localhost:8080, or http://host-ip:8080 (as appropriate).

Nosotros usamos:

sudo docker-compose -f bonita-stack.yml up -d

Entramos al link
http://52.179.152.232:8080/bonita

usuario: tech_user, pass: secret


##Configuración DROOLS - KIE Server

Fuente: https://medium.com/@hasnat.saeed/setup-jboss-drools-workbench-and-kie-execution-server-on-wildfly-14-on-ubuntu-18-04-using-docker-e87b10f301ad

sudo docker-compose -f drools-stack.yml up -d

Entramos al link
http://52.179.152.232:8081/business-central/kie-wb.jsp
usuario: admin, pass: admin

http://52.179.152.232:8180/kie-server/services/rest/server


A mas detalle: 
sudo docker run -p 8081:8080 -p 8001:8001 -e JAVA_OPTS="-server -Xms1024m -Xmx1024m -Djava.net.preferIPv4Stack=true -Dfile.encoding=UTF-8" -v /home/ubuntu/wb_git:/opt/jboss/wildfly/bin/.niogit:Z -d --name drools-workbench jboss/drools-workbench-showcase:latest

sudo docker run -p 8180:8080 -d --name kie-server --link drools-workbench:kie-wb jboss/kie-server-showcase:latest


##Configuración clientes de prueba

-- Lineas Moviles

3176455488: cliente registrado, activo.														Jairo Alexei Macias,		CC 1096035442
3176455489: cliente registrado, inactivo, bloqueado en HADA									James Alexander Molina,		CC 1096035443
3176455490: cliente registrado, inactivo, no bloqueado en HADA, suspendido, 				John Armando Montoya, 		CC 1096035444
3176455491: cliente registrado, inactivo, no bloqueado en HADA, suspendido a paz y salvo, 	Jhonatan Alejandro Moreno, 	CC 1096035445
3176455492: cliente registrado, inactivo, no bloqueado en HADA, no suspendido, con averias, Jhon Alexander Mora, 		CC 1096035446
3176455493: cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, Jheison Alejandro Morales, 	CC 1096035447

-- Lineas fijas

0318340954: cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, peticion en curso,  						Maria Botero, 				CC 1096035441
0318340955: cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, sin peticion en curso, con falla masiva		Mariana Boso, 				CC 1096035440
0318340956: cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, sin peticion en curso, sin falla masiva 	Marta Buena, 				CC 1096035439
0318340957: cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, sin peticion en curso, sin falla masiva		Marina Bastidas,			CC 1096035438
0318340958: cliente registrado, inactivo, no bloqueado en HADA, no suspendido, sin averias, sin peticion en curso, sin falla masiva		Marbel Baca,				CC 1096035437


##Auditoria Codigos

ST001: VALIDAR_CLIENTE
FIN_USUARIO_NO_REGISTRADO
ST003: VALIDAR_ESTADO_GENERAL_SERVICIO
VALIDAR_ESTADO_SERVICIO_HADA
ST005: FIN_CLIENTE_SERVICIO_ACTIVO
VALIDAR_ESTADO_FINANCIERO_HADA
FIN_INFORMAR_SERVICIO_BLOQUEADO
VERIFICAR_SERVICIO_AVERIAS
FIN_SOLICITUD_REACTIVACION
ST013: VERIFICAR_PETICIONES
FIN_SERVICIO_CON_PETICIONES_ABIERTAS
VERIFICAR_FALLA_MASIVA
VALIDAR_REGLAS_NEGOCIO
FIN_SERVICIO_AFECTADO_FALLA_MASIVA
ST023: FIN_GENERACION_AVERIA
ST024:FIN_FALLA_RESUELTA_AUTOMATICAMENTE
ST026: FIN_FALLA_RESUELTA_ASESOR
ST027: FIN_GENARACION_PETICION

##Twilio Sandbox
join dangerous-percent
