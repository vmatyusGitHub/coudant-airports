# World of Airports

This program pulls data about airports from a Cloudant database and displays their location in a simple list, sorted by distance.

The user shall provide a lat/lon point and a radius. The retrieved airports will be within the user provided radius.

####System details
Operation System: Windows 10
Java SDK: 1.8.0_211
Maven: 3.6.1

## Build the application
In CMD navigate to the cloned folder, where the pom.xml can be found, then run the following command:
~~~ maven
mvn verify
~~~

## Run the application
After successful build, you can start the application with this command:
~~~ maven
mvn exec:java
~~~
If everything went right, the application now works.

## Remove target folder
After some code change or just to create a fresh build:
~~~ maven
mvn clean
~~~

##Documentation
Documentation is created in javadoc.
Please clone the repository after open `doc/index.html` with a browser.