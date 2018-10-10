set PATH=F:\MyDevelop\jdk8\bin;%PATH%
set PATH=F:\MyDevelop\gradle-4.10.2\bin;%PATH%
set JAVA_HOME=F:\MyDevelop\jdk8
set GRADLE_HOME=F:\MyDevelop\gradle-4.10.2
set GRADLE_USER_HOME=F:\MyDevelop\gradle-user-home
D:
cd D:\Develop\github\huhuiyu\TeachProjects\SpringBootBasic
call gradle clean
call gradle build
cd build\libs
java -jar SpringBootBasic-1.0.0.0.jar
pause