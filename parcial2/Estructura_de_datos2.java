import java.util.Arrays;
import java.util.List;

public class Estructura_de_datos2 {

	class Nodo {
		int info;
		Nodo izq, der;
	}

	int cant, altura;
	Nodo raiz;

	// 1 => Insertar elementos en el arbol
	public void insertar(int info) {
		Nodo nuevo = new Nodo();
        nuevo.info = info;
        nuevo.izq = null;
        nuevo.der = null;

        if (raiz == null) { //si el árbol está vacío, el nuevo nodo es la raíz.
            raiz = nuevo;
        } else { //reco recorre árbol, anterior recorre padre
            Nodo anterior = null, reco = raiz;
            while (reco != null) { //recorremos ramas
                anterior = reco;
                if (info < reco.info)
                    reco = reco.izq;
                else
                    reco = reco.der;
            }
            if (info < anterior.info) //insertamos nuevo nodo
                anterior.izq = nuevo;
            else
                anterior.der = nuevo;
        }
		
	}

	// 2 => Encuentra el menor valor del subArbol derecho
	public void menorValorDerecha() {
		 if (raiz != null && raiz.der != null) { //si no hay árbol y si la raíz no tiene subárbol der, imprime y sale.
            Nodo reco = raiz.der;
            while (reco.izq != null) { //el puntero sigue la izq hasta null
            	reco = reco.izq;
            }
            System.out.println("Menor valor del subárbol derecho: " + reco.info);
        }

	}

	// 3 => Encuentra el mayor valor del subArbol izquierdo
	public void mayorValorIzquierda() { //misma lógica del punto anterior
		if (raiz != null && raiz.izq != null) {
            Nodo reco = raiz.izq;
            while (reco.der != null) {
                reco = reco.der;
            }
            System.out.println("Mayor valor del subárbol izquierdo: " + reco.info);
        }

	}

	// 4 => Buscar un valor e informar el nivel
	public void existeValorEnNivel(int info) {
		    cant = 0;     // usamos cant como "nivel encontrado"
        buscarNivel(raiz, info, 1);  // iniciamos desde el nivel 1

        if (cant != 0)
            System.out.println("El valor " + info + " se encuentra en el nivel " + cant);
        else
            System.out.println("El valor " + info + " NO se encuentra en el árbol");
    }

    private void buscarNivel(Nodo reco, int info, int nivel) {

        if (reco == null || cant != 0)
            return;  // si ya lo encontramos, o se llegó a un nodo null se detiene

        if (reco.info == info) {
            cant = nivel;  // guardo el nivel donde se encontró el valor
            return;
        }

        buscarNivel(reco.izq, info, nivel + 1); // metodo recursivo a la izq incrementando el nivel

        buscarNivel(reco.der, info, nivel + 1); // metodo recursivo a la der incrementando el nivel
    }



    // 5 => Calcular el total de nodos hoja del arbol
   public int totalNodosHoja() {
        cant = 0;             
        contarHojas(raiz);
        return cant;
    }

    private void contarHojas(Nodo reco) {

        if (reco == null)
            return;

        if (reco.izq == null && reco.der == null)
            cant++;

        contarHojas(reco.izq); // seguir recorriendo recursivamente el árbol
        contarHojas(reco.der);
    }


	private void imprimirEntre(Nodo reco) {
		if (reco != null) {
			imprimirEntre(reco.izq);
			System.out.print(reco.info + " ");
			imprimirEntre(reco.der);
		}
	}

	public void imprimirEntre() {
		imprimirEntre(raiz);
		System.out.println();
	}

	public static void main(String[] args) {
		Estructura_de_datos2 abo = new Estructura_de_datos2();

		List<Integer> valores = Arrays.asList(400, 100, 700, 200, 50, 1200, 15, 75, 300, 850);
		for (int x : valores) {
			abo.insertar(x);
		}

		System.out.println("1 = Impresion entreorden: ");
		abo.imprimirEntre();

		System.out.println(); // salto de linha

		System.out.println("2 = menor valor del subArbol derecho: ");
		abo.menorValorDerecha();

		System.out.println(); 
		
		System.out.println("3 = mayor valor del subArbol izquierdo: ");
		abo.mayorValorIzquierda();

		System.out.println(); 

		System.out.println("4 = Buscar valor en el arbol e informar en que nivel existe: ");
		abo.existeValorEnNivel(100);
		abo.existeValorEnNivel(45);

		System.out.println(); 

        System.out.println("5 = Total de nodos hoja en el arbol = " + abo.totalNodosHoja());
	}
}
