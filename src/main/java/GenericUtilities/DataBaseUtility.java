package GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	public Connection connection;
	/**
	 * This method is used to load, register and establish database connection
	 * @throws SQLException
	 */
	public void EstablishDataBaseConnection() throws SQLException {
		 Driver driver = new Driver();
     	DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(IConstants.dbUrl, IConstants.dbUserName,IConstants.dbPassword);
	}
	
	
	public void closeDataBaseConnection() throws SQLException {
		connection.close();
	}
	/**
	 * This method is used to validate the data into dataBase
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String readDataFromDBAndValidate(String query,int columnIndex,String expData) throws SQLException {
		boolean flag=false;
		ResultSet result=connection.createStatement().executeQuery(query);
		while(result.next()) {
			if(result.getString(columnIndex).equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("verified");
			return expData;
		}else {
			System.out.println("Data not verified");
			return "";
		}
	}
	

}
