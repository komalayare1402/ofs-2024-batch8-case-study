package com.ofss.main.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepoImpl implements AccountRepo{
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/inb";
    private static final String userName = "root";;
    private static final String password = "root";

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    //private ResultSet resultset = null;


    private static final String INSERT_NEW_ACCOUNT = "INSERT INTO Account(customer_id, account_type,account_rate,account_balance,account_minimum_balance,overdraft_amount,account_status) VALUES (?,?,?,?,?,?,?)";



    @Override
    public String AccountType(int customerId, String accountType, int overdraft_amount) {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement(INSERT_NEW_ACCOUNT);
            preparedStatement.setInt(1,customerId);
            preparedStatement.setString(2,accountType);
            preparedStatement.setDouble(3,accountType.equalsIgnoreCase("savings") ? 4.5 : 0);
            preparedStatement.setDouble(4,accountType.equalsIgnoreCase("savings") ? 1000 : 0);
            preparedStatement.setDouble(5,accountType.equalsIgnoreCase("savings") ? 1000 : 0);
            preparedStatement.setInt(6,accountType.equalsIgnoreCase("savings") ? 0 : overdraft_amount);
            preparedStatement.setString(7,"inactive");


            int rowCount= preparedStatement.executeUpdate();

            if (rowCount > 0) {
                return null;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect database");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection");
                e.printStackTrace();
            }
        }
        return null;
    }
}
