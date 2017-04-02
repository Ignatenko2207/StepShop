package org.itstep.kiev.DAOLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.itstep.kiev.domain.Cart;
import org.itstep.kiev.domain.Customer;

public class OrderDAO {

	private static Logger logger = Logger.getLogger(OrderDAO.class.getName());
	
	public ArrayList<Cart> getOrdersForCustomer(Customer customer){
		ArrayList<Cart> orders = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		
		try {
			con = ConectionToDB.getConnectionToDB();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Connection isn't corect.");
		}
		
		String sql = "SELECT * FROM orders WHERE customer='"+customer.getLogin()+"'";
		try {
			pStatement = con.prepareStatement(sql);
			rSet = pStatement.executeQuery();	
			Cart orderItem = new Cart();
			while(rSet.next()){
				orderItem.setCustomer(rSet.getString("customer"));
				orderItem.setActionTime(rSet.getLong(3));
				orderItem.setCellID(1);
				orders.add(orderItem);
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
		return orders;
	}
	
}
