package ds;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kenvi on 16/5/26.
 */
public class H_DisjointSet_ComponentsInAGraph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int b,g;

        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(2*N + 1);

        while( N --> 0) {
            b = scanner.nextInt();
            g = scanner.nextInt();
            uf.union(b,g);
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i< uf.sz.length; i++) {

            int size = uf.getComponentSize(i);
            if(size == -1) continue;
            if(size > max) max = size;
            if(size < min) min = size;

        }

        System.out.println(min + " " +max);



    }

    static class WeightedQuickUnionUF {
        private int[] id;
        public int[] sz;
        public WeightedQuickUnionUF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) id[i] = -1;
            sz = new int[N];
            for (int i = 0; i < N; i++) {
                sz[i] = -1;
            }

        }

        private int find(int p) {
            while (p != id[p]) p = id[p];
            return p;
        }

        public int getComponentSize(int p) {
            if(id[p] == -1)  {
                return -1;
            }
            return sz[find(p)];

        }

        public void union(int p, int q) {
            if(id[p] == -1) {id[p] = p; sz[p] = 1;}
            if(id[q] == -1) {id[q] = q; sz[q] = 1;}
            int i = find(p);
            int j = find(q);
            if(i == j) return;
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];

            } else {
                id[j] = i;
                sz[i] += sz[j];

            }
        }

    }
}
