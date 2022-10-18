import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args){
        C c = new C();
    }

}
class C {
    JFrame f;
    JPanel p1;
    JPanel p3;
    JPanel p4;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JTextArea t1;
    JTextArea t2;
    JTextArea t3;
    JButton b1,b2;
    JTextArea textarea;
    File file;
    BufferedWriter bw;
    BufferedReader br;
    String line;
    int x,y,len;
    int[] z = new int[100];
    public C() {
        f = new JFrame("文本控件");
        f.setSize(500, 520);//设置窗口大小
        f.setLocation(1000, 200);//设置窗口在屏幕的位置
        f.setLayout(null);//设置窗口布局
        f.getContentPane().setBackground(new Color(245, 245, 245));//设置窗口背景

        p1 = new JPanel();
        p1.setBounds(10, 10, 467, 150);//设置面板位置和大小
        p1.setBackground(new Color(128, 128, 128));
        p1.setLayout(null);//取消默认布局


        textarea = new JTextArea(20, 30);//聊天文本
        textarea.setLineWrap(true);
        textarea.setBounds(3, 8, 460, 280);
        textarea.setEditable(false);//不可编辑
        textarea.setFont(new Font("宋体", Font.BOLD, 24));

        p4 = new JPanel();
        p4.setBounds(10, 150, 467, 300);
        p4.setBackground(new Color(176, 196, 222));
        p4.setLayout(null);

        l1 = new JLabel("成绩:");//第一个标签
        l1.setFont(new Font("微软雅黑", Font.PLAIN, 17));//设置字体
        l1.setForeground(new Color(30, 10, 10));
        l1.setBounds(20, 40, 150, 30);

        l2 = new JLabel("学号:");//第二个标签
        l2.setFont(new Font("微软雅黑", Font.PLAIN, 17));//设置字体
        l2.setForeground(new Color(30, 10, 10));
        l2.setBounds(20, 75, 150, 30);

        l3 = new JLabel("姓名:");//第三个标签
        l3.setFont(new Font("微软雅黑", Font.PLAIN, 17));//设置字体
        l3.setForeground(new Color(30, 10, 10));
        l3.setBounds(215, 40, 150, 30);

        t1 = new JTextArea();//输入栏
        t1.setLineWrap(true);
        t1.setBounds(60, 45, 150, 23);
        t1.setFont(new Font("宋体", Font.BOLD, 20));//设置字体

        t2 = new JTextArea();//输入栏
        t2.setLineWrap(true);
        t2.setBounds(255, 45, 150, 23);
        t2.setFont(new Font("宋体", Font.BOLD, 20));//设置字体

        t3 = new JTextArea();//输入栏
        t3.setLineWrap(true);
        t3.setBounds(60, 80, 345, 23);
        t3.setFont(new Font("宋体", Font.BOLD, 20));//设置字体

        b1 = new JButton("save");//加按钮
        b1.setBounds(120, 120, 80, 30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        b2 = new JButton("output");//加按钮
        b2.setBounds(260, 120, 80, 30);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output();
            }
        });

        p1.add(l1);
        p1.add(l2);
        p1.add(l3);
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p4.add(textarea);


        f.add(b1);
        f.add(b2);
        f.add(p1);
        f.add(p4);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {        //为关闭程序添加监听器
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void save() {
        String s1 = t1.getText();//获得成绩中的字符
        String s2 = t2.getText();//获得姓名中的字符
        String s3 = t3.getText();//获得学号中的字符
        t1.setText("");
        t2.setText("");
        t3.setText("");
        File file = new File("写入.txt");
        textarea.append("成绩" + s1);
        textarea.append("姓名" + s2);
        textarea.append("学号" + s3);
        textarea.append("\n");
        try {
            if (!file.exists()) {
                //创建写出流对象
                bw = new BufferedWriter(new FileWriter("写入.txt"));
                textarea.append("写入.txt已创建");
            } else {
                bw = new BufferedWriter(new FileWriter(file, true)); //-------表示续写原文件
                bw.newLine();
            }
            bw.write("成绩:" + s1 + " " + "姓名:" + s2 + " " + "学号:" + s3);
            bw.close();
        } catch (Exception ie) {
            System.out.println(ie);
        }
    }
    public void output(){
        try {
            br = new BufferedReader(new FileReader("写入.txt"));
            int i = 0;
            while((line = br.readLine()) != null){
                x=line.indexOf(":");
                y=line.indexOf(" ");
                //获取成绩在line中的索引区间
                z[i]=Integer.parseInt(line.substring(x+1,y));
                i++;
                len=i;//将成绩的个数保存
            }
            textarea.append("平均值："+average(z)+"");
            textarea.append("\n");
            textarea.append("最大值："+findMaxByFor(z)+"");
            textarea.append("\n");
            textarea.append("最小值："+findMinByFor(z)+"");
            textarea.append("\n");
            br.close();
        }catch (Exception oe){
            System.out.println(oe);
        }
    }
    private double average(int[] array) {//返回数组平均值
        int sum = 0;
        for(int x : array){
            sum += x;
        }
        return (double)sum/len;
    }
    private int findMaxByFor(int[] arr) {
        int max = 0; // 最大值
        for (int item : arr) {
            if (item > max) { // 当前值大于最大值，赋值为最大值
                max = item;
            }
        }
        return max;
    }
    private int findMinByFor(int[] arr) {
        int min= arr[0];
        for(int i = 1;i < len; i++) {
            if (min> arr[i]) {
                min= arr[i];
            }
        }
        return min;
    }
}
