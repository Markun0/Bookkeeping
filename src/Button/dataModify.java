package Button;

import DatabaseInput.dataAdd;
import Date.DateCalendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dataModify {
    public static int newData=1;
    public void datamodify(String str[]){
        JFrame f=new JFrame();
        f.setSize(400,300);
        f.setLayout(new BorderLayout());
        f.setLocation(800, 200);
        JPanel d = new JPanel();
        d.setSize(400, 200);

        d.setLayout(new GridLayout(4,2));

        JLabel Spense = new JLabel("花费");
        JTextField SpenseText = new JTextField("");
        SpenseText.setText(str[0]);
        SpenseText.setPreferredSize(new Dimension(80,30));
        JLabel Type = new JLabel("分类");
        String[] typeStr=new String[]{"餐饮", "出行","日常","送礼" ,"其他"};
        JComboBox TypeComboBox=new JComboBox(typeStr);
        for(int i=0;i<5;i++) {
            if(str[1].equals(typeStr[i]))TypeComboBox.setSelectedIndex(i);
        }
        JLabel Mark = new JLabel("备注");
        JTextField MarkText = new JTextField("");
        MarkText.setText(str[2]);
        JLabel Date = new JLabel("日期");
        JComboBox DateComboBox=new DateCalendar().calendar();
        int day=Integer.valueOf(str[3].substring(8,10));
        DateComboBox.setSelectedIndex(newData-day);

        d.add(Spense);
        d.add(SpenseText);
        d.add(Type);
        d.add(TypeComboBox);
        d.add(Mark);
        d.add(MarkText);
        d.add(Date);
        d.add(DateComboBox);
        d.setVisible(true);

        JPanel southPanel=new JPanel();
        JButton button=new JButton("确定");
        button.setPreferredSize(new Dimension(100,30));
        southPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataAdd add=new dataAdd();
                dataDelete delete=new dataDelete();
                int[] ids=new int[1];
                ids[0]=Integer.valueOf(str[4]);
                delete.delete(ids);
                add.Add(Integer.parseInt(SpenseText.getText()),(String) TypeComboBox.getSelectedItem(),MarkText.getText(),(String) DateComboBox.getSelectedItem());
                JOptionPane.showMessageDialog(f,"修改成功");
                f.setVisible(false);
            }
        });

        f.add(d,BorderLayout.CENTER);
        f.add(southPanel,BorderLayout.SOUTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
