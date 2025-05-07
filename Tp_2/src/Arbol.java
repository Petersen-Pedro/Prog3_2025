import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Arbol {

    private TreeNodeInt root;

    public Arbol() {
        root = null;
    }

    public Arbol(TreeNodeInt root) {
        this.root = root;
    }

    // Complejidad O(1) porque devuelve el valor de la raiz del arbol.
    public TreeNodeInt getRoot() {
        return root;
    }

    // En el peor de los casos, la complejidad es O(a), donde a es la altura del arbol
    // En un arbol balanceado la complejidad es O(log n) y en un arbol desbalanceado seria O(n)
    public boolean hasElem(Integer value) {
        return hasElem(this.root, value);
    }
    private boolean hasElem(TreeNodeInt node, Integer value) {
        if (node == null) {
            return false;
        }
        if (node.getData().equals(value)) {
            return true;
        }
        if (value < node.getData()) {
            return hasElem(node.getLeft(), value);
        }
        return hasElem(node.getRight(), value);
    }

    // Complejidad O(1) simplemente chequea la raiz
    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    //
    public void insert(Integer value) {
        if (isEmpty()) {
            this.root = new TreeNodeInt(value);
        } else
            insert(this.root, value);
    }
    private void insert(TreeNodeInt node, Integer value){
        if (node.getData() > value) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNodeInt(value));
            } else {
                insert(node.getLeft(), value);
            }
        }
        else if (node.getData() < value) {
            if (node.getRight() == null) {
                node.setRight(new TreeNodeInt(value));
            } else {
                insert(node.getRight(), value);
            }
        }
    }

    // En el peor de los casos es O(n)
    public boolean detete(Integer value) {
        if (value != null) {
            this.root = delete(this.root, value);
            return true;
        }
        return false;
    }
    private TreeNodeInt delete(TreeNodeInt node, Integer value) {
        if (value < node.getData()) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value > node.getData()) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            TreeNodeInt aux = encontrarMinValue(node.getRight());
            node.setData(aux.getData());
            node.setRight(delete(node.getRight(), aux.getData()));
        }
        return node;
    }
    private TreeNodeInt encontrarMinValue(TreeNodeInt node) {
        TreeNodeInt aux = node;
        while (aux.getLeft() != null) {
            aux = aux.getLeft();
        }
        return aux;
    }

    public int getHeight() {

        return getHeight(this.root);
    }
    private int getHeight(TreeNodeInt node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.getLeft());
            int rightHeight = getHeight(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // Complejidad O(n) porque recorre todo el arbol
    public void printPreOrder() {
        printPreOrder(this.root);
    }
    private void printPreOrder(TreeNodeInt node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }// Complejidad O(n) porque recorre todo el arbol
    public void printPostOrder() {
        printPostOrder(this.root);
    }
    private void printPostOrder(TreeNodeInt node) {
        if (node != null) {
            printPostOrder(node.getLeft());
            printPostOrder(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }// Complejidad O(n) porque recorre todo el arbol
    public void printInOrder() {
        printInOrder(this.root);
    }
    private void printInOrder(TreeNodeInt node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }

    // O(n) ya que recorre todo el arbol
    public List<Integer> getLongestBranch(){
        List<Integer> listLarga = new ArrayList<>();
        List<Integer> listActual = new ArrayList<>();
        getLongestBranch(this.root, listLarga, listActual, 0);
        return listLarga;
    }
    private void getLongestBranch(TreeNodeInt node, List<Integer> listLarga,
                                  List<Integer> listActual, int nivel) {
        if (node != null) {
            listActual.add(node.getData());

            if (node.getLeft() == null && node.getRight() == null){
                if (listActual.size() >  listLarga.size()) {
                    listLarga.clear();
                    listLarga.addAll(listActual);
                }
            } else {
                getLongestBranch(node.getLeft(), listLarga, listActual, nivel + 1);
                getLongestBranch(node.getRight(), listLarga, listActual, nivel + 1);
            }
            listActual.remove(listActual.size() - 1);
        }
    }

    //
    public List<Integer> getFrontera(){
        List<Integer> frontera = new ArrayList<>();
        getFrontera(this.root, frontera);
        return frontera;
    }
    private void getFrontera(TreeNodeInt node, List<Integer> frontera) {
        if (node == null) return;
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null){
                frontera.add(node.getData());
                // GIL, acordate que Java pasa las referencias a objetos
                // por valor, lo que significa que los cambios sobre el
                // objeto referenciado se reflejan fuera del metodo.
            }
        } else {
            getFrontera(node.getLeft(), frontera);
            getFrontera(node.getRight(), frontera);
        }
    }

    // La complejidad  es O(h) ya que desendera directamente por la rama derecha del arbol siempre.
    public Integer getMaxElem(){
        if (this.root == null) {
            return null;
        } else {
        TreeNodeInt aux = this.root;

        while(aux.getLeft() != null) {
            aux = aux.getLeft();
        }

        return aux.getData();
        }
    }

    // La complejidad es O(n) yua que en el peor de los casos va recorrer todo el arbol completo.
    public List getElemAtLevel(int level){
        List<Integer> lista = new ArrayList<>();
        getElemAtLevel(this.root, level, lista, 1);
        return lista;
    }
    private void getElemAtLevel(TreeNodeInt node, int level, List<Integer> lista, Integer lvlCurrent) {
        if (node != null) {
            if (lvlCurrent == level) {
                lista.add(node.getData());
            } else if (lvlCurrent < level) {
                if (node.getRight() != null){
                    getElemAtLevel(node.getRight(), level, lista, lvlCurrent + 1);
                } if (node.getLeft() != null){
                    getElemAtLevel(node.getLeft(), level, lista, lvlCurrent + 1);
                }
            }
        }
    }

    public int sumaNodesDataTotal() {
        if (this.root != null)
           return sumaNodesDataTotal(this.root);
        return 0;
    }
    private int sumaNodesDataTotal(TreeNodeInt node) {
        int suma = 0;
        if (node != null) {
            suma =  suma + node.getData() +
                    sumaNodesDataTotal(node.getLeft()) +
                    sumaNodesDataTotal(node.getRight());
        }
        return suma;
    }

    public int sumaNodesInternos() {
        if (this.root != null)
            return sumaNodesInternos(this.root);
        return 0;
    }
    private int sumaNodesInternos(TreeNodeInt node) {
        int suma = 0;
        if (node != null) {
            if (node.getRight() != null && node.getLeft() != null) {
                suma = suma + node.getData() +
                        sumaNodesInternos(node.getLeft()) +
                        sumaNodesInternos(node.getRight());
            }
        }
        return suma;
    }
    public int sumaNodesExternos() {
        if (this.root != null)
            return sumaNodesExternos(this.root);
        return 0;
    }
    private int sumaNodesExternos(TreeNodeInt node) {
        int suma = 0;
        if (node != null) {
            if (node.getRight() == null && node.getLeft() == null) {
                suma = node.getData();
            }
            else {
                suma =  sumaNodesExternos(node.getLeft()) +
                        sumaNodesExternos(node.getRight());
            }
        }
        return suma;
    }

    public List hojasMayorValor(int valor) {
        List<Integer> listaMayores = new ArrayList<>();
        hojasMayorValor(this.root, listaMayores, valor);
        return listaMayores;
    }
    private void hojasMayorValor(TreeNodeInt node, List listaMayores, int valor) {
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null){
                if (node.getData() > valor) {
                    listaMayores.add(node.getData());
                }
            } else {
                hojasMayorValor(node.getLeft(), listaMayores, valor);
                hojasMayorValor(node.getRight(), listaMayores, valor);
            }
        }

    }
    public void sumaRestaNodos() {
        sumaRestaNodos(this.root);
    }
    private int sumaRestaNodos(TreeNodeInt node) {
        int suma = 0;
        if (node != null){
            if (node.getData() == null){
                suma =  sumaRestaNodos(node.getRight()) -
                        sumaRestaNodos(node.getLeft());
                node.setData(suma);
            } else {
                suma = node.getData();
            }
        }
        return suma;
    }

















}
