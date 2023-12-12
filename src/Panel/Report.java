package Panel;

import DatabaseInput.dataGet;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
public class Report {
    public JPanel report(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataGet dg=new dataGet();
        int[] day=dg.getSpense(1);
        for(int i=1;i<=31;i++){
            dataset.setValue(day[i],"Expenses",String.valueOf(i));
            System.out.println(day[i]);
        }

        // 创建柱状图
        JFreeChart chart = ChartFactory.createBarChart(
                "Dayly Expenses", // 图表标题
                "Expense", // X轴标题
                "Day", // Y轴标题
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向
                true, // 是否显示图例
                true, // 是否生成工具提示
                false // 是否生成URL链接
        );

        JPanel f=new JPanel();
        f.setSize(1000, 300);
        f.setLocation(800, 200);
        f.add(new ChartPanel(chart));
        return f;
    }
}
