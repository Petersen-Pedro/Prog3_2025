import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
    private HashMap<Integer, LinkedList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (this.vertices.containsKey(verticeId)) {
            System.out.println("Vertice: " + verticeId + " ya existe");
        } else {
            this.vertices.put(verticeId, new LinkedList<Arco<T>>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (!this.vertices.containsKey(verticeId)) {
            System.out.println("Vertice: " + verticeId + " ya existe");
        } else {
             for (Integer vecino : vertices.keySet()) { //.keySet() devuelve un Set que contiene todas las claves presentes en ese HashMap.
                LinkedList<Arco<T>> arcos = vertices.get(vecino);
                arcos.removeIf(arco -> arco.getVerticeDestino() == verticeId);
             }
             vertices.remove(verticeId);
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("Al menos uno de los dos vertices no existe");
        } else {
            vertices.get(verticeId1).add(new Arco<T>(verticeId1, verticeId2, etiqueta));
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("Al menos uno de los dos vertices no existe");
        } else {
            // Eliminar el arco de la lista de adyacencia de verticeId1
            LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
            arcos.removeIf(arco -> arco.getVerticeDestino() == verticeId2);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("Al menos uno de los dos vertices no existe");
            return false;
        } else {
            LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
            for (Arco<T> arco : arcos) {
                if (arco.getVerticeDestino() == verticeId2)
                    return true;
            }
            return false;
        }
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if (!vertices.containsKey(verticeId1) || !vertices.containsKey(verticeId2)) {
            System.out.println("Al menos uno de los dos vertices no existe");
            return null;
        } else{
            LinkedList<Arco<T>> arcos = vertices.get(verticeId1);
            for (Arco<T> arco : arcos) {
                if(arco.getVerticeDestino() == verticeId2)
                    return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int cantidad = 0;
        for(LinkedList<Arco<T>> arcos : vertices.values()) {
            cantidad += arcos.size();
        }
        return cantidad;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        // keySet() extrae todas las claves: Recorre internamente el Map
        //      y recopila todas las claves que contiene.
        // Devuelve un Set: Estas claves no se devuelven en cualquier
        //      orden, sino que se agrupan en una estructura llamada Set.
        //      Una característica importante de un Set es que no permite
        //      elementos duplicados. Además, un Set no garantiza un orden
        //      específico de los elementos.
        // Con esto llamamos a .iterator() para que cree un Iterator, para
        //      asi tener un puntero con el cual recorrer el Set.
        Iterator<Integer> iterator = vertices.keySet().iterator();
        return iterator;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if (!vertices.containsKey(verticeId)) {
            System.out.println("El vertice no existe");
            return null;
        } else {
            LinkedList<Integer> vecinos = new LinkedList<>();
            for (Arco<T> arco : vertices.get(verticeId)) {
                vecinos.add(arco.getVerticeDestino());
            }
            return vecinos.iterator();
        }
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        LinkedList<Arco<T>> listaArcos = new LinkedList<>();
        for (LinkedList<Arco<T>> listaAdyacencia : vertices.values()) {
            listaArcos.addAll(listaAdyacencia);
        }
        return listaArcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if (!vertices.containsKey(verticeId))
            return null;
        else
            return vertices.get(verticeId).iterator();
    }

}