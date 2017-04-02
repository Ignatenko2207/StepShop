package org.itstep.kiev.DAOLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.itstep.kiev.domain.Good;

public class GoodDAO {

	private static Logger logger = Logger.getLogger(GoodDAO.class.getName());
	
	public static void createGood(String name, int price){
		Connection con = null;
		PreparedStatement pStatement = null;
		Good goodInDB = null;
		goodInDB = getGood(name, price);
		
		if(goodInDB.getName()!=null){
			logger.log(Level.INFO, "This good exists in DB!");
			return;
		}
		try {
			con = ConectionToDB.getConnectionToDB();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Connection isn't corect.");
		}
		
		String sql = "INSERT INTO goods (name, price) VALUES (?,?)";
		
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, name);
			pStatement.setInt(2, price);
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
	
	public static Good getGood(String name, int price){

		Good good = new Good();
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		try {
			con = ConectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM goods WHERE name='"+name+"'";
		
		try {
			pStatement = con.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			while(rSet.next()){
				if(rSet.getInt(3)==price){
					good.setName(rSet.getString(2));	
					good.setGoodID(rSet.getInt("id"));	
					good.setPrice(rSet.getInt(3));
				}
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
		return good;	
		
	}
	
	public static void editGood(String name, int price, String newName, int newPrice){

		Good good = getGood(name, price);
		if(good.getName()==null || good.getName().isEmpty()){
			logger.log(Level.INFO, "Good "+ name + " doesn't exist in DB to edit it!");
			return;
		}
		Connection con = null;
		Statement statement = null;
		
		try {
			con = ConectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "UPDATE goods SET name='"+newName+"', price='"+newPrice+"' WHERE id='"+good.getGoodID()+"'";
		
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
	
	public static void deleteGood(String name, int price){

		Good good = getGood(name, price);
		if(good.getName()==null || good.getName().isEmpty()){
			logger.log(Level.INFO, "Good "+ name + " doesn't exist in DB to edit it!");
			return;
		}
		Connection con = null;
		Statement statement = null;
		
		try {
			con = ConectionToDB.getConnectionToDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql = "DELETE FROM goods WHERE id='"+good.getGoodID()+"'";
		
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
