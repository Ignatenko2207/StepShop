package org.itstep.kiev.DAOLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.itstep.kiev.domain.Customer;
import org.itstep.kiev.domain.Good;

public class CustomerDAO {
private static Logger logger = Logger.getLogger(GoodDAO.class.getName());
	
	public static void createCustomer(String login, String password, String name, String contact, long dateOfBirth){
		Connection con = null;
		PreparedStatement pStatement = null;
		Customer customer = null;
		customer = getCustomer(login, password);
		if(customer.getLogin()!=null){
			logger.log(Level.INFO, "This customer exists in DB!");
			return;
		}
		try {
			con = ConectionToDB.getConnectionToDB();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Connection isn't corect.");
		}
		
		String sql = "INSERT INTO customers (login, password, name, contact, birthdate) VALUES (?,?,?,?,?)";
		
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, login);
			pStatement.setString(2, password);
			pStatement.setString(3, name);
			pStatement.setString(4, contact);
			pStatement.setLong(5, dateOfBirth);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(pStatement != null){
					pStatement.close();
				}
				if(con != null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Customer getCustomer(String login, String password){

		Connection con = null;
		PreparedStatement pStatement = null;
		Customer customer = new Customer();
		
		ResultSet rSet = null;
		try {
			con = ConectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM customers WHERE login='"+login+"' AND password='"+password+"' ";
		
		try {
			pStatement = con.prepareStatement(sql);
			rSet = pStatement.executeQuery();		
			while(rSet.next()){
				customer.setLogin(rSet.getString("login"));
				customer.setPassword(rSet.getString(2));
				customer.setName(rSet.getString(3));
				customer.setContact(rSet.getString(4));
				customer.setDateOfBirth(rSet.getLong(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(rSet != null){
					rSet.close();
				}
				if(pStatement != null){
					pStatement.close();
				}
				if(con != null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return customer;	
		
	}
	
	public static void editCustomer(String login, String password, String newLogin, String newPassword, String newName, String newContact, long newDate){

		Customer customer = CustomerDAO.getCustomer(login, password);
		if(customer.getLogin()==null || customer.getLogin().isEmpty()){
			logger.log(Level.INFO, "Customer "+ login + " doesn't exist in DB to edit it!");
			return;
		}
		Connection con = null;
		Statement statement = null;
		
		try {
			con = ConectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "UPDATE customers SET login='"+newLogin+"', password='"+newPassword+"', "
				+ "contact='"+newContact+"', name='"+newName+"', birthdate='"+newDate+"' WHERE login='"+customer.getLogin()+"'";
		
		try {
			statement = con.prepareStatement(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(statement != null){
					statement.close();
				}
				if(con != null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void deleteCustomer(String login, String password){

		Customer customer = CustomerDAO.getCustomer(login, password);
		if(customer.getLogin()==null || customer.getLogin().isEmpty()){
			logger.log(Level.INFO, "Customer "+ login + " doesn't exist in DB to edit it!");
			return;
		}
		Connection con = null;
		Statement statement = null;
		
		try {
			con = ConectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "DELETE FROM customers WHERE login='"+login+"'";
		
		try {
			statement = con.prepareStatement(sql);
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(statement != null){
					statement.close();
				}
				if(con != null){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
