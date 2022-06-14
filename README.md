# RESS backend

## Instalation

Backend part of this application is initialized using Spring Initializr on the following link: https://start.spring.io/ where name of project, description of project and package chosen as Jar were stated. Type of project is Maven Project and selected language is Java. Moreover, it is unnecessary to use Java vesrion 17. \
Next step is to add two dependencies: *Spring Web* which uses REST and Tomcat as a default embedded server and pulls in all dependencies related to web development. Second dependency is *Lombok* which helps to reduce boilerplate code. \
Have an IDE installed (such as Intellij). \
Clone this repository using the following command: git clone https://github.com/AmilM7/ress-backend.git \
After clonning the repository, open the pom.xml file in the IDE and confirm to open it as a project. \
Click the run/debug icon or Shift+F10 on the keyboard. \
The application is running in your browser at localhost:8080. 

## Enviroment variables

Several enviroment variables are used in application.yml file regarding the database: \
*on server*: **port: ${APPLICATON_PORT:8080}** which runs application on port 8080 \
\
*on datasource*: **username: ${DB_USER_NAME:db_name}** and  **password: ${DB_USER_PASSWORD:db_password}** which are used for authentication of a database and 
**url: jdbc:postgresql://${APP_DB_URL:localhost}:**${**APP_DB_PORT:5432}/${NAME_APP_DB:ress_database}** which states on which url data source will be available.\
\
*on service ui*: **url: ${FRONTEND-API-URL:http://localhost:4200}** which states on which port will it communicate with frontend part of application.\
\
*on security jwt token*: **secret-key:** ${SECRET_KEY:wipjd03kmv[wh567gmcvf2p0fh<niyedjgvdckjhkkhVvj;'\986546&*6865&^} which is used for hashing passwords and 
**token-duration-minutes: ${TOKEN_DURATION_MINUTES:600}**.\

**Deployment**\
This application is deployed on Heroku from where requests are comming. 
