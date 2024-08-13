package com.ofss.main.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ofss.main.domain.Customer;

public class CustomerRepoImpl implements CustomerRepo {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultset = null;
    private final String GET_ONE_CUSTOMER = "SELECT * FROM Customer WHERE customer_login_id = ?";
    private final String INSERT_ONE_CUSTOMER = "INSERT INTO Customer (customer_name , customer_email , customer_phone , customer_address , customer_state , customer_country , customer_login_id, customer_password) VALUES (? , ? , ? , ? , ? , ? , ? , ?)";
    private final String UPDATE_LOGIN_ATTEMPTS = "UPDATE Customer SET login_attempts=? , customer_status=? WHERE customer_login_id = ?";

    @Override
    public boolean register(Customer c) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inb", "root", "root");
            if (connection != null) {
                System.out.println("Connected to db.");
            }
            preparedStatement = connection.prepareStatement(INSERT_ONE_CUSTOMER);
            preparedStatement.setString(1, c.getCustomerName());
            preparedStatement.setString(2, c.getCustomer_email());
            preparedStatement.setString(3, c.getCustomerPhone());
            preparedStatement.setString(4, c.getCustomerAddress());
            preparedStatement.setString(5, c.getCustomerState());
            preparedStatement.setString(6, c.getCustomerCountry());
            preparedStatement.setString(7, c.getCustomerLoginId());
            preparedStatement.setString(8, c.getCustomerPassword());

            boolean res = preparedStatement.execute();
            return res;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
            return false;
        }

    }

    @Override
    public String login(String loginID, String pwd) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inb", "root", "root");
            if (connection != null) {
                System.out.println("Connected to db.");
            }
            preparedStatement = connection.prepareStatement(GET_ONE_CUSTOMER);
            preparedStatement.setString(1, loginID);
            resultset = preparedStatement.executeQuery();
            String result = null;
            if (resultset.next()) {
                String pass = resultset.getString("customer_password");
                int loginAttempts = resultset.getInt("login_attempts");
                String customerStatus = resultset.getString("customer_status");
                if (pass.equals(pwd)) {
                    if (customerStatus.equals("inactive")) {
                        return "Account Locked. Please ask admin to unlock";
                    }
                    return "Login Successful !";
                } else {
                    loginAttempts += 1;
                    if (loginAttempts == 3) {
                        customerStatus = "inactive";
                    }
                    preparedStatement = connection.prepareStatement(UPDATE_LOGIN_ATTEMPTS);
                    preparedStatement.setInt(1, loginAttempts);
                    preparedStatement.setString(2, customerStatus);
                    preparedStatement.setString(3, loginID);
                    preparedStatement.execute();
                    return "Password Incorrect";
                }
            } else {
                result = "Customer does not exist.";
                return result;
            }
            // if(pass.equals(pwd)){
            // return "Login Successful !";
            // }else{
            // return "Password Incorrect";
            // }
            // }else{
            // result = "Customer does not exist.";
            // return result;
            // }
        } catch (ClassNotFoundException | SQLException e) {
            return e.toString();
        }
    }
}
