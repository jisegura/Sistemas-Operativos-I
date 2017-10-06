#!/bin/bash

if [ ! $# -eq 1 ]; then
	echo ERROR: $0 wrong number of args
	exit 1
fi

USER=$1
LISTLOG=$( find . -name 'sol.log' )

OLDIFS=$IFS

for i in $LISTLOG; do
	AUX=$( cat "$i" )
	IFS='
'
	for j in $AUX; do
		USERLOG=$( echo "$j" | cut -d"," -f1 )
		if [ "$USER" == "$USERLOG" ]; then
			SALIDA="$SALIDA
$i"
		fi
	done
	IFS=$OLDIFS
done

echo "$SALIDA"