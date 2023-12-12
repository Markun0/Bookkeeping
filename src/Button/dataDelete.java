package Button;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class dataDelete {
    public void delete(int[] ids){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/booksbase?characterEncoding=UTF-8","root", "Mkl20040310");
             Statement s = c.createStatement();) {
            for(int i=0;i<ids.length;i++) {
                String sql = "delete from booksmark where id = " + ids[i];
                s.execute(sql);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
