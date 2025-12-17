
public class Parcial1_EDD {

    // ----- Clase interna Nodo -----
    class Nodo {
        int info;
        Nodo sig; // siguiente
        Nodo ant; // anterior
    }

    private Nodo raiz;

    public Parcial1_EDD() {
        raiz = null; // lista vacía
    }

    // ----- Contar cantidad de nodos -----
    public int cantidad() {
        int c = 0;
        Nodo reco = raiz;
        while (reco != null) {
            c++;
            reco = reco.sig;
        }
        return c;
    }

    // ----- Punto 1: insertar dos int -----
    public void insertar(int x1, int x2) {
        Nodo n1 = new Nodo();
        Nodo n2 = new Nodo();
        n1.info = x1;
        n2.info = x2;

        int cant = cantidad();

        if (cant == 4) { // insertar al final
            if (raiz == null) {
                raiz = n1;
                n1.sig = n2;
                n2.ant = n1;
                n2.sig = null;
            } else {
                Nodo reco = raiz;
                while (reco.sig != null) {
                    reco = reco.sig;
                }
                reco.sig = n1;
                n1.ant = reco;
                n1.sig = n2;
                n2.ant = n1;
                n2.sig = null;
            }
        } else { // insertar al principio
            if (raiz == null) {
                raiz = n1;
                n1.sig = n2;
                n2.ant = n1;
            } else {
                n2.sig = raiz;
                raiz.ant = n2;
                n1.sig = n2;
                n2.ant = n1;
                raiz = n1;
            }
        }
    }

    // ----- Punto 2: sumar nodos en posiciones impares -----
    public int sumarImpares() {
        int suma = 0;
        int i = 1;
        Nodo reco = raiz;

        while (reco != null) {
            if (i % 2 != 0)
                suma += reco.info;
            reco = reco.sig;
            i++;
        }
        return suma;
    }

    // ----- Punto 3 -----

    //Borramos el 1ro
    public void borrarPrimero() {
        if (raiz != null) {
            raiz = raiz.sig;
        }
    }

    //Borramos el último
    public void borrarUltimo() {
        if (raiz != null) {
            if (raiz.sig == null) {
                raiz = null;
            } else {
                Nodo reco = raiz;
                while (reco.sig != null) {
                    reco = reco.sig;
                }
                reco.ant.sig = null;
            }
        }
    }


    // ----- Punto 4: intercambiar 1ro y último -----
    public void intercambiarPrimeroYUltimo() {
        if (raiz == null || raiz.sig == null)
            return;

        Nodo primero = raiz;
        Nodo reco = raiz;
        while (reco.sig != null) {
            reco = reco.sig;
        }

        Nodo ultimo = reco;

        // Caso especial: dos nodos
        if (primero.sig == ultimo) {
            ultimo.sig = primero;
            primero.ant = ultimo;
            primero.sig = null;
            ultimo.ant = null;
            raiz = ultimo;
            return;
        }

        // Enlazamos el penúltimo con el primero
        ultimo.ant.sig = primero;

        // Intercambiamos enlaces
        Nodo segundo = primero.sig;
        Nodo antesUltimo = ultimo.ant;

        ultimo.sig = segundo;
        segundo.ant = ultimo;

        primero.ant = antesUltimo;
        antesUltimo.sig = primero;

        primero.sig = null;
        raiz = ultimo;
    }

    // ----- Punto 5: borrar nodos con el mismo valor que el primero -----
    public void borrarCoincidentesConPrimero() {
        if (raiz == null || raiz.sig == null)
            return;

        int valor = raiz.info;
        Nodo reco = raiz.sig;

        while (reco != null) {
            if (reco.info == valor) {
                if (reco.sig != null) {
                    reco.ant.sig = reco.sig;
                    reco.sig.ant = reco.ant;
                } else {
                    reco.ant.sig = null;
                }
            }
            reco = reco.sig;
        }
    }

    // ----- Imprimir lista -----
    public void imprimir() {
        Nodo reco = raiz;
        while (reco != null) {
            System.out.print(reco.info);
            if (reco.sig != null)
                System.out.print(" - ");
            reco = reco.sig;
        }
        System.out.println();
    }

    // ----- CÓDIGO MAIN -----
    public static void main(String[] args) {
        Parcial1_EDD lg = new Parcial1_EDD();

        // Punto 1
        lg.insertar(10, 20);
        lg.insertar(5, 8);
        lg.insertar(200, 4);
        lg.insertar(1, 2);

        System.out.println("Lista original:");
        lg.imprimir();

        // Punto 2
        int sumaImpares = lg.sumarImpares();
        System.out.println("\nSuma de los nodos en posiciones impares: " + sumaImpares);

        // Punto 3
        lg.borrarPrimero();
        System.out.println("\nLuego de borrar primero:");
        lg.imprimir();

        lg.borrarUltimo();
        System.out.println("\nLuego de borrar último:");
        lg.imprimir();

        // Punto 4
        lg.intercambiarPrimeroYUltimo();
        System.out.println("\nLuego de intercambiar primero y último:");
        lg.imprimir();

        // Punto 5
        lg.borrarCoincidentesConPrimero();
        System.out.println("\nLuego de borrar los que coinciden con el primero:");
        lg.imprimir();
    }
}




