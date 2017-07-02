This is a servlet quickstart. See comments in code for further details.

To deploy:

1) Start tomcat; if it runs elsewhere than `localhost:8080`, point to it from `pom.xml`.
2) Create a tomcat user with the `manager-script` role; see username and passwod in `pom.xml`.
3) Execute `mvn tomcat7:deploy` (or any other command, like redeploy. If using other version of tomcat, change the pom.xml pluggin accordingly).
4) `localhost:8080/Servlet` and `localhost:8080/Servlet/home` should be served by the servlet.
