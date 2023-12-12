package MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Panel.*;

public class Main {
    private static JPanel p=new JPanel();
    public static void main(String[] args)throws Exception{
        JFrame jFrame = new JFrame("LoL");

        jFrame.setSize(800, 600);
        jFrame.setLocation(200, 200);

        jFrame.setLayout(new BorderLayout());
        Panel f= new Panel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // 设置组件之间的间距

        ImageIcon i1=new ImageIcon("C:/记账本图片素材/消费一览.jpg");
        JLabel l1 = new JLabel();
        l1.setIcon(i1);

        ImageIcon i2=new ImageIcon("C:/记账本图片素材/记一笔.png");
        JLabel l2 = new JLabel();
        l2.setIcon(i2);

        ImageIcon i3=new ImageIcon("C:/记账本图片素材/消费分类.png");
        JLabel l3 = new JLabel();
        l3.setIcon(i3);

        ImageIcon i4=new ImageIcon("C:/记账本图片素材/月消费报表.png");
        JLabel l4 = new JLabel();
        l4.setIcon(i4);

        ImageIcon i5=new ImageIcon("C:/记账本图片素材/设置.png");
        JLabel l5 = new JLabel();
        l5.setIcon(i5);

        ImageIcon i6=new ImageIcon("C:/记账本图片素材/备份.png");
        JLabel l6 = new JLabel();
        l6.setIcon(i6);

        ImageIcon i7=new ImageIcon("C:/记账本图片素材/恢复.png");
        JLabel l7 = new JLabel();
        l7.setIcon(i7);

        JButton b1 = new JButton("消费一览");
        JButton b2 = new JButton("记账");
        JButton b3 = new JButton("消费分类");
        JButton a1 = new JButton("月消费报表");
        JButton a2 = new JButton("设置");
        JButton a3 = new JButton("备份");
        JButton c3 = new JButton("恢复");

        // 加入到容器即可，无需单独指定大小和位置
        gbc.gridx = 0;
        gbc.gridy = 0;
        f.add(l1,gbc);gbc.gridx++;
        f.add(l2,gbc);gbc.gridx++;
        f.add(l3,gbc);gbc.gridx++;
        f.add(l4,gbc);gbc.gridx++;
        f.add(l5,gbc);gbc.gridx++;
        f.add(l6,gbc);gbc.gridx++;
        f.add(l7,gbc);

        gbc.gridx=0;
        gbc.gridy=3;
        f.add(b1,gbc);gbc.gridx++;
        f.add(b2,gbc);gbc.gridx++;
        f.add(b3,gbc);gbc.gridx++;
        f.add(a1,gbc);gbc.gridx++;
        f.add(a2,gbc);gbc.gridx++;
        f.add(a3,gbc);gbc.gridx++;
        f.add(c3,gbc);

        jFrame.add(f,BorderLayout.NORTH);

        jFrame.setVisible(true);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Consume c = new Consume();
                p.setVisible(false);
                p=c.consume();
                jFrame.add(p,BorderLayout.CENTER);
                jFrame.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SpenseRecord r = new SpenseRecord();
                p.setVisible(false);
                p=r.record();
                jFrame.add(p,BorderLayout.CENTER);
                jFrame.setVisible(true);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Category c = new Category();
                p.setVisible(false);
                p=c.category();
                jFrame.add(p,BorderLayout.CENTER);
                jFrame.setVisible(true);
            }
        });
        a1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Report r=new Report();
                p.setVisible(false);
                p=r.report();
                jFrame.add(p,BorderLayout.CENTER);
                jFrame.setVisible(true);
            }
        });
        a2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        a3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        c3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
