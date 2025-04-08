public class TreeNodeInt {
    private Integer data;
    private TreeNodeInt right;
    private TreeNodeInt left;

    public TreeNodeInt(int data) {
        this.data = data;
    }
    public Integer getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public TreeNodeInt getRight() {
        return right;
    }
    public void setRight(TreeNodeInt right) {
        this.right = right;
    }
    public TreeNodeInt getLeft() {
        return left;
    }
    public void setLeft(TreeNodeInt left) {
        this.left = left;
    }

}
