# REST Examples

# Server
Glassfish

# Language
java


# Start domains
start-domain --domaindir /home/etudiants/inf/uapv1802814/domains


# compilation
javac -d WEB-INF/classes notebook/*.java

jar cvf notebook.war WEB-INF/* *.html

asadmin deploy --force notebook.war 
