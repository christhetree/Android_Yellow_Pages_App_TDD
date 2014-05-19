#!/bin/bash
 
echo "Installing Google Play Services..."
# this depends on having gms-mvn-install.sh in script/
# get gms-mvn-install.sh from: https://github.com/JakeWharton/gms-mvn-install
cp scripts/gms-mvn-install.sh $ANDROID_HOME/extras/google/google_play_services/libproject/google-play-services_lib
pushd $ANDROID_HOME/extras/google/google_play_services/libproject/google-play-services_lib
sh gms-mvn-install.sh 11
popd