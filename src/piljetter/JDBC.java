package piljetter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
    void DatabaseConn() {
        try{
            System.out.println("connecting to database");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "MagicalDay9296");
            //Retrieving data
            System.out.println("creating statement");
            Statement statement = connection.createStatement();
            System.out.println("execute statement");
            ResultSet resultSet = statement.executeQuery("select * from ");
            System.out.println("print result");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + resultSet.getString("membercost"));
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
