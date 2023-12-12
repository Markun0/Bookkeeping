package DatabaseInput;

import Panel.Consume;
import Table.ExpenseTable;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class dataGet {
    int[] a=new int[6];
    int[] day=new int[32];
    ArrayList<String[]> heros = new ArrayList<>();
    int k=0;
    private void init(){
        for(int i=0;i<6;i++)
            a[i]=0;
        for(int i=0;i<32;i++)
            day[i]=0;
    }
    public void Spense(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/booksbase?characterEncoding=UTF-8","root", "Mkl20040310");
             Statement s = c.createStatement();) {
            init();
            String sql = "select * from booksmark";
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
            String[] month=new String[31];
            Calendar d= Calendar.getInstance();
            String str=sdf.format(d.getTime());
            while (rs.next()) {
                if(str.substring(0,7).equals(rs.getString(5).substring(0,7))) {
                    //System.out.println(rs.getString(5).substring(0,6));
                    a[0] += rs.getInt(2);
                    if (rs.getString(5).equals(str))
                        a[1] += rs.getInt(2);
                    int t=Integer.valueOf(rs.getString(5).substring(8,10));
                    day[t]+=rs.getInt(2);
                    String[] hero=new String[5];
                    hero[0]=String.valueOf(rs.getInt(1));
                    hero[1]=String.valueOf(rs.getInt(2));
                    for(int i=1;i<=3;i++)
                        hero[i+1]=rs.getString(i+2);
                    heros.add(hero);
                }
            }
            a[2]=a[0]/Integer.valueOf(str.substring(8,10));
            a[3]= Consume.MonthBudget -a[0];
            sdf=new SimpleDateFormat("yyyy-MM");
            do{
                a[5]++;
                d.add(Calendar.DATE,1);
            }while(sdf.format(d.getTime()).equals(str.substring(0,7)));
            a[4]=a[3]/a[5];
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public int[] getSpense(int dir){
        Spense();
        if(dir==0)return a;
        return day;
    }
    public String[][] getHeros(){
        Spense();
        ExpenseTable.k=k;
        return heros.toArray(new String[0][]);
    }
}
