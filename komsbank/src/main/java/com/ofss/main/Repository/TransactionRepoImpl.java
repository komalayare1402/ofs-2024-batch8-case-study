package com.ofss.main.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRepoImpl implements TransactionRepo {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultset = null;


    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/inb";
    private static final String userName = "root";
    private static final String password = "root";

    private static final String INSERT_INTO_NEW_TRANSACTION = "INSERT INTO Transaction(payee_account_id,payer_account_id, transaction_amount, transaction_status,transaction_completed_at,transfer_type, transaction_type) VALUES(?,?,?,?,?,?,?)";
    private static final String SELECT_ONE_PAYEE = "SELECT * FROM Account WHERE account_id=?";
    private static final String UPDATE_PAYEE_ACCOUNT = "UPDATE Account SET account_balance=? , overdraft_amount=? WHERE account_id = ?";

    @Override
    public String MoneyTransaction(int PayeeAccountId, int PayerAccountId, int TransactionAmount, String TrasactionType) {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, userName, password);
            //GET PAYEE CUSTOMER
            preparedStatement = connection.prepareStatement(SELECT_ONE_PAYEE);
            preparedStatement.setInt(1, PayeeAccountId);
            resultset = preparedStatement.executeQuery();
            int payee_new_balance =0;
            if(resultset.next()){
                int balance = resultset.getInt("account_balance");
                int min_balance = resultset.getInt("account_minimum_balance");
                String account_type = resultset.getString("account_type");
                int overdraft_amount = resultset.getInt("overdraft_amount");
                int new_amount = TransactionAmount;
                if(account_type.equalsIgnoreCase("savings")){
                    if(TransactionAmount>0 && balance-TransactionAmount >= min_balance){
                        payee_new_balance = balance - TransactionAmount;
                    }else{
                        System.out.println("Transaction not possible beacause you dont have enough balance");
                        return null;
                    }
                }else{
                    if(TransactionAmount>0 && TransactionAmount<balance){
                        payee_new_balance = balance-TransactionAmount;
                    }
                    else if(TransactionAmount>0 && TransactionAmount>balance && TransactionAmount<balance+overdraft_amount){
                        new_amount=TransactionAmount-balance;
                        payee_new_balance = 0;
                        overdraft_amount = overdraft_amount-new_amount;
                    }else{
                        System.out.println("Transaction not possible beacause you dont have enough balance");
                        return null;
                    }
                }
                //UPDATE PAYEE ACCOUNT
                preparedStatement = connection.prepareStatement(UPDATE_PAYEE_ACCOUNT);
                preparedStatement.setInt(1, payee_new_balance);
                preparedStatement.setInt(2, overdraft_amount);
                preparedStatement.setInt(3, PayeeAccountId);
                preparedStatement.execute();
            }
                
            //GET PAYER CUSTOMER
            preparedStatement = connection.prepareStatement(SELECT_ONE_PAYEE);
            preparedStatement.setInt(1, PayerAccountId);
            resultset = preparedStatement.executeQuery();
            int payer_new_balance = 0 ;
            
            if(resultset.next()){
                int balance = resultset.getInt("account_balance");
                String account_type = resultset.getString("account_type");
                int payer_overdraft_amount = resultset.getInt("overdraft_amount");
                int initial_overdraft_balance = payer_overdraft_amount;
                System.out.println("overdraft: "+initial_overdraft_balance);
                int new_amount = TransactionAmount;
                System.out.println("new_amount"+TransactionAmount);
                if(account_type.equalsIgnoreCase("savings")){
                        payer_new_balance = balance + TransactionAmount;
                        System.out.println("balance: "+balance+" amount: "+TransactionAmount+"payer balance is: "+payer_new_balance);
                }else{
                    if(TransactionAmount>0 && initial_overdraft_balance>payer_overdraft_amount){
                        if(TransactionAmount<(initial_overdraft_balance-payer_overdraft_amount)){
                            payer_overdraft_amount += TransactionAmount;
                        }else{
                            new_amount = TransactionAmount - initial_overdraft_balance - payer_overdraft_amount;
                            payer_overdraft_amount = initial_overdraft_balance;
                            payer_new_balance = balance + new_amount;
                        }
                    }else{
                        payer_new_balance = balance + TransactionAmount;
                    }
                }
            

            //UPDATE PAYER ACCOUNT
            preparedStatement = connection.prepareStatement(UPDATE_PAYEE_ACCOUNT);
            preparedStatement.setInt(1, payer_new_balance);
            preparedStatement.setInt(2, payer_overdraft_amount);
            preparedStatement.setInt(3, PayerAccountId);
            preparedStatement.execute();
        }
                            



            //INSERT TRANSACTION
            preparedStatement = connection.prepareStatement(INSERT_INTO_NEW_TRANSACTION);
            preparedStatement.setInt(1,PayeeAccountId);
            preparedStatement.setInt(2,PayerAccountId);
            preparedStatement.setInt(3,TransactionAmount);
            preparedStatement.setString(4,"Completed");
            preparedStatement.setString(5,"2024-07-18 10:51:19");
            preparedStatement.setString(6,TrasactionType);
            preparedStatement.setString(7,"debit");

            int rowCount= preparedStatement.executeUpdate();

            if (rowCount > 0) {
                return "Transaction Successfull";
                
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
        return "Transaction Successfull";
    }
}
