import java.util.Scanner;

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

public class disyuntos{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int count_estud = sc.nextInt();
            int count_group = sc.nextInt();
            if (count_estud==0 && count_group==0) {
                break;
            }
            Disyuntos conj = new Disyuntos(count_estud);
            for (int i = 0; i < count_group; i++) {
                int k = sc.nextInt();
                int previo = -1;
                for (int j = 0; j < k; j++) {
                    int stu = sc.nextInt();
                    if (previo != -1) {
                        conj.union(previo, stu);
                    }
                    previo = stu;
                }
            }
            int root = conj.find(0);
            int count = 0;
            for (int i = 0; i < count_estud; i++) {
                if (conj.find(i) == root) {
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}