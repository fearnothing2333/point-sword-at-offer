import java.util.Scanner;

/**
 * 输出范围内的质数
 */
public class OutputPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入开始值");
        int start = sc.nextInt();
        System.out.println("请输入结束值");
        int end = sc.nextInt();
        outputPrimeNumber(start, end);
    }

    public static void outputPrimeNumber(int a, int z) {
        int temp = 0;
        for (int i = a; i <= z; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {//遍历除了一和自身之间的每一个数
                if (i % j == 0) {//如果能除尽，就说明不是质数
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.println(i);
                System.out.println("差值为" + (i - temp));
                temp = i;
            }
        }
    }
}
