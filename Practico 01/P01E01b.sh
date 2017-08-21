#!/bin/sh

if [ ! $# -eq 1 ]; then
	echo ERROR: $0 wrong number of args
	exit 1
fi

ENTRADA=$( cat P01E01b-Entrada )

echo "$ENTRADA" | tr 0-9 "$1" > P01E01b-Salida 
#cambiar P01E01b-Salida por la P01E01b-Entrada
#para que se reemplaze en el mismo archivo