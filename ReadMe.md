## What is this about ?

This is a basic coding test.

You have :

 - an implementation class where you must fill the blanks
 - a JUnit Test class that tells you what is the expected behavior

The goal is of course to make all unit tests pass !

## How to code and run the tests

The project is composed of 5 simple classes :

 - 2 interfaces
 - 2 implementation classes
     - one that you must write from the ground (actually from the interface)
     - one that where you must fill the blankc in a skeleton 
 - 1 test class
 
The only dependency is JUnit : so it should be very simple to make it run.

### Using Maven

If you have maven installed you can simply type 

    mvn install

This will run the build and the tests.

You can edit the implementation with whatever tool you want.

### Using Eclipse and Maven

If you have maven installed, but prefer to use Eclipse IDE :

generate the Eclipse project :

    mvn eclipse:eclipse

Import the maven project inside Eclipse

    Import > Existing Project into Workspace > select the directory of the project 

### Using Eclipse without Maven

If for some reasons, you don't want to use Maven :

 - create a Java project
 - add JUnit inside your class path
 - import the 4 source files (interfaces + implementation + tests)

### Using any other IDE

If you use an other IDE (ItelliJ, NetBeans ... ), just import the 4 class files and add JUnit in your class path.

## Rules and expected result 

The goal is to have all unit tests passing.

You are advised to address the unit tests in the order they appear in the test class.

The 2 last tests probably require much more coding  time than the 3 first ones.

 - Time  : this is not a race, but target implementation time is about 1 hour and anyway, it should not take more than 2 hours 
 - Implementation : of course, having a rather clean implementation does matter (less than 100 lines are actually needed)
 - Dependencies : you should not need to add any specific dependencies
 - Java version : test is aligned on Java 7, but you should be able to use whatever you want

