import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class test extends JFrame {
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        g.drawOval(160, 63,30,30);
        g.fillOval(235,138,30,30);
        g.drawLine(310,213,345,251);
    }
    private void draw(){
        JPanel p = new JPanel();
        JTable t = new JTable(3,3);
        DefaultTableModel model = (DefaultTableModel) t.getModel();


        t.getColumnModel().getColumn(0).setPreferredWidth(75);//设置表格列宽
        t.getColumnModel().getColumn(1).setPreferredWidth(75);
        t.getColumnModel().getColumn(2).setPreferredWidth(75);
        t.setRowHeight(75);//设置表格高度

        t.setModel(model);//更新表格模型
        p.add(t);
        this.add(p);

        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        test t = new test();
        t.draw();
    }
}