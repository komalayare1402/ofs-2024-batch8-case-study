package com.ofss.main.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ofss.main.domain.Account;

public class AdminRepoImpl implements AdminRepo {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultset = null;


    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/inb";
    private static final String userName = "root";;
    private static final String password = "root";

    private final String GET_ONE_ADMIN = "SELECT * FROM Admin WHERE admin_login_id = ?";
    private final String GET_ONE_CUSTOMER = "SELECT * FROM Customer WHERE customer_login_id = ?";
    private final String UPDATE_STATUS_ATTEMPTS = "UPDATE Customer SET login_attempts=? , customer_status=? WHERE customer_login_id = ?";
    private static final String GET_ALL_ACCOUNT = "Select * from Account where customer_id=? AND account_status = ?";
    private final String UPDATE_ACCOUNT_STATUS = "UPDATE Account SET account_status=? WHERE account_id=?";

    @Override
    public String Adminlogin(String AdminloginID, String Adminpwd) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inb", "root", "root");
            if (connection != null) {
                System.out.println("Connected to db.");
            }
            preparedStatement = connection.prepareStatement(GET_ONE_ADMIN);
            preparedStatement.setString(1, AdminloginID);
            resultset = preparedStatement.executeQuery();
            String result = null;
            if (resultset.next()) {
                String pass = resultset.getString("admin_password");
                if (pass.equals(Adminpwd)) {
                    return "Login Successful !";
                } else {
                    return "Password Incorrect";
                }
            } else {
                result = "Admin does not exist.";
                return result;
            }
        } catch (ClassNotFoundException | SQLException e) {
            return e.toString();
        }
    }

    @Override
    public String unblock(String customer_login_id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inb", "root", "root");
            if (connection != null) {
                System.out.println("Connected to db.");
            }
            preparedStatement = connection.prepareStatement(GET_ONE_CUSTOMER);
            preparedStatement.setString(1, customer_login_id);
            resultset = preparedStatement.executeQuery();
            //String result = null;
            if (resultset.next()) {
                int attempts = resultset.getInt("login_attempts");
                String status = resultset.getString("customer_status");
                if (status.equals("inactive")) {
                    status = "active";
                    attempts = 0;
                    preparedStatement = connection.prepareStatement(UPDATE_STATUS_ATTEMPTS);
                    preparedStatement.setInt(1, attempts);
                    preparedStatement.setString(2, status);
                    preparedStatement.setString(3, customer_login_id);
                    preparedStatement.execute();

                }
            }
            return null;
        } catch (ClassNotFoundException | SQLException e) {
            return e.toString();
        }
    }

    @Override
    public List<Account> getAccountId(int customer_id) {

        List<Account> accountList = new ArrayList<>();
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            preparedStatement = connection.prepareStatement(GET_ALL_ACCOUNT);
            preparedStatement.setInt(1, customer_id);
            preparedStatement.setString(2, "inactive");
            resultset = preparedStatement.executeQuery();
            System.out.println("DATABASE CONNECTED");
            while(resultset.next()){
                //int customer_id = resultset.getInt("customer_id");
                int account_id=resultset.getInt("account_id");
                String account_type= resultset.getString("account_type");
                Double account_rate= resultset.getDouble("account_rate");
                Double account_balance= resultset.getDouble("account_balance");
                Double account_minimum_balance= resultset.getDouble("account_minimum_balance");
                String account_status = resultset.getString("account_status");
                int overdraft_amount = resultset.getInt("overdraft_amount");

                Account account = new Account(account_id, account_type, account_rate, account_balance, account_minimum_balance, account_status, overdraft_amount);
                accountList.add(account);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect database");
            e.printStackTrace();
        }
        
        return accountList;
    }


    @Override
    public String Approve(Account account) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inb", "root", "root");
            if(connection!=null){
                System.out.println("Connected to db.");
            }
            preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_STATUS);
            String status ="active";
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, account.getAccountId());
            preparedStatement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            return e.toString();
        }
        return null;
    }

}
