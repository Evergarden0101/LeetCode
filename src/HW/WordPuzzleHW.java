package HW;

import java.util.Scanner;

public class WordPuzzleHW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[] w = sc.next().toCharArray();
        char[][] list = new char[n][m];
        char[][] visited = new char[n][m];
        for (int i = 0; i < n; i++) {
            list[i] = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                visited[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list[i][j] == w[0]) {
                    visited[i][j] = 1;
                    if (find(list, w, visited, 0, i, j, n, m)) {
                        int x = i + 1, y = j + 1;
                        System.out.print(x + " " + y);
                        return;
                    }
                    visited[i][j] = 0;
                }
            }
        }
        System.out.println("NO");
    }

    public static boolean find(char[][] list, char[] w, char[][] visited, int idx, int x, int y, int n, int m) {
//        System.out.print(x+" "+y+" "+idx+" "+m);
        if (idx == w.length - 1) return true;
        //左
        if (y - 1 >= 0 && visited[x][y - 1] == 0 && list[x][y - 1] == w[idx + 1]) {
            visited[x][y - 1] = 1;
            if (find(list, w, visited, idx + 1, x, y - 1, n, m))
                return true;
        }
        //右
        if (y + 1 < m && visited[x][y + 1] == 0 && list[x][y + 1] == w[idx + 1]) {
            visited[x][y + 1] = 1;
            if (find(list, w, visited, idx + 1, x, y + 1, n, m))
                return true;
        }
        //下
        if (x + 1 < n && visited[x + 1][y] == 0 && list[x + 1][y] == w[idx + 1]) {
            visited[x + 1][y] = 1;
            if (find(list, w, visited, idx + 1, x + 1, y, n, m))
                return true;
        }
        //上
        if (x - 1 >= 0 && visited[x - 1][y] == 0 && list[x - 1][y] == w[idx + 1]) {
            visited[x - 1][y] = 1;
            if (find(list, w, visited, idx + 1, x - +1, y, n, m))
                return true;
        }
        return false;
    }
}
