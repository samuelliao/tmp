package com.sktc.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sktc.obj.clientData;

public class dbUtil {
	//String _url = "jdbc:db2://192.168.1.68:50001/BLUDB:user=bluadmin;password=1qaz@WSX3edc:sslConnection=true";
	//String _url = "jdbc:db2://192.168.1.68:50001/BLUDB:sslConnection=true;sslTrustStoreLocation=C:\\Users\\samue\\Downloads\\DigiCertGlobalRootCA.crt";
	String _url = "jdbc:db2://172.27.18.122:50000/BLUDB";
	//String _url = "jdbc:db2://192.168.1.68:50000/BLUDB";
	String _user = "bluadmin";
	String _passwd = "1qaz@WSX3edc";
	//String _passwd = "Abc12345";
	
	public dbUtil() throws IOException, ClassNotFoundException{
		//Class.forName("com.ibm.db2.jdbc.app.DB2Driver");
		Class.forName("com.ibm.db2.jcc.DB2Driver");
	}

	public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(_url, _user, _passwd);
    }

    public void closeConnection(Connection conn) throws SQLException {
        conn.close();
    }
    
    public List<clientData> getClientDataById(String id) {
    	List<clientData> list = new ArrayList<clientData>();
    	clientData result = new clientData();
    	ResultSet rs=null;
    	int index = 0;
    	String sqlcmd = "";
    	
    	Connection conn;
		try {
			conn = getConnection();
			
			Statement stmt = conn.createStatement();
			sqlcmd = "SELECT client_id, id_ind, names, sex, birth_date FROM clnt" + (id.length()>0?" where client_id='"+id+"'":"");
			rs = stmt.executeQuery(sqlcmd);                    
            System.out.println("**** Created JDBC ResultSet object");

            while (rs.next()) {
            	index = 1;
            	list.add(new clientData(rs.getString(index++), rs.getString(index++), rs.getString(index++), rs.getString(index++), rs.getString(index++)));
            }
			
			closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	    	
    	return list;
    }
    
}
