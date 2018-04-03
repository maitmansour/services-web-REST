export CLASSPATH=$CLASSPATH:/usr/local/stow/glassfish4/glassfish/modules/javax.ws.rs-api.jar
export CLASSPATH=$CLASSPATH:/usr/local/stow/glassfish4/glassfish/modules/jersey-client.jar 
export CLASSPATH=$CLASSPATH:/usr/local/stow/glassfish4/glassfish/modules/jersey-common.jar
export CLASSPATH=$CLASSPATH:/usr/local/stow/glassfish4/glassfish/modules/jersey-guava.jar


javac -d WEB-INF/classes sender/*.java
