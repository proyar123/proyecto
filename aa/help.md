# Soluciones Paso a Paso

En esta sección, se detallan las soluciones paso a paso para los ejercicios de práctica utilizando los algoritmos de ordenamiento de selección y burbuja.

## Ejercicio 1: Ordenamiento de Selección

Dada la lista: `[64, 34, 25, 12, 22, 11, 90]`

La solución paso a paso sería:

1. Encontrar el valor mínimo de toda la lista (`11`) y cambiarlo por el valor en la primera posición. La lista queda: `[11, 34, 25, 12, 22, 64, 90]`.
2. Encontrar el mínimo de la lista excluyendo el primer elemento (`12`) y cambiarlo por el valor en la segunda posición. La lista queda: `[11, 12, 25, 34, 22, 64, 90]`.
3. Continuar este proceso hasta que la lista esté completamente ordenada.

Resultado final: `[11, 12, 22, 25, 34, 64, 90]`

## Ejercicio 2: Ordenamiento de Burbuja

Dada la lista de cadenas: `["perro", "gato", "elefante", "ratón", "león", "tigre"]`

La solución paso a paso sería:

1. Comparar `perro` y `gato`, mantener el orden ya que `perro` > `gato` alfabéticamente.
2. Comparar `gato` y `elefante`, intercambiar ya que `gato` > `elefante`.
3. Repetir el proceso para cada par adyacente y realizar múltiples pasadas hasta que no se requieran más intercambios.

Resultado final: `["elefante", "gato", "león", "perro", "ratón", "tigre"]`

## Ejercicio 3: Burbuja Bidireccional (Optimizado)

Dada la lista: `[23, 45, 12, 6, 78, 90, 34, 56, 89, 9]`

La solución paso a paso sería:

1. Realizar una pasada de burbuja regular para mover el elemento más grande al final.
2. Al llegar al final, cambiar de dirección y realizar una pasada hacia atrás para mover el elemento más pequeño al inicio.
3. Repetir el proceso, cada vez reduciendo el rango de la lista por ambos extremos.

Resultado final (orden descendente): `[90, 89, 78, 56, 45, 34, 23, 12, 9, 6]`

Estas soluciones demuestran el funcionamiento interno de los algoritmos de ordenamiento de selección y burbuja y cómo se pueden aplicar para resolver los ejercicios propuestos.
