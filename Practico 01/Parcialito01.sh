#!/bin/sh

if [ ! $# -eq 1 ]; then
	echo ERROR: $0 wrong number of args
	exit 1
fi

if [ ! -f "$1" ]; then
	echo ERROR: \'$1\' no file found
	exit 1
fi

#Paso todas las palabras a minuscula
ENTRADALOWER=$( tr '[:upper:]' '[:lower:]' < $1 | tr -s [:space:] '\n' )

#Filtro las palabras unicas
ENTRADAUNIQUE=$( echo "$ENTRADALOWER" | sort -u )

getMaxOcurrencia() {
	MAX=0
	for i in $2; do
		AUX=$( echo "$1" | grep $i | wc -l )
		if (( $MAX < $AUX )); then
			MAX=$AUX
		fi
	done
}

getMaxOcurrencia "$ENTRADALOWER" "$ENTRADAUNIQUE"

for i in $ENTRADAUNIQUE; do
	OCURRENCIA=$( echo "$ENTRADALOWER" | grep $i | wc -l )
	echo "TF($i) = $OCURRENCIA/$MAX =" $( bc <<< "scale=2;$OCURRENCIA/$MAX" )
done