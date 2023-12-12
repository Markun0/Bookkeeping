package Panel;

import DatabaseInput.dataAdd;
import Date.DateCalendar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class SpenseRecord {
    JPanel f=new JPanel();
    public JPanel record(){
        f.setSize(400, 300);
        f.setLocation(800, 200);
        f.setLayout(new BorderLayout());

        f.add(north(), BorderLayout.NORTH);
        f.add(south(), BorderLayout.SOUTH);

        return f;
    }
    JTextField Spend;
    JComboBox Type;
    JTextField Remark;
    JComboBox Date;
    private JPanel north(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,2));

        JLabel name1=new JLabel("花费(¥)");
        Spend = new JTextField("");
        Spend.setText("0");
        Spend.setPreferredSize(new Dimension(40, 30));

        JLabel name2=new JLabel("分类");
        String[] heros = new String[] { "餐饮", "出行","日常","送礼" ,"其他"};
        Type = new JComboBox(heros);

        Type.setBounds(50, 50, 40, 30);
        Date=new DateCalendar().calendar();
        JLabel name3=new JLabel("备注");
        Remark = new JTextField("");
        Remark.setText("");
        Remark.setPreferredSize(new Dimension(40, 30));

        JLabel name4=new JLabel("日期");


        p.add(name1);
        p.add(Spend);
        p.add(name2);
        p.add(Type);
        p.add(name3);
        p.add(Remark);
        p.add(name4);
        p.add(Date);
        return p;
    }
    private JPanel south(){
        JPanel p = new JPanel();
        JButton b = new JButton("记一笔");
        b.setBounds(50, 50, 280, 30);
        p.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String typestr=(String)Type.getSelectedItem();
                String datestr=(String) Date.getSelectedItem();
                dataAdd da=new dataAdd();
                da.Add(Integer.parseInt(Spend.getText()),typestr,Remark.getText(),datestr);
                JOptionPane.showMessageDialog(f,"添加成功");
            }
        });
        return p;
    }
}
