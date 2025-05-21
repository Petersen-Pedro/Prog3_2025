    // Ejercicio 1
    // Se tiene un conjunto de salas comunicadas entre sí a través
    // de puertas que se abren solamente en un sentido. Una de las
    // salas se denomina entrada y la otra salida. Construir un
    // algoritmo que permita ir desde la entrada a la salida atravesando
    // la máxima cantidad de salas. Idea: podría representar el
    // problema mediante un grafo dirigido, donde cada nodo es una
    // habitación, y cada puerta es un arco dirigido hacia otra habitación.

    import java.util.*;

    public class Ejercicio1_BacktrackingGrafo<T> {
    private GrafoDirigido<T> grafo;
    private List<Integer> mejorCamino;
    private int maxNodosVisitados;

    public Ejercicio1_BacktrackingGrafo(GrafoDirigido<T> grafo) {
        this.grafo = grafo;
        this.mejorCamino = new ArrayList<>();
        this.maxNodosVisitados = 0;
    }

    public List<Integer> backGrafo(int entrada, int salida) {
        List<Integer> caminoActual = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>(); // Registramos los grafos visitados hasta el momento.

        // Iniciamos la busqueda desde la entrada
        backGrafo(entrada, salida, caminoActual, visitados);
        return caminoActual;
    }

    private void backGrafo( int actual, int salida, List<Integer>
                            caminoActual, Set<Integer> visitados) {
        // Se agrega la sala actual al camino y se la marca como visitada
        caminoActual.add(actual);
        visitados.add(actual);

        // Si llegamos a la sala de salida, verificamos si es el camino más largo.
        if (actual==salida){
            if (caminoActual.size() > maxNodosVisitados){
                maxNodosVisitados = caminoActual.size();
                // Guarda la mejor solución encontrada
                mejorCamino = new ArrayList<>(caminoActual);
            }
        } else {
            // Iterator sobre los vecinos de la sala actual
            Iterator<Integer> vecinos = grafo.obtenerAdyacentes(actual);

            while (vecinos.hasNext()) {
                int vecino = vecinos.next();
                if (!visitados.contains(vecino)) {
                    backGrafo(vecino, salida, caminoActual, visitados);
                }
            }
        }

        // Retroceder desmarcando la sala actual y eliminandola de caminoActual
        visitados.remove(actual);
        caminoActual.remove(caminoActual.size()-1);

    }
}
