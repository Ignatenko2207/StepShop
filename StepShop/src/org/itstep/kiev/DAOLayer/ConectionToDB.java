package org.itstep.kiev.DAOLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectionToDB {
	
	static final String DBURL= "jdbc:postgresql://localhost:5432/ShopNet";
	static final String DBUser = "postgres";
	static final String DBUserPassword= "248842";
	
	private static Logger log = Logger.getLogger(ConectionToDB.class.getName());
	
	public static Connection getConnectionToDB() throws Exception{
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DBURL, DBUser, DBUserPassword);
            if(connection!=null){
                return connection;
            }else{
                throw new Exception("Connection is not established!");
            }
        }catch(Exception e){
            log.log(Level.SEVERE, e.getMessage());           
        }
		return connection;
    }
}
