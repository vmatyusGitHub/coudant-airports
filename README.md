# World of Airports

This program pulls data about airports from a Cloudant database and displays their location in a simple list, sorted by distance.

The user shall provide a lat/lon point and a radius. The retrieved airports will be within the user provided radius.


## Build the application
In the cloned folder, where the pom.xml can be found, run the following in cmd:
~~~ maven
mvn verify
~~~

## Run the application
After successful build, you can start the application with these commands:
~~~ maven
mvn exec:java
~~~
If everything goes right, the application should work.

## Remove target folder
After some code change or just to create a fresh build:
~~~ maven
mvn clean
~~~

##Documentation
Documentation is created in javadoc.
Please clone the repository after open `doc/index.html` with a browser.