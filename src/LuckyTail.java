public class LuckyTail {
    /**
     * @param n 有n个人
     * @param t 报t个数
     * @return
     */
    public int luckyTail(int n, int t) {
        if (n < 1) {//安全验证
            return 0;
        }
        int cnt = 0;
        int[] arr = new int[n];
        while (arr[n - 1] != 1) {
            for (int i = 0, j = 1; i < n; i++, j++) {
                if (arr[i] == 1) {
                    j--;
                    continue;
                } else if (j == 5 && i == n - 1) {
                    cnt++;
                    arr[i] = 1;
                    break;
                } else if (j == 5 && i != n - 1) {
                    arr[i]++;
                    j = 0;
                    cnt++;
                } else if (j != 5 && i == n - 1) {
                    i = -1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LuckyTail luckyTail = new LuckyTail();
        int i = luckyTail.luckyTail(99, 5);
        System.out.println(i);
    }
}
