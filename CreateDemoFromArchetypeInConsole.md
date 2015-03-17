# Introduction #

This document briefly describes how to generate a full-featured JAnnocessor demo project from the Maven archetype _jannocessor-sample-archetype_ in console.


# Generating the Demo Project #

In a console type:

```
mvn archetype:generate -DgroupId=jannocessor-demo -DartifactId=jannocessor-demo -DarchetypeArtifactId=jannocessor-sample-archetype -DarchetypeGroupId=com.googlecode.jannocessor -DarchetypeVersion=0.7.3 -Dversion=0.0.1-SNAPSHOT -Dpackage=org.jannocessor.demo
```

This will generate a multi-module demo project named "jannocessor-demo".

Once the project is created, you can build it to see how the Java source code is generated by JAnnocessor:

```
cd jannocessor-demo
mvn clean install
```

JAnnocessor is configured to execute as part of the build process (in "compile" phase), and it is running in debug (development) mode, so you should be able to see the JAnnocessor UI automatically.

Navigate through the generated code with **Alt + Left** and **Alt + Right**, and finally press **Esc** to exit the JAnnocessor UI, so the build process can complete.