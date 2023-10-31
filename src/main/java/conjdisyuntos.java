class Disyuntos{
    private int[] parent;

    public Disyuntos(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int k, int m) {
        int rX = find(k);
        int rY = find(m);
        if (rX != rY) {
            parent[rX] = rY;
        }
    }
}