#!/bin/sh
#alias tac='sh P01E01c.sh'

if [ ! $# -eq 1 ]; then
	echo ERROR: $0 wrong number of args
	exit 1
fi

if [ ! -f "$1" ]; then
	echo ERROR: \'$1\' no file found
	exit 1
fi

ENTRADA=$( cat $1 )
OLDIFS=$IFS
IFS='
'

for i in $ENTRADA; do
	p="$i
$p"
done

IFS=$OLDIFS

echo "$p" > "$1"