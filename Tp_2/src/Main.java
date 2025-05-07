public class Main {
    public static void main(String[] args) {

        // Ejercicio unos
        Arbol arbol = new Arbol();

        arbol.insert(2);
        arbol.insert(4);
        arbol.insert(1);
        arbol.insert(6);
        arbol.insert(3);
        arbol.insert(8);
        arbol.insert(5);
        arbol.insert(10);
        arbol.insert(9);
        arbol.insert(7);

        System.out.println("\nprintPreOrder()");
        arbol.printPreOrder();
        System.out.println("\nprintInOrder()");
        arbol.printInOrder();
        System.out.println("\nprintPostOrder()");
        arbol.printPostOrder();

        System.out.println("\ndetete() 10 = " + arbol.detete(10));
        System.out.println("getElemenAtLevel(4) = " + arbol.getElemAtLevel(4));

        //Ejercicio 2
        // Dado un árbol binario de búsquedas que almacena números enteros,
        // implementar un algoritmo que retorne la suma de todos los nodos
        // internos del árbol. TEN EN CUENTA QUE LAS HOJAS TAMBIÉN SE LLAMAN
        // NODOS EXTERNOS.
        System.out.println("Suma de valores de los nodos internos = "+arbol.sumaNodesInternos());

        System.out.println("Suma de valores de los nodos externos = "+arbol.sumaNodesExternos());

        System.out.println("Suma de valores de TODOS los nodos = "+arbol.sumaNodesDataTotal());

        //Ejercicio 3
        // Dado un árbol binario de búsqueda que almacena números enteros y
        // un valor de entrada K, implementar un algoritmo que permita obtener
        // un listado con los valores de todas las hojas cuyo valor supere K.
        // Por ejemplo, para el árbol de la derecha, con un valor K = 8, el
        // resultado debería ser [9, 11].

        System.out.println("Hojas mayores a 8 = "+arbol.hojasMayorValor(8));
        System.out.println("Hojas mayores a 4 = "+arbol.hojasMayorValor(4));

        //Ejercicio 4
        //Se posee un árbol binario (no de búsqueda), donde los nodos internos
        // están vacíos, mientras que las hojas tienen valores enteros.
        // Se debe implementar un metodo que recorra el árbol y coloque valores
        //  en los nodos vacíos (los nodos internos). El valor de cada nodo interno
        //  debe ser igual al valor de su hijo derecho, menos el valor de su hijo
        //  izquierdo. En caso de que el nodo tenga un solo hijo, el valor del hijo
        //  faltante se reemplaza por un 0. Por ejemplo, tomando como entrada el
        //  árbol de la izquierda, el árbol resultante debería quedar con los mismos
        //  valores que el de la derecha.

        // Crear la estructura del árbol

        TreeNodeInt root4 = new TreeNodeInt(null);

        root4.setLeft(new TreeNodeInt(null));
        root4.setRight(new TreeNodeInt(null));

        root4.getLeft().setLeft(new TreeNodeInt(14));
        root4.getLeft().setRight(new TreeNodeInt(null));

        root4.getLeft().getRight().setLeft(new TreeNodeInt(7));
        root4.getLeft().getRight().setRight(new TreeNodeInt(-5));

        root4.getRight().setLeft(new TreeNodeInt(null));
        root4.getRight().setRight(new TreeNodeInt(20));

        root4.getRight().getLeft().setRight(new TreeNodeInt(9));

        Arbol arbolNull = new Arbol(root4);
        System.out.println("\nroot4 printPreOrder()");
        arbolNull.printPreOrder();
        arbolNull.sumaRestaNodos();
        System.out.println("\nroot4 printPreOrder() tras sumaRestaNodos()");
        arbolNull.printPreOrder();

            

    }
}