#!/bin/bash
 
echo "Installing android support library..."
mvn -q install:install-file -DgroupId=com.android.support -DartifactId=support-v4 \
	-Dversion=19.0.0 -Dpackaging=jar -Dfile="$ANDROID_HOME/extras/android/support/v4/android-support-v4.jar"
