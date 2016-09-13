#!/usr/bin/env bash

cd  $(dirname $0)
echo "cleaning Weather App on Linux/Unix"
echo "${BASH_SOURCE[0]}..... $(basename $0) ... $(dirname $0)" 

cd  ../
rm -rf build
rm -rf bin

cd ./Lin
./run.sh
