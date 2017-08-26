#!/bin/bash

if [ ! $# -eq 1 ]; then
	echo "ERROR: $0 wrong number of args"
	exit 1
fi

if [ ! -d "$1" ]; then
	echo "ERROR: $1 Directory doesn't exist"
	exit 1
fi

LIST=$( ls $1 )

for i in $LIST; do
	if [[ $i == *.gz ]]; then
		gunzip "$1/$i"
	elif [[ $i == *.bz2 ]]; then
		bunzip2 "$1/$i"
	elif [[ $i == *.zip ]]; then
		unzip "$1/$i"
	elif [[ $i == *.tar ]]; then
		tar "$1/$i"
	else
		echo "$i no esta comprimido"
	fi
done