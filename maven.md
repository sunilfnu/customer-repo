
****** COMPANY SCENARIO ******


MAVEN / GRADLE   -> first it checks in the .m2 directory
                 -> if not there, download from repository/artifactory

        * https://jfrog.com/artifactory

        When we first join the project,we need to configure the Settings.xml
        First create setttings.xml using JfroG Artifactory.

1) in Apex project,
   import org.junit;
   import org.springframework;
   import com.google.truth;
   ..

2) how to add dependencies.
    JAR -> Java Archive. 
    Download these dependencies manually and add them to External Libraries/ Class Path.

   1) Maven - Dependency Management Tool
           Important files in maven
           - POM.XML dependencies are added here
    First, maven checks if there are those dependcies in the .m2 folder -> repository folder
   
    - Build Tool
        - To run the project and use that project. 
        - clean , test,  build, package

        - mvn clean build