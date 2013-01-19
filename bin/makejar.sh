#!/bin/bash
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
#	Func: getTrunk()
#
#==============================
getTrunk() {

	echo "Entering getTrunk()"
	
	echo "getTrunk()"
	echo $1

	tokens=( `echo $class_name | sed -r 's/\./ /g'` )

	trunk=${tokens[0]}

	echo trunk=$trunk
	
	echo "Exiting getTrunk()"
}

#==============================
#
#	Set variables
#
#==============================
ary=( $@ )
pkg_name=${ary[0]}
class_name=${ary[1]}

echo class_name=$class_name

getTrunk $class_name

#echo trunk=$trunk

#==============================
#
#	Create manifest file,
#	Construct a command line for generating a jar file,
#
#==============================



#echo pkg_name=$pkg_name
#echo class_name=$class_name
#
#trunk=`echo $class_name | sed -r 's/\./ /g'`
#echo "trunk=$trunk"
#echo "trunk[0]=$trunk[0]"
#
#echo -----------------------
#for i in $trunk; do
#	echo $i
#done
#
#echo ------------2
#trunk=( `echo $class_name | sed -r 's/\./ /g'` )
#
#echo ${#trunk[@]}
#
#echo ${trunk[0]}

#==============================
#
#
#
#==============================

