# Stratosphere Workshop #

## Setup your local development environment ##

Install Java7 and maven3. You can use maven from the command line. Eclipse and IntelliJ have support for maven. Create a GitHub account. Fork this git project (so you have an exact copy of it in your github account afterwards) and clone it (making a local copy).

## First task ##

run the word count example

## Second task ##

We want to work with geographic data. Download http://download.geofabrik.de/europe/germany/bremen-latest.osm.pbf and run:

`mvn -U clean compile exec:java -Dexec.mainClass="de.komoot.hackathon.PfbToJsonRecordsExporter" -Dexec.args="/path/to/bremen-latest.osm.pbf /targetdir/"`


## Questions and Issues ##
  -  Q: maven cannot download stratosphere packages (eu.stratospere ...)
    -  A: check your $HOME/.m2/settings.xml: It should not contain a line `<mirrorOf>*</mirrorOf>` but `<mirrorOf>central</mirrorOf>`.
  - Q: I want to know more about Geometry Functions and Datatypes
    - A: Check out the Simple Feature Specification (http://en.wikipedia.org/wiki/Simple_Features) the popular postgresql extension PostGIS (http://postgis.net/docs/manual-2.1/) and the java implementation JTS (http://sourceforge.net/projects/jts-topo-suite/)

