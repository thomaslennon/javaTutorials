#!/bin/bash
#
# ********************************************************************
# Name    : enm.lib
# Purpose : Functions for installing ENM 
#
# Usage   : source enm.lib
#
# ********************************************************************


# SET DIRECTORY PATH
# ------------------
ENMINST_HOME="/opt/ericsson/enminst/"
if [[ $EUID -ne 0 ]]; then
   echo "This script must be run as root" 1>&2
   exit 1
fi
if [[ ! -f "${ENMINST_HOME}/lib/logger.lib" ]]; then
    /usr/bin/logger -s -t "${MSGTAG}" "ERROR - Unable to find the logger.lib. Exiting...."
    exit 9
fi
. ${ENMINST_HOME}/lib/logger.lib auto
MSGTAG="ENM-INSTALL" #Read this value from the ini file later

### Function: enm.spinner ###
#
#   This function will display the spinner while waiting for the process to finish, 
#
#   Arguments:
#      none
#   Return Values:
#       0 - if success
#       1 - if failed

function enm.spinner() {
    i=1;
    sp="/-\|"
    echo -n ' '
    for i in $(seq 1 60);
    do
        printf "\b${sp:i++%${#sp}:1}" #Display next $sp charector in a loop
        sleep 1
    done
}


### Function: enm.checkplan ###
#

function enm.checkplan() {
    
    return 0
}
