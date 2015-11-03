import java.sql.*;

public class TicTacToeData {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/EMP";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "Snadarnir";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //Open a connection
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //Execute a query
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM scores";
      ResultSet rs = stmt.executeQuery(sql);

      //Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         String name  = rs.getString("name");
         int score = rs.getInt("score");
      }
      //Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end main
}//end FirstExample
