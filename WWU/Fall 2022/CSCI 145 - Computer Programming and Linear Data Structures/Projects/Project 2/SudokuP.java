
/*
 * SudokuP.java
 * CSCI 145
 * 
 * Author - Qiang Hao (2017), Filip Jagodzinski (2020), Moushumi Sharmin (2022)
 * 
 * The purpose of this class is to provide a sudoku puzzle board.
 * Do not modify any source code in this file.  
 */
import java.util.Random;

public class SudokuP {

    private static int[][] a = new int[9][9];

    public static char[][] puzzle() {
        int counter = 1, k1, k2;
        generate();
        randomGen(1);
        randomGen(0);
        Random rand = new Random();
        int n[] = { 0, 3, 6 };
        for (int i = 0; i < 2; i++) {
            k1 = n[rand.nextInt(n.length)];
            do {
                k2 = n[rand.nextInt(n.length)];
            } while (k1 == k2);
            if (counter == 1) {
                rowChange(k1, k2);
            } else {
                colChange(k1, k2);
            }
            counter++;
        }
        drillHoles();
        char[][] result = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j] == 0) {
                    result[i][j] = '.';
                } else {
                    result[i][j] = Integer.toString(a[i][j]).charAt(0);
                }
            }
        }
        return result;
    }

    private static void generate() {
        int k = 1, n = 1;
        for (int i = 0; i < 9; i++) {
            k = n;
            for (int j = 0; j < 9; j++) {
                if (k <= 9) {
                    a[i][j] = k;
                    k++;
                } else {
                    k = 1;
                    a[i][j] = k;
                    k++;
                }
            }
            n = k + 3;
            if (k == 10)
                n = 4;
            if (n > 9)
                n = (n % 9) + 1;
        }
    }

    private static void randomGen(int check) {
        int k1, k2, max = 2, min = 0;
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            k1 = r.nextInt(max - min + 1) + min;
            do {
                k2 = r.nextInt(max - min + 1) + min;
            } while (k1 == k2);
            max += 3;
            min += 3;
            if (check == 1)
                permutationRow(k1, k2);
            else if (check == 0)
                permutationCol(k1, k2);
        }
    }

    private static void permutationRow(int k1, int k2) {
        int temp;
        for (int j = 0; j < 9; j++) {
            temp = a[k1][j];
            a[k1][j] = a[k2][j];
            a[k2][j] = temp;
        }
    }

    private static void permutationCol(int k1, int k2) {
        int temp;
        for (int j = 0; j < 9; j++) {
            temp = a[j][k1];
            a[j][k1] = a[j][k2];
            a[j][k2] = temp;
        }
    }

    private static void rowChange(int k1, int k2) {
        int temp;
        for (int n = 1; n <= 3; n++) {
            for (int i = 0; i < 9; i++) {
                temp = a[k1][i];
                a[k1][i] = a[k2][i];
                a[k2][i] = temp;
            }
            k1++;
            k2++;
        }
    }

    private static void colChange(int k1, int k2) {
        int temp;
        for (int n = 1; n <= 3; n++) {
            for (int i = 0; i < 9; i++) {
                temp = a[i][k1];
                a[i][k1] = a[i][k2];
                a[i][k2] = temp;
            }
            k1++;
            k2++;
        }
    }

    private static void drillHoles() {
        int cols, col;
        Random r = new Random();
        for (int i = 0; i < 9; i++) {
            cols = r.nextInt(6) + 1;
            for (int j = 0; j < cols; j++) {
                col = r.nextInt(9);
                a[i][col] = 0;
            }
        }
    }
}