package Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import Table.ExpenseTable;

public class Category {
    public JPanel category(){
        JPanel f=new JPanel();
        f.setSize(400, 300);
        f.setLocation(800, 200);
        f.setLayout(new BorderLayout());
        f.add(center(), BorderLayout.CENTER);
        f.add(south(), BorderLayout.SOUTH);

        return f;
    }
    int times1,times2,times3,times4,times5;
    public void getTimes(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        times1=times2=times3=times4=times5=0;
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/booksbase?characterEncoding=UTF-8","root", "Mkl20040310");
             Statement s = c.createStatement();) {

            String sql = "select * from booksmark";
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
            Calendar d= Calendar.getInstance();
            String str=sdf.format(d.getTime());
            while (rs.next()) {
                if(str.substring(0,7).equals(rs.getString(5).substring(0,7))) {
                    String name = rs.getString(3);// 也可以使用字段的顺序
                    //System.out.println(name);
                    if (name.equals("餐饮"))
                        times1++;
                    if (name.equals("出行"))
                        times2++;
                    if (name.equals("日常"))
                        times3++;
                    if (name.equals("送礼"))
                        times4++;
                    if (name.equals("其他"))
                        times5++;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private JScrollPane center(){
        getTimes();
        String[] columnNames = new String[] { "分类名称","消费次数" };
        String[][] heros = new String[][] { {"餐饮", ""+times1 },
                { "出行", ""+times2 }, { "日常", ""+times3 } ,{"送礼",""+times4},{"其他",""+times5}};
        JTable t = new JTable(heros, columnNames);
        JScrollPane sp = new JScrollPane(t);
        return sp;
    }
    private JPanel south(){
        JPanel p=new JPanel();
        JButton b = new JButton("查看账单");
        //生成本月账单表格
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExpenseTable et=new ExpenseTable();
                et.expenseTable();
            }
        });
        p.add(b);
        return p;
    }
}
