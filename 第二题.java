import java.lang.Thread;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        thread r = new thread();
        r.start();
    }
}
class thread implements Runnable{
    static int S1 = 0;
    static int S2 = 0;
    static class R1 implements Runnable{
        //重写run()方法
        public void run() {
            int i, j;
                for (i = 1; i <= 10000; i++) {
                    if (i == 1 || i == 2) {
                        continue;
                    }
                    for (j = 2; j < i; j++) {
                        if (i % j == 0)
                            break;
                        if (j == i - 1)
                                S1 += i;
                    }
            }
            System.out.println(S1);
        }
        public void start(){
            run();
        }
    }
    static class R2 implements Runnable{
        //重写run()方法
        public void run() {
                for (int i = 1; i <= 10000; i++) {  //初始默认值i=1,判断i是否小于等于10000;如果i小于等于10000,
                    //则执行循环体,执行后i+1,否则输出
                    int count = 0;                      //定义	累加和
                    for (int j = 1; j < i; j++) {          //定义一个j,判断这个i是否是因字数
                        if (i % j == 0) {                    //判断i是否可以整除j
                            count = count + j;    //如果j是因字数就把j的值加入到count的值中
                        }
                    }
                    if (i == count) {                  //判断i的值是否和count的值相等,因为完全数为个个因字数相加的和
                        S2 += i;
                    }
                }
            System.out.println(S2);
        }
        public void start(){
            run();
        }
    }
    public void run(){
        R1 r1 = new R1();
        r1.start();
        R2 r2 = new R2();
        r2.start();
        BigInteger a1 = new BigInteger(Integer.toString(S1));
        BigInteger a2 = new BigInteger(Integer.toString(S2));
        System.out.println(a1.multiply(a2));
    }
    public void start(){
        run();
    }
}
