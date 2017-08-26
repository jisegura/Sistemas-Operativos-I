#!/bin/bash

if [ ! $# -eq 1 ]; then
	echo "ERROR: $0 wrong number of args"
	exit 1
fi

if [ ! -d $1 ]; then
	echo "ERROR: $1 Directory doesn't exist"
	exit 1
fi

LIST=$( ls $1  | grep -E [A-Z]\|[\ ] )
COUNT=$( echo "$LIST" | wc -l )

OLDIFS=$IFS
IFS='
'

for i in $LIST; do
	DEST=$( echo "$i" | tr 'A-Z ' 'a-z_' )
	mv "$1/$i" "$1/$DEST"
done

IFS=$OLDIFS

echo "cantidad de renombres: $COUNT"