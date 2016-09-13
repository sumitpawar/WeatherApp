
@echo off
setlocal
rem Starts the application

set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_67
set PATH=%PATH%;C:\Program Files\Java\jdk1.7.0_67\bin

rem Check for Java Home and use that if available
if not "[%JAVA_HOME%]"=="[]" goto start_app
echo. Pls set JAVA_HOME for application to run!
goto end
:start_app
cd ..
rmdir /s /q build
rmdir /s /q bin
mkdir build\classes

echo. Using java in %JAVA_HOME%

javac -sourcepath src -d build/classes src/com/jh/weather/WeatherExtractor.java

echo Main-Class: com.jh.weather.WeatherExtractor > mf
	
mkdir build\jar
jar cfm build\jar\WeatherApp.jar mf -C build\classes .

start "Application" "%JAVA_HOME%\bin\javaw.exe" -jar build\jar\WeatherApp.jar
echo. Yay!!! Application started.
goto end

:end
