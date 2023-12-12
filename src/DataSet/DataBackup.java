package DataSet;

import java.sql.*;

public class DataBackup {
    public static void main(String[] args){
        dataBackup();
    }
    public static void dataBackup(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/booksbase?characterEncoding=UTF-8","root", "Mkl20040310");
             Statement s = c.createStatement();) {
            String backupSQL = "mysqldump -u root -p booksbase > d:\\test.sql";
            s.execute(backupSQL);
            System.out.println("Backup completed successfully.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
