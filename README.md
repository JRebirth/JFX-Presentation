JFX-Presentation
=====================

Presentation of JavaFX 2 in Dog Fooding way

Latest slides are available on [Slideshare](https://www.slideshare.net/SbastienBordes/la-revolution-javafx-at-breizhcamp-2012)

Download Binaries
-----------

All binaries are stored on our binaries server : http://apps.jrebirth.org/breizhcamp

Latest one are here : http://apps.jrebirth.org/breizhcamp/javafx2-2.0.0.zip


Build it
-----------

Requires [Git](http://git-scm.com/), [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and [Maven](http://maven.apache.org/).

    git clone https://github.com/JRebirth/JFX-Presentation.git
    cd JFX-Presentation/org.jrebirth.af.presentation.javafx2
    mvn clean install


How to Build Snaphot Versions
---------------------

You can build __RELEASE__ versions by simply using [Maven Central](http://search.maven.org) or [JCenter](jcenter.bintray.com) repositories to grab all dependencies.

As this project depends on 2 others repositories, if you want to build __SNAPSHOT__ version you have 2 options:
* Use [oss.jfrog.org](http://oss.jfrog.org) repository into your maven settings to grap SNAPSHOT dependencies
* Build yourself [JRebirth-RIA-POM](https://github.com/JRebirth/JRebirth-RIA-POM) and [JRebirth](https://github.com/JRebirth/JRebirth) repositories
 

__Maven Settings.xml file to use oss.jfrog.org__

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd" xmlns="http://maven.apache.org/SETTINGS/1.1.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <profiles>
    <profile>
      <repositories>
        <repository>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <id>central</id>
          <name>libs-release</name>
          <url>https://oss.jfrog.org/artifactory/libs-release</url>
        </repository>
        <repository>
          <snapshots />
          <id>snapshots</id>
          <name>libs-snapshot</name>
          <url>https://oss.jfrog.org/artifactory/libs-snapshot</url>
        </repository>
      </repositories>
      <pluginRepositories>
        <pluginRepository>
          <snapshots>
            <enabled>false</enabled>
          </snapshots>
          <id>central</id>
          <name>plugins-release</name>
          <url>https://oss.jfrog.org/artifactory/plugins-release</url>
        </pluginRepository>
        <pluginRepository>
          <snapshots />
          <id>snapshots</id>
          <name>plugins-snapshot</name>
          <url>https://oss.jfrog.org/artifactory/plugins-snapshot</url>
        </pluginRepository>
      </pluginRepositories>
      <id>artifactory</id>
    </profile>
  </profiles>
  <activeProfiles>
    <activeProfile>artifactory</activeProfile>
  </activeProfiles>
</settings>
```


