#*****************************************
#	Created at: 11:57:05 01/18/2013 
#	Author: Iwabuchi Ken(iwabuchi.k.2010@gmail.com)
#	Copyright: 
#*****************************************

#==============================
#
#	Check arguments
#
#==============================
if [ $# -ne 2 ]
then
	echo "Usage: makejar.sh [package name] [class name]"
	echo "	e.g. makejar.sh p1 E5.class"
	exit 1
fi

#==============================
#
#	Set variables
#
#==============================
ary=( $@ )


#==============================
#
#
#
#==============================

