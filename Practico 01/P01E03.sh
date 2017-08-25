#!/bin/bash

LIST=$( find $HOME/* -maxdepth 0 -size +100k -type f )

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

OLDIFS=$IFS
IFS='
'

for i in $LIST; do
	if (( prompt_confirm "Desea comprimir \'$i\'" )); then
		echo "$i" | gzip -ck > $i.gz # comprime bien?
	fi
	if (( prompt_confirm "Desea eliminar \'$i\'" )); then
		rm $i # remove for ever and ever
		echo "[$( date )] $i" >> $HOME/P01E03.log
	fi
done

IFS=$OLDIFS