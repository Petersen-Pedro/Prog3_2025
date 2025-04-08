import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

public class Arbol {

    private TreeNodeInt root;

    public Arbol() {
        root = null;
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
        insert(this.root, value);
    }
    private void insert(TreeNodeInt node, Integer value){
        if (node.getData() == null) {
            node.setData(value);
        }
        else if (node.getData() > value) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNodeInt(value));
            } else {
                insert(node.getLeft(), value);
            }
        }
        else /*node.getData() < value)*/ {
            insert(node.getRight(), value);
        }

    }

}
