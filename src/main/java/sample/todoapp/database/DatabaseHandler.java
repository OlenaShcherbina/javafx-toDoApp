package sample.todoapp.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import sample.todoapp.model.User;

public class DatabaseHandler extends Configs{
  Connection dbConnection;


  public Connection getDbConnection() throws ClassNotFoundException, SQLException {
    String connectionString = "jdbc:postgresql://" + dbHost + ":"
        + dbPort + "/"
        + dbName;
    Class.forName("org.postgresql.Driver");
    dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

    return dbConnection;
  }

  //Write
  public void signUpUser(User user){
    String insert = "INSERT INTO " +Const.USERS_TABLE +
        "(" +Const.USERS_FIRSTNAME +
        ","+Const.USERS_LASTNAME+
        ","+Const.USERS_USERNAME+
        ","+Const.USERS_PASSWORD+
        ","+Const.USERS_LOCATION+
        ","+Const.USERS_GENDER+")"+
        "VALUES(?,?,?,?,?,?)";

    try {
      PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);

      preparedStatement.setString(1,user.getFirstName());
      preparedStatement.setString(2,user.getLastName());
      preparedStatement.setString(3,user.getUserName());
      preparedStatement.setString(4,user.getPassword());
      preparedStatement.setString(5,user.getLocation());
      preparedStatement.setString(6,user.getGender());

      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }catch(ClassNotFoundException ex){
      ex.printStackTrace();
    }
  }

  //Read
public ResultSet getUser(User user){
  ResultSet result = null;
   if(!user.getUserName().equals("") && !user.getPassword().equals("")){
     String query = "SELECT * FROM " +Const.USERS_TABLE +
         " WHERE " + Const.USERS_USERNAME + " = ?" + "AND " +
         Const.USERS_PASSWORD + " = ?";
     //select all from users table, where username = "miri", password = "WMiri"

     try {
       PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
       preparedStatement.setString(1, user.getUserName());
       preparedStatement.setString(2, user.getPassword());

      result = preparedStatement.executeQuery();

     } catch (SQLException e) {
       e.printStackTrace();
     } catch (ClassNotFoundException e) {
      e.printStackTrace();
     }
   }else{
      System.out.println("Please enter your credentials");
    }

    return result;
}

}
