package Panel;

import DatabaseInput.dataGet;

import javax.swing.*;
import java.awt.*;

public class Consume {
    public JLabel lMonthSpend = new JLabel("本月消费");
    public JLabel lTodaySpend = new JLabel("今日消费");
    public JLabel lAvgSpendPerDay = new JLabel("日均消费");
    public JLabel lMonthLeft = new JLabel("本月剩余");
    public JLabel lDayAvgAvailable = new JLabel("日均可用");
    public JLabel lMonthLeftDay = new JLabel("距离月末");


    private int MonthSpend,TodaySpend,AvgSpendPerDay,MonthAvailable,DayAvgAvailable,MonthLeftDay;
    public static int MonthBudget=1500;
    public JLabel vMonthSpend ;
    public JLabel vTodaySpend ;
    public JLabel vAvgSpendPerDay ;
    public JLabel vMonthAvailable ;
    public JLabel vDayAvgAvailable;
    public JLabel vMonthLeftDay ;


    public JPanel consume(){
        dataGet dg=new dataGet();
        int[] spense=dg.getSpense(0);
        MonthSpend=spense[0];TodaySpend=spense[1];AvgSpendPerDay=spense[2];MonthAvailable=spense[3];DayAvgAvailable=spense[4];MonthLeftDay=spense[5];
        vMonthSpend = new JLabel("￥"+MonthSpend);
        vTodaySpend = new JLabel("￥"+TodaySpend);
        vAvgSpendPerDay = new JLabel("￥"+AvgSpendPerDay);
        vMonthAvailable = new JLabel("￥"+MonthAvailable);
        vDayAvgAvailable = new JLabel("￥"+DayAvgAvailable);
        vMonthLeftDay = new JLabel(""+MonthLeftDay);
        JPanel f=new JPanel();
        f.setPreferredSize(new Dimension(400,300));
        f.setLocation(800, 200);
        f.setLayout(new BorderLayout());

        f.add(center(), BorderLayout.CENTER);
        f.add(south(), BorderLayout.SOUTH);

        return f;
    }

    private JPanel center(){
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(400,100));
        p.setLayout(new BorderLayout());
        p.add(west(), BorderLayout.WEST);
        p.add(center2(),BorderLayout.CENTER);
        return p;
    }

    private JPanel west() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,1));//4行1列
        p.setPreferredSize(new Dimension(100,100));
        vMonthSpend.setForeground(Color.BLUE);
        vTodaySpend.setForeground(Color.BLUE);
        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lTodaySpend);
        p.add(vTodaySpend);
        return p;
    }
    private JPanel center2(){
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(1,2));
        p.setPreferredSize(new Dimension(200,100));
        JProgressBar spenseProgressBar = new JProgressBar();

        //进度条最大100
        spenseProgressBar.setMaximum(120);

        spenseProgressBar.setValue(100*MonthSpend/(MonthSpend+MonthAvailable));
        //显示当前进度
        spenseProgressBar.setStringPainted(true);

        p.add(spenseProgressBar);
        return p;
    }
    private JPanel south() {
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(400,100));
        p.setLayout(new GridLayout(2, 4));

        p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);
        return p;
    }
}
