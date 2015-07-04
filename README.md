##EasyPack Maven archetypes

The EasyPack Archetype project provides a list of Maven archetypes for creating and configuring projects that use the [EasyPack Maven packagings](https://github.com/easypack/easypack-maven-plugin).

All archetypes create a standard Maven project ready to be built and run, with a configured pom (including minimum required dependencies based on the archetype) and a Start class with necessary code for starting the application.

###Usage

The way to use any of the archetypes, is the same for any Maven archetype. 

`mvn archetype:generate -DarchetypeGroupId=com.github.easypack  -DarchetypeArtifactId='archetype-id' -DarchetypeVersion=1.0`

The packaging type is required, so it is necessary to provide one of the EasyPack packaging: jzip, jtar or jtargz.

After creation, a build can be triggered, then the final artifact can be unpacked, and the application run by using the bin/start script.

###Archetypes

* _**easypack-archetype-quickstart**_: for quick starting a simple project, it creates the folders, a configured pom and a Start class.

* _**easypack-archetype-jetty**_: creates a project that uses an [embedded Jetty](http://www.eclipse.org/jetty/documentation/current/embedding-jetty.html), with a configured pom including the minimum required dependencies and a Start class that runs the jetty container with a Servlet example.

* _**easypack-archetype-tomcat**_: creates a project that uses an [embedded Tomcat](http://tomcat.apache.org/), with a configured pom including the minimum required dependencies and a Start class that runs the Tomcat container with a Servlet example.

* _**easypack-archetype-undertow**_: creates a project that uses [Undertow](http://undertow.io/), with a configured pom including the minimum required dependencies and a Start class that runs the Undertow container with a Servlet example.

###Not yet released but

We are testing the archetypes in order to release a stable version. But if you want to try it, and help us testing meanwhile, there is a beta version that can be used. 

Once the project is created you can try this:

1. Build the project.
2. Unpack the generated artifact (untar or unzip)
3. Run the bin/start script
4. If an embedded server project was built, hit localhost:8080

###Examples

`mvn archetype:generate -DarchetypeGroupId=com.github.easypack  -DarchetypeArtifactId=easypack-archetype-quickstart -DarchetypeVersion=1.0.BETA`

`mvn archetype:generate -DarchetypeGroupId=com.github.easypack  -DarchetypeArtifactId=easypack-archetype-jetty -DarchetypeVersion=1.0.BETA`

`mvn archetype:generate -DarchetypeGroupId=com.github.easypack  -DarchetypeArtifactId=easypack-archetype-tomcat -DarchetypeVersion=1.0.BETA`

`mvn archetype:generate -DarchetypeGroupId=com.github.easypack  -DarchetypeArtifactId=easypack-archetype-undertow -DarchetypeVersion=1.0.BETA`
