import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MyMouse extends JFrame {
    MyPanel p;
    JFrame f;
    static int n = 1;
    public MyMouse() {
        MyPanel p =new MyPanel();
        JFrame f = new JFrame();
        f.setBounds(700, 200, 500, 500);

        f.addMouseListener(new MouseListener() {//加入鼠标监听器

            public void mouseClicked(MouseEvent arg0) {
                p.x = arg0.getX()-32;//减小数值是为了调整图像位置
                p.y = arg0.getY()-55;
                if(arg0.getClickCount()==1 && arg0.getButton()==arg0.BUTTON1){//左键单击
                    n = 1;
                    p.clickbutto = n;
                    p.repaint();
                    n = 1;
                }
                else if(arg0.getClickCount()==2 && arg0.getButton()==arg0.BUTTON1){//左键双击
                    n =2;
                    p.clickbutto = n;
                    p.repaint();
                    n = 1;
                }
                else {//右键单击
                    n = 3;
                    p.clickbutto = n;
                    p.repaint();
                    n = 1;
                }
            }

            public void mouseEntered(MouseEvent arg0) {
            }

            public void mouseExited(MouseEvent arg0) {
            }

            public void mousePressed(MouseEvent arg0) {
            }

            public void mouseReleased(MouseEvent arg0) {
            }

        });

        f.add(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗口即程序结束
        f.setVisible(true);
    }

    public static void main(String[] args) {

        MyMouse test = new MyMouse();//主程序

    }

}
class MyPanel extends JPanel {
    int clickbutto = 0;//获取鼠标点击状态
    int x;int y;
    @Override
    public void paint(Graphics g) {
        if (clickbutto == 1) // 单击左键
        {
            g.setColor(Color.GREEN);
            g.fillOval(x, y, 50, 50);
        } else if (clickbutto == 2) // 双击左键
        {
            g.setColor(Color.WHITE);
            super.paint(g);//删除
        } else if (clickbutto == 3) // 单击右键
        {
            g.setColor(Color.RED);
            g.fillRect(x, y, 50, 50);
        }
    }
}
