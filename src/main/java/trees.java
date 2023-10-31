class TNode {
    int value;
    TNode left;
    TNode right;
    TNode parent;

    public TNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

class BT{
    TNode root;

    public BT() {
        root = null;
    }

    public void insert(int value) {
        root = insertRecursive(root, value, null);
    }

    private TNode insertRecursive(TNode root, int value, TNode parent) {
        if (root == null) {
            root = new TNode(value);
            root.parent = parent; 
            return root;
        }

        if (value < root.value) {
            root.left = insertRecursive(root.left, value, root);
        } else if (value > root.value) {
            root.right = insertRecursive(root.right, value, root);
        }

        return root;
    }

    public void findSmall(int k) {
        int[] count = { 0 };
        TNode result = findSmallest(root, k, count, null);

        if (result != null) {
            System.out.println(result.value + " " + (result.parent == null ? -1 : result.parent.value));
        } else {
            System.out.println("No se encontró el k-ésimo elemento.");
        }
    }

    private TNode findSmallest(TNode node, int k, int[] count, TNode parent) {
        if (node == null) {
            return null;
        }

        TNode leftResult = findSmallest(node.left, k, count, node);
        if (leftResult != null) {
            return leftResult;
        }

        count[0]++;
        if (count[0] == k) {
            return node;
        }

        TNode rightResult = findSmallest(node.right, k, count, node);
        if (rightResult != null) {
            return rightResult;
        }

        return null;
    }
}