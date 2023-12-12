package Table;

import Button.*;
import DatabaseInput.dataGet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseTable {
    String[] columnNames = new String[] { "id","花费", "分类", "备注","日期"};
    public static Integer k= 10;
    String[][] heros = new dataGet().getHeros();
    JButton modifyButton=new JButton("修改");
    JButton deleteButton=new JButton("删除");
    public void expenseTable(){
        JFrame f = new JFrame("账本");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());

        DefaultTableModel model=new DefaultTableModel(heros,columnNames);
        //根据 TableModel来创建 Table
        JTable t = new JTable(model);
        TableColumn tableColumn=t.getColumn("id");
        t.removeColumn(tableColumn);

        JScrollPane sp = new JScrollPane(t);

        f.add(sp, BorderLayout.CENTER);
        JPanel p=new JPanel(new FlowLayout());

        deleteButton.setSize(new Dimension(10,100));
        modifyButton.setSize(new Dimension(10,100));
        p.add(modifyButton);
        p.add(deleteButton);
        f.add(p,BorderLayout.SOUTH);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] rows=t.getSelectedRows();
                if(rows.length==0){
                    JOptionPane.showMessageDialog(f,"未选择删除位置");
                }
                else {
                    int[] ids = new int[rows.length];
                    for (int i = 0; i < rows.length; i++) {
                        ((DefaultTableModel) t.getModel()).removeRow(rows[i]);
                        ids[i] = Integer.valueOf(heros[rows[i]][0]);
                    }
                    dataDelete d = new dataDelete();
                    JOptionPane.showMessageDialog(f, "修改成功");
                    d.delete(ids);
                }
            }
        });
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=t.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(f,"未选择修改位置");
                }
                else {
                    String[] str={heros[row][1],heros[row][2],heros[row][3],heros[row][4],heros[row][0]};
                    dataModify modify=new dataModify();
                    modify.datamodify(str);
                }
            }
        });
    }

}
