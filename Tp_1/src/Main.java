import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        //Ejercicio 1
        //Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría (
        //void insertFront(T), T extractFront(), boolean isEmpty(), int size(), String toString).
        //Agregar también el metodo: T get(index).

        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<>();

        System.out.println("Elemento pos 0 = "+lista1.get(0));

        lista1.insertFront(1);
        lista1.insertFront(4);
        lista1.insertFront(3);
        lista1.insertFront(2);
        lista1.insertFront(6);
        lista1.insertFront(5);

        System.out.println("Tamaño lista: "+lista1.size());

        lista1.extractFront();

        System.out.println("Elemento pos 0 = "+lista1.get(0));
        System.out.println("Elemento pos 1 = "+lista1.get(1));
        System.out.println("Elemento pos 2 = "+lista1.get(2));
        System.out.println("Elemento pos 3 = "+lista1.get(3));
        System.out.println("Elemento pos 4 = "+lista1.get(4));
        System.out.println("Elemento pos 5 = "+lista1.get(5));

        // A la implementación de la clase Lista realizada en el
        // ejercicio 1, agregue un methods
        //int indexOf(T), que reciba un elemento y retorne el índice
        // donde está almacenado ese elemento, o -1 si el elemento
        // no existe en la lista.

        System.out.println("pos de elemento 3 = " + lista1.indexOf(3));
        System.out.println("pos de elemento 7 = " + lista1.indexOf(7));

        //A partir de la clase Lista implementada en el ejercicio 1,
        // implemente el patrón
        //iterator-iterable, para que la lista sea iterable.
        // ¿Existe alguna ventaja computacional a la hora de recorrer
        // la lista de principio a ﬁn si se cuenta con un iterator?

        //  Sin un iterator, necesitaríamos un while manualmente recorriendo
        //      nodos, lo que puede ser propenso a errores.
        //  El iterator no mejora la complejidad computacional O(𝑛)
        //      pero facilita la implementación de algoritmos que trabajan
        //      sobre la lista sin exponer su estructura interna.

        //Ejercicio 5
        //Escriba un procedimiento que dadas dos listas construya otra con
        // los elementos comunes, suponiendo que:
        // a) Las listas están desordenadas y la lista resultante debe quedar ordenada.
        // b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.

        MySimpleLinkedList DesordenadaList1 = new MySimpleLinkedList();
        MySimpleLinkedList DesordenadaList2 = new MySimpleLinkedList();
        MySimpleLinkedList OrdenadaList1 = new MySimpleLinkedList();
        MySimpleLinkedList OrdenadaList2 = new MySimpleLinkedList();

        llenarListaDesordenada(DesordenadaList1, 20);
        llenarListaDesordenada(DesordenadaList2, 20);
        DesordenadaList1.insertOrdered(31);
        DesordenadaList2.insertOrdered(31);
        DesordenadaList1.insertFront(42);
        DesordenadaList2.insertFront(42);


        llenarListaOrdenada(OrdenadaList1, 20);
        llenarListaOrdenada(OrdenadaList2, 20);

        System.out.println("DesordenadaList1: "+DesordenadaList1);
        System.out.println("DesordenadaList2: "+DesordenadaList2);
        System.out.println("OrdenadaList1: "+OrdenadaList1);
        System.out.println("OrdenadaList2: "+OrdenadaList2);

        MySimpleLinkedList<Integer> comunesOrdenados = getElementosComunes(DesordenadaList1, DesordenadaList2);
        System.out.println("ComunesOrdenados : "+comunesOrdenados);




    }
    public static void llenarListaDesordenada(MySimpleLinkedList<Integer> lista, int size){
        Integer num;

        for(int i = 0; i < size; i++){
            num = (int) (Math.random() * 20);
            lista.insertFront(num);
        }
    }
    public static void llenarListaOrdenada(MySimpleLinkedList<Integer> lista, int size){
        Integer num;

        for(int i = 0; i < size; i++){
            num = (int) (Math.random() * 20);
            lista.insertOrdered(num);
        }
    }

    public static MySimpleLinkedList<Integer> getElementosComunes(MySimpleLinkedList<Integer> lista1,
                                                                  MySimpleLinkedList<Integer> lista2) {
        MySimpleLinkedList<Integer> Comunes = new MySimpleLinkedList<>();
        Iterator<Integer> puntero1 = lista1.iterator();
        while(puntero1.hasNext()){
            Integer num1 = puntero1.next();
            Iterator<Integer> puntero2 = lista2.iterator();
            while(puntero2.hasNext()){
                Integer num2 = puntero2.next();
                if (num1.equals(num2)){
                    Comunes.insertOrdered(num1);
                    break;
                }
            }
        }
        return Comunes;
    }

}



















