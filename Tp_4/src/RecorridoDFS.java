import java.util.HashMap;
import java.util.Iterator;

public class RecorridoDFS<T, G extends Grafo<T>> {

    private G grafo;
    private int tiempo;
    private final HashMap<Integer, Integer> distancias = new HashMap<>();
    private static final int Blanco = 0; //Grafo No Visitado
    private static final int Amarillo = 1; // Grafo Visitado pero aun con vecinos no visitados
    private static final int Negro = 2; // Grafo Visitado ya sin vecinos por visitar

    public RecorridoDFS(G grafo) {
        this.grafo = grafo;
    }

    // Complejidad Computacional O(|V| + |A|) con Listas de Adyacencia
    // |V| representa la cantidad de vértices y |A| la cantidad de aristas en el grafo.
    public void DFS() {
        HashMap<Integer, Integer> color = new HashMap<Integer, Integer>();
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();

        // Ininicializar todos los vertices como no visitados
        // De este modo, reiniciamos el recorrido, ya que el objeto
        // manipulado es el original y no una copia que se desecha.

        while (verticesIterator.hasNext()) {
            color.put(verticesIterator.next(), Blanco);
        }

        // Reiniciamos el tiempo
        tiempo = 0;
        verticesIterator = grafo.obtenerVertices();


        // Comienza el recorrido de profundidad
        while (verticesIterator.hasNext()) {
            Integer vertice = verticesIterator.next();
            if (color.get(vertice) == Blanco) {
                DFS_Visit(vertice, color);
            }
        }
    }

    public void DFS_Visit(Integer vertice, HashMap<Integer, Integer> color) {
        color.put(vertice, Amarillo);
        tiempo++;

        Iterator<Integer> vecinosIterator = grafo.obtenerAdyacentes(vertice);

        while (vecinosIterator.hasNext()) {
            Integer vecino = vecinosIterator.next();

            // Si el vecino aun no fue visitado, llama a la recursividad para explorarlo
            if (color.get(vecino) == Blanco) {
                DFS_Visit(vecino, color);
            } else {
                /* Ejercicio 3
                Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo. */

                // Si se encuentra un vértice que aún está en proceso, hay un ciclo

                // Un vértice en AMARILLO significa que estamos volviendo a un nodo que aún no ha sido terminado,
                // lo que indica la presencia de un ciclo en el grafo dirigido
                if (color.get(vecino) == Amarillo) {
                    System.out.println("Existe un ciclo en curso");
                }
            }

            // Una vez recorridos todos los vecinos, marcamos en Negro el
            // vertice para remarcar que no hay nada mas para ver.
            color.put(vertice, vertice);

            // Guardamos el tiempo de finalizacion del vertice
            distancias.put(vertice, tiempo);
        }


    }


}
