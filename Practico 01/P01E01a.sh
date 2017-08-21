#!/bin/bash

LEER=$( cat P01E01a-Entrada )
echo $LEER | tr a-z A-Z > P01E01a-Salida
#Cambiar P01E01a-Salida por P01E01a-Entrada
#para que se reemplace en el mismo archivo.