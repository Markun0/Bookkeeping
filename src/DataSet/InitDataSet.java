package DataSet;

import DatabaseInput.dataAdd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Panel.Consume;

public class InitDataSet {
    public void initDataSet(){
        JFrame f=new JFrame("初始内容设置");
        f.setLayout(new BorderLayout());

        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(2,1));
        JLabel label=new JLabel("本月预算:");
        JTextField textField=new JTextField("");
        p1.add(label);
        p1.add(textField);

        JPanel p2=new JPanel();
        JButton button=new JButton("确认");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Consume.MonthBudget=Integer.valueOf(textField.getText());
                JOptionPane.showMessageDialog(f,"设置成功");
                f.setVisible(false);
            }
        });

        f.add(p1,BorderLayout.CENTER);
        f.add(p2,BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
