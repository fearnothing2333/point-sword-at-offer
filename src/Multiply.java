public class Multiply {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        int[] arr = {1, 2, 3, 4, 5, 6};
        multiply.multiply(arr);
    }
}
