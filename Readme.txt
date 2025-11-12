# Parcial 1 – Lista Doblemente Enlazada (Java)

Este proyecto corresponde al Primer Parcial de Estructuras de Datos.  
El ejercicio consiste en implementar una lista doblemente enlazada con operaciones específicas sobre los nodos.

---

# Estructura de datos utilizada

Se implementa una lista doblemente enlazada, donde cada nodo contiene:

java
class Nodo {
    int info;
    Nodo ant;   // enlace al nodo anterior
    Nodo sig;   // enlace al nodo siguiente
}

---

# Funcionalidades implementadas
#Punto 1: insertar dos nodos (insertar(int x1, int x2))

-Se reciben dos valores enteros y se crean dos nodos consecutivos.

-Si la lista tiene exactamente 4 nodos, se insertan al final.

-En cualquier otro caso, se insertan al inicio de la lista.


#Punto 2: sumar nodos en posiciones impares (sumarImpares())

Recorre la lista y suma los nodos ubicados en:

-posición 1;

-posición 3;

-posición 5; etc.

Devuelve esa suma como entero.


#Punto 3: borrar el primero y el último nodo

-borrarPrimero(): elimina el nodo inicial y ajusta punteros.

-borrarUltimo(): elimina el nodo final, dejando correctamente enlazados los anteriores.

-Considera casos especiales: lista vacía y lista con 1 o 2 nodos


#Punto 4: intercambiar primero y último (intercambiarPrimeroYUltimo())

Se realiza un intercambio real de enlaces, no solo del valor:

-La raíz debe pasar a apuntar al último nodo

-Se respetan los enlaces internos

-Se contempla el caso especial de lista de dos nodos


#Punto 5: borrar nodos coincidentes con el primero

Se eliminan todos los nodos cuyo valor sea igual al del primer nodo, sin eliminar el primero.