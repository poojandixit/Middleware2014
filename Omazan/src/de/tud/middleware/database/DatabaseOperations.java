package de.tud.middleware.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import de.tud.middleware.core.CustomerData;
import de.tud.middleware.core.ItemlistData;
import de.tud.middleware.core.ProductData;
import de.tud.middleware.util.Constants;

public class DatabaseOperations {

	private static Connection con;
	
	/**
	 * INSERT, UPDATE or DELETE table details
	 * @param query
	 * @return void
	 */
	public static void updateTable(String query) {
		Statement stmt = null;
		
		try {
			Class.forName(Constants.DRIVER);
			con = DriverManager.getConnection(Constants.DB_URL,Constants.USER,Constants.PASS);
			stmt = con.createStatement();
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        if (stmt != null) { 
	        	try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	        }
	    }
	}
	
	/**
	 * Fetching the rows from product table.
	 * @param query
	 * @return ArrayList<ProductData> pdList
	 */
	public static ArrayList<ProductData> fetchProductRows(String query) {
		ArrayList<ProductData> pdList = new ArrayList<ProductData>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(Constants.DRIVER);
			con = DriverManager.getConnection(Constants.DB_URL,Constants.USER,Constants.PASS);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			ProductData pdObj = null;
			while(rs.next()) {
				pdObj = new ProductData();
				pdObj.setId(rs.getInt("id"));
				pdObj.setProductName(rs.getString("name"));
				pdList.add(pdObj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        if (stmt != null) { 
	        	try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	        }
	    }
		return pdList;
	}
	
	/**
	 * Fetching the rows from customer table.
	 * @param query
	 * @return ArrayList<CustomerData> cdList
	 */
	public static ArrayList<CustomerData> fetchCustomerRows(String query) {
		ArrayList<CustomerData> cdList = new ArrayList<CustomerData>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(Constants.DRIVER);
			con = DriverManager.getConnection(Constants.DB_URL,Constants.USER,Constants.PASS);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			CustomerData cdObj = null;
			while(rs.next()) {
				cdObj = new CustomerData();
				cdObj.setId(rs.getInt("id"));
				cdObj.setCustomerName(rs.getString("name"));
				cdList.add(cdObj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        if (stmt != null) { 
	        	try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	        }
	    }
		return cdList;
	}
	
	/**
	 * Fetching the rows from itemlist table.
	 * @param query
	 * @return ArrayList<ItemlistData> ilList
	 */
	public static ArrayList<ItemlistData> fetchItemListRows(String query) {
		ArrayList<ItemlistData> ilList = new ArrayList<ItemlistData>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(Constants.DRIVER);
			con = DriverManager.getConnection(Constants.DB_URL,Constants.USER,Constants.PASS);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			ItemlistData ilObj = null;
			while(rs.next()) {
				ilObj = new ItemlistData();
				ilObj.setCustId(rs.getInt("custid"));
				ilObj.setProdId(rs.getInt("prodid"));
				ilList.add(ilObj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        if (stmt != null) { 
	        	try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	        }
	    }
		return ilList;
	}
	
	
}
