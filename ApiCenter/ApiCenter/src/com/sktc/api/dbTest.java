package com.sktc.api;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sktc.db.dbUtil;
import com.sktc.obj.OutputJsonObj;
import com.sktc.obj.clientData;

@Path("/db2")
public class dbTest {
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public OutputJsonObj testDb() {
		try {
			dbUtil dbutil = new dbUtil();
			Connection  conn = dbutil.getConnection();
			return new OutputJsonObj(1, conn.toString(), null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OutputJsonObj();
		
	}
	
	@GET
	@Path("/client")
	@Produces(MediaType.APPLICATION_JSON)
	public OutputJsonObj getClientById(@QueryParam("id") String id) {
		try {
			dbUtil dbutil = new dbUtil();
			return new OutputJsonObj(1, "", dbutil.getClientDataById(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OutputJsonObj();
		
	}
	
	@GET
	@Path("/client")
	@Produces(MediaType.TEXT_HTML)
	public String getClientByIdHello(@QueryParam("id") String id) {
		List<clientData> clients =  new ArrayList<clientData>();
		try {
			dbUtil dbutil = new dbUtil();
			clients=  dbutil.getClientDataById(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result =  "<html> <head><meta charset=\"UTF-8\"></head>" 
		+ "<title>" + "SKTC API Managermemnt Center Demo" + "</title>" 
				+ "<body><h1>" + "Hello, SKTC API Center</h1>"
		+"<table>"
		+ "  <tr>"
		+ "    <th style=\"border: 1px solid #333;\">Client_id</th>"
		+ "    <th style=\"border: 1px solid #333;\">id_ind</th>"
		+ "<th style=\"border: 1px solid #333;\">names</th>"
		+ "<th style=\"border: 1px solid #333;\">sex</th>"
		+ "<th style=\"border: 1px solid #333;\">birth_date</th>"
		+ "  </tr>";
		for(clientData client :clients) {
			result += "<tr>"+
					"<td style=\"border: 1px solid #333;\">"+client.getClientId()+"</td>"+
					"<td style=\"border: 1px solid #333;\">"+client.getIdInd()+"</td>"+
					"<td style=\"border: 1px solid #333;\">"+client.getNames()+"</td>"+
					"<td style=\"border: 1px solid #333;\">"+client.getSex()+"</td>"+
					"<td style=\"border: 1px solid #333;\">"+client.getBirthDate()+"</td>"+
					"</tr>";
			}
			result+= "</table>"
		+"<br/></body>"
				+ "</html> ";
				return result;
	}
}
