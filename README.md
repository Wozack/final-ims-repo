##Project Title
Wozack's Starship IMS

##Getting Started
##These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
##See deployment for notes on how to deploy the project on a live system.

In order to use a .jar file like the one in this build, you must have a JRE installed. If so you can double click onto the .jar 
to open in the JRE. Alternatively you may access the .jar file from commandline using the following:

[java -jar Main.jar]

##Prerequisites
##What things you need to install the software and how to install them

JDK:

The Java Development Kit (JDK) is an implementation of either one of the Java Platform, Standard Edition, Java Platform, 
Enterprise Edition, or Java Platform, Micro Edition platforms released by Oracle Corporation in the form of a binary product
aimed at Java developers on Solaris, Linux, macOS or Windows. The JDK includes a private JVM and a few other resources to finish the
development of a Java Application.

Downloading the Installer
If you save the self-installing executable file to disk without running it from the download page at the web site, note the file size 
specified on the download page. After the download has completed, verify that you have downloaded the complete file.

Running the JDK Installer
You must have administrative permissions in order to install the JDK on Microsoft Windows. The file jdk-8version-windows-i586-i.exe is 
the JDK installer for 32-bit systems. The file jdk-8version-windows-x64.exe is the JDK installer for 64-bit systems. If you downloaded 
either file instead of running it directly from the web site, double-click the installer's icon. Then, follow the instructions the 
installer provides. When finished with the installation, you can delete the downloaded file to recover disk space.


Maven:

Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven 
can manage a project's build, reporting and documentation from a central piece of information.

Installation - The installation of Apache Maven is a simple process of extracting the archive and adding the `bin` folder with the
`mvn` command to the `PATH`. First we ensure JAVA_HOME environment variable is set and points to your JDK installation. Extract the
distrobution srchive in any directory by doing the following:

[unzip apache-maven-3.6.3-bin.zip]

Next we add the bin directory of the created directory apache-maven-3.6.3 to the PATH environment variable. Do this first by checking 
the enviroment varient value, e.g;

[echo %JAVA_HOME%] 
[C:\Program Files\Java\jdk1.8.0_51]

Adding to PATH: Add the unpacked distribution’s bin directory to your user PATH environment variable by opening up the system properties 
(WinKey + Pause), selecting the “Advanced” tab, and the “Environment Variables” button, then adding or selecting the PATH variable in 
the user variables with the value C:\Program Files\apache-maven-3.6.3\bin. The same dialog can be used to set JAVA_HOME to the location 
of your JDK, e.g. C:\Program Files\Java\jdk1.8.0_51

Open a new command prompt and run mvn -v to verify the installation. The result should look similar to:

[ Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /opt/apache-maven-3.6.3
Java version: 1.8.0_45, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.8.5", arch: "x86_64", family: "mac ]


##Running the tests

For automated testing we use Jenkins.Writing automated tests for Jenkins and its plugins is important to ensure that everything works as expected 
— in various scenarios, with multiple Java versions, and on different operating systems — while helping to prevent regressions from being introduced 
in later releases.

Setting up Jenkins
All Jenkins plugins inherit from the plugin parent POM and therefore have the test harness dependency included automatically. Similarly, JUnit is 
included as a dependency by the parent POM, so you don’t need to add it as a dependency.

Working with CI Pipeline
You are encouraged to test that your plugin works with Pipeline. You can do so without making your plugin itself dependent on various Pipeline-related 
plugins; instead you can include these as test dependencies, so that they are only used when compiling and running test cases.This is done by adding 
the minimum required Pipeline plugins to the <dependencies> section of your POM. 

Running tests from commandline
mvn test will run all test cases, report progress and results on the command line, and write those results to JUnit XML files following the pattern 
target/surefire-reports/TEST-<class name>.xml.

Unit Tests
Unit Tests are smaller scale individual tests that asses the performance of a single method at a time with dummy variables. These are done as part of
test driven development, ensuring that methods written are well-preforming or needing some more development. An example of unit testing in the IMS is 
testing the getters and setters of the various classes.

Integration Tests
Integration Tests are similar to unit tests except instead of calling a single method, in integration testing we are testing a method that calls another
method, thus assessing the integration between the methods and associated classes. An example of integration testing in the ISM is the mockio tests done
to examine the performance of the DAOs and their methods.

Coding Style Tests
Code integrety analysis software like Sonarqube can be integrated into the CI Pipline to check the integrety of our code and run coding style tests on 
our work, looking for code-smells and any occurences of bad practise in our code.

##Additional Notes
Tests in the IMS are currently slashed-out so they do not interfere with Jenkins automation.


##Built With

Java 8 - Using Ecplise IDE
Maven - Dependency Management

##Versioning

1.0.0

##Authors
Jack Wozniak - Initial work - Wozack

##License
This project is licensed under the MIT license - see the LICENSE.md file for details

##Acknowledgments
The tutors at QA Manchester, especially Christopher Perrins and Rhys Thompson
Fellow cohort members of QA IT Consultantcy January 2020 intake. 
