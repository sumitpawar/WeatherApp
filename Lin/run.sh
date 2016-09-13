#!/usr/bin/env bash

echo "Running Weather App on Linux/Unix"

cd  $(dirname $0)
cd ../
echo `pwd`

if [ -f ./build/jar/WeatherApp.jar ]
then
	nohup java -jar ./build/jar/WeatherApp.jar > /dev/null 2>&1 &
else
	mkdir -p build/classes
	javac -sourcepath src -d build/classes src/com/jh/weather/WeatherExtractor.java
	
	echo "Main-Class: com.jh.weather.WeatherExtractor" > mf
	
	mkdir -p build/jar
		
	jar cfm build/jar/WeatherApp.jar mf -C build/classes .

	nohup java -jar build/jar/WeatherApp.jar > /dev/null 2>&1 &
fi
