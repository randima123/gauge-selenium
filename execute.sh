#!/bin/bash
# Executing project
mvn gauge:execute -DspecsDir=specs -Denv="$1"
