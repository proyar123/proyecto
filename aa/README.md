
# Algoritmos de Ordenamiento - Bubble Sort y Selection Sort

## Indicador de logro de la sesión
En esta sesión, el estudiante implementa el algoritmo de ordenamiento burbuja y selección para organizar datos en arreglos unidimensionales y bidimensionales, utilizando estructuras estáticas de forma eficiente y aplicando principios de comparación e intercambio.

## Importancia
Esta actividad es fundamental porque fortalece el pensamiento lógico-algorítmico, consolida el manejo de arreglos, introduce la noción de eficiencia en algoritmos, y sienta las bases para comprender otros métodos de ordenamiento y estructuras de datos más complejas que se abordarán en unidades posteriores.

---

## Principales algoritmos de ordenamiento
- Selection Sort
- Bubble Sort
- Insertion Sort
- Merge Sort
- Quick Sort

---

## 🧪 Algoritmo de Selección (Selection Sort)

Es un algoritmo de ordenamiento simple que funciona de la siguiente manera:
1. Encuentra el valor mínimo de una lista.
2. Lo intercambia con el valor en la posición inicial.
3. Repite los pasos anteriores con los elementos restantes, desde la segunda posición en adelante.

### Ejemplo visual
Lista inicial: `{5, 7, 2, 15, 3}`  
Después del primer paso: `{2, 7, 5, 15, 3}`  
Siguiente paso: `{2, 3, 5, 15, 7}`  
Resultado final: `{2, 3, 5, 7, 15}`

### Enlace útil
https://www.youtube.com/watch?v=Ns4TPTC8whw

### Código en Java - Selection Sort:
```java
static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
}
```


---

## 🧪 Algoritmo de Burbuja (Bubble Sort)

El algoritmo compara dos valores adyacentes y los intercambia si están en el orden incorrecto. Repite este proceso hasta que toda la lista esté ordenada.

### Ejemplo visual
Lista inicial: `{40, 7, 59, 4, 1}`  
Paso 1: `{7, 40, 59, 4, 1}`  
Paso 2: `{7, 40, 59, 4, 1}`  
Resultado final: `{1, 4, 7, 40, 59}`

### Código en Java:
```java
static void bubbleSort(int[] numbers) {
    for (int i = 0; i < numbers.length; i++) {
        for (int j = 0; j < numbers.length - 1; j++) {
            if (numbers[j] > numbers[j + 1]) {
                int temp = numbers[j];
                numbers[j] = numbers[j + 1];
                numbers[j + 1] = temp;
            }
        }
    }
}
```

### Enlace útil
https://www.youtube.com/watch?v=lyZQPjUT5B4

---

## 🧩 Caso práctico

Desarrolla una aplicación en Java (patrón MVC) que permita ordenar una lista de alumnos por **nombre** (alfabéticamente) o por **nota** (numéricamente).  
Implementa ambos algoritmos: Bubble Sort y Selection Sort.

---

## 💡 Ejercicios

1. **Ordenamiento de Selección:** Ordenar la lista `[64, 34, 25, 12, 22, 11, 90]`.
2. **Ordenamiento de Burbuja:** Ordenar la lista `["perro", "gato", "elefante", "ratón", "león", "tigre"]`.
3. **Burbujas Dobles:** Ordenar en **orden descendente** la lista `[23, 45, 12, 6, 78, 90, 34, 56, 89, 9]` con una versión mejorada de burbuja.

---
