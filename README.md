Mapping Objects to Multiple XML Schemas - Weather Example
=========================================================

This is the complete source code for the following blog post:

* http://blog.bdoughan.com/2011/09/mapping-objects-to-multiple-xml-schemas.html

Summary
-------

In this example EclipseLink JAXB (MOXy)'s @XmlPath and external binding file extensions are used to map a single object model to two different XML schemas.  To make the example more "real", the XML data will come from two different services that provide weather information:  Google and Yahoo.

* http://www.google.com/ig/api?weather=Ottawa
* http://weather.yahooapis.com/forecastrss?w=3369

Compile the Example
-------------------

You can compile the example code using the following command.  Maven will automatically fetch the required dependencies.

     mvn compile

Run the Example
---------------

You can run the example using the following commands.

    mvn exec:java -Dexec.mainClass="blog.weather.GoogleDemo"
    mvn exec:java -Dexec.mainClass="blog.weather.YahooDemo"