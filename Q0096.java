public class Q0096 {

    public static int numTrees(int n) {

        int[] sum = new int[n + 2];
        sum[0] = 1;
        sum[1] = 1;
        for(int i = 2; i <= n; i++){
            int k = i - 1;
            for(int j = 0; j < i; j++){
                sum[i] += sum[j] * sum[k];
                k--;
            }
        }
        return sum[n];
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(numTrees(n));
    }
}