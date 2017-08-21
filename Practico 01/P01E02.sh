#!/bin/bash

LIST=$( ls -lR $HOME )

prompt_confirm() {
	while true; do
		read -p "$1 [y/n]: " REPLY
		case $REPLY in
			[yY][eE][sS]|[yY]) echo ; return 0 ;;
			[nN][oO]|[nN]) echo ; return 1 ;;
			*) echo "invalid input"
		esac 
	done  
}

if (( prompt_confirm "Desea comprimir como gzip" )); then
	echo "$LIST" | gzip -cf > P01E02-Salida.gz
else
	echo "$LIST" > P01E02-Salida
fi