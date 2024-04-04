import java.util.*;

public class Question_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array X
        System.out.print("Enter the size of array X: ");
        int sizeX = scanner.nextInt();
        int[] X = new int[sizeX];
        System.out.println("Enter elements of array X in sorted order:");
        for (int i = 0; i < sizeX; i++) {
            X[i] = scanner.nextInt();
        }

        // Input array Y
        System.out.print("Enter the size of array Y: ");
        int sizeY = scanner.nextInt();
        int[] Y = new int[sizeY];
        System.out.println("Enter elements of array Y in sorted order:");
        for (int i = 0; i < sizeY; i++) {
            Y[i] = scanner.nextInt();
        }

        // Find maximum sum path
        List<Integer> maxSumPath = findMaximumSumPath(X, Y);

        // Display maximum sum path
        System.out.print("The maximum sum path is: ");
        for (int i = 0; i < maxSumPath.size() - 1; i++) {
            System.out.print(maxSumPath.get(i) + " -> ");
        }
        System.out.println(maxSumPath.get(maxSumPath.size() - 1));

        // Compute and display maximum sum
        int maxSum = maxSumPath.stream().mapToInt(Integer::intValue).sum();
        System.out.println("The maximum sum is: " + maxSum);
    }

    public static List<Integer> findMaximumSumPath(int[] X, int[] Y) {
        int m = X.length;
        int n = Y.length;
        int i = 0, j = 0;

        List<Integer> maxSumPath = new ArrayList<>();

        while (i < m && j < n) {
            if (X[i] < Y[j]) {
                maxSumPath.add(X[i++]);
            } else if (Y[j] < X[i]) {
                maxSumPath.add(Y[j++]);
            } else {
                // Found a common element, find maximum sum path until this point
                int sum1 = findSum(X, i);
                int sum2 = findSum(Y, j);
                maxSumPath.addAll(sum1 >= sum2 ? getPath(X, i) : getPath(Y, j));
                i++;
                j++;
            }
        }

        // Add remaining elements of array X, if any
        while (i < m) {
            maxSumPath.add(X[i++]);
        }

        // Add remaining elements of array Y, if any
        while (j < n) {
            maxSumPath.add(Y[j++]);
        }

        return maxSumPath;
    }

    // Helper method to find sum of elements from a given index till end of array
    private static int findSum(int[] arr, int start) {
        int sum = 0;
        for (int i = start; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Helper method to get path from a given index till end of array
    private static List<Integer> getPath(int[] arr, int start) {
        List<Integer> path = new ArrayList<>();
        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
        }
        return path;
    }
}
