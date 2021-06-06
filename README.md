# KloonedLibrary <br>
[![Java CI with Maven](https://github.com/TheLeCrafter/KloonedLibrary/actions/workflows/maven.yml/badge.svg)](https://github.com/TheLeCrafter/KloonedLibrary/actions/workflows/maven.yml) 
[![GitHub issues](https://img.shields.io/github/issues/TheLeCrafter/KloonedLibrary.svg)](https://GitHub.com/TheLeCrafter/KloonedLibrary/issues/) 
[![GitHub issues-closed](https://img.shields.io/github/issues-closed/TheLeCrafter/KloonedLibrary.svg)](https://GitHub.com/TheLeCrafter/KloonedLibrary/issues?q=is%3Aissue+is%3Aclosed) <br>
![KloonedLibrary image by RedstoneFlo](https://cdn.discordapp.com/attachments/431816747880939521/814532210161876992/KloonedLibrary.png) (Thank you RedstoneFlo for this nice image)<br>
A library designed for the Hypixel admin Minikloon. This library can mostly be used to colorize strings for a Minecraft Spigot/Paper plugin. <br>
You can also use this library to control armor stands that should follow a specific player in a specific way.

## How to use
### Maven
Add to your pom.xml following dependency:
```XML
<dependency>
  <groupId>dev.thelecrafter.libraries</groupId>
  <artifactId>klooned</artifactId>
  <version>VERSION</version>
</dependency> 
```
##### Without IntelliJ
Open a terminal in your project directory and type `mvn install`.
##### With IntelliJ
Open the Maven window. Click the arrow next to your project name and then `Lifecycle`. Click on `install`.
### Gradle
```gradle
repositories {
  mavenCentral()
}
dependencies {
  compileOnly 'dev.thelecrafter.libraries:klooned:VERSION'
}
```
## Java docs
The java docs can be found [here](https://kloonedlibrary.thelecrafter.dev). <br><br>
[![ForTheBadge built-with-love](http://ForTheBadge.com/images/badges/built-with-love.svg)](https://GitHub.com/TheLeCrafter/)
