import java.util.Arrays;
import java.util.Scanner;

public class Question_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array X: ");
        int m = scanner.nextInt();
        int[] X = new int[m];
        
        System.out.println("Enter the elements of array X:");
        for (int i = 0; i < m; i++) {
            X[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of array Y: ");
        int n = scanner.nextInt();
        int[] Y = new int[n];

       
        System.out.println("Enter the elements of array Y:");
        for (int i = 0; i < n; i++) {
            Y[i] = scanner.nextInt();
        }

        mergeArrays(X, Y, m, n);
        System.out.println("X[]= " + Arrays.toString(X));

        scanner.close();
    }

    public static void mergeArrays(int[] X, int[] Y, int m, int n) {
        
        int last = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (X[i] != 0) {
                X[last--] = X[i];
            }
        }

        
        int i = last + 1; 
        int j = 0; 
        int k = 0; 
        while (i < m && j < n) {
            if (X[i] < Y[j]) {
            	
                X[k++] = X[i++];
            } else {
                X[k++] = Y[j++];
            }
        }

        
        while (j < n) {
            X[k++] = Y[j++];
        }
        Arrays.sort(X);
    }
}