package DatabaseInput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dataAdd {
    public void Add(int spense,String type,String mark,String date){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "insert into booksmark values(null,?,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/booksbase?characterEncoding=UTF-8","root", "Mkl20040310");
             // 根据sql语句创建PreparedStatement
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            // 设置参数
            ps.setInt(1,spense);
            ps.setString(2, type);
            ps.setString(3, mark);
            ps.setString(4, date);
            // 执行
            ps.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
