package lab8;

import java.sql.*;

public class ResultSetMetaData {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
                Statement stmt = conn.createStatement();
                ){
            ResultSet rset = stmt.executeQuery("select * from books");
            ResultSetMetaData resetMD = rset.getMetaData();
            int numColumns = resetMD.getComlumnCount();
            for (int i=1;i<=numColumns;++i){
                System.out.println("%-30s",resetMD.getComlumnName(i));
            }
            System.out.println();

            for(int i=1;i<=numColumns;++i){
                System.out.println("%-30s","(" + resetMD.getColumsClassName(i)+")";
            }
            System.out.println();

            while(rset.next()){
                for (int i=1;i<=numColumns;++i){
                    System.out.println("%30s",rset.getString(i));
                }
                System.out.println();
            }
        }
    }
}
