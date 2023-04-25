package br.edu.ifpr.persistproject.repository;

import br.edu.ifpr.persistproject.connection.ConnectionFactory;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SellerRepository {

    private Connection conn;

    public SellerRepository(){

        ConnectionFactory connectionFactory = new ConnectionFactory();
        conn = connectionFactory.getConnection();

    }

    public void getSellers() throws SQLException {

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = conn.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM seller");

            while(resultSet.next()){

                System.out.println(
                        resultSet.getInt("Id") + " " +
                        resultSet.getString("Name"));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            try{
                resultSet.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            statement.close();
        }

    }

}
