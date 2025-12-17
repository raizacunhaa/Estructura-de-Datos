# Parcial 2 - Árbol Binario en Java

Este proyecto corresponde al Parcial N°2 Estructuras de Datos, cuya consigna consiste en implementar operaciones sobre un Árbol Binario.

El programa recibe una lista de valores numéricos e inserta cada uno en el árbol:

> - Los valores menores se insertan en el subárbol izquierdo
> - Los valores mayores se insertan en el subárbol derecho

---

## Funcionalidades implementadas

La clase `Estructura_de_datos2` desarrolla las siguientes operaciones:

| 1️⃣ | Insertar nodos en el Árbol Binario de Búsqueda | Método `insertar(int info)` |
| 2️⃣ | Obtener el menor valor del subárbol derecho | Método `menorValorDerecha()` |
| 3️⃣ | Obtener el mayor valor del subárbol izquierdo | Método `mayorValorIzquierda()` |
| 4️⃣ | Buscar un valor e informar **en qué nivel se encuentra** | Método `existeValorEnNivel(int info)` + `buscarNivel()` |
| 5️⃣ | Calcular la cantidad total de nodos hoja | Método `totalNodosHoja()` |

Además, incluye un método de recorrido in-order (EntreOrden) para mostrar los valores de forma ordenada:

```java
imprimirEntre();
