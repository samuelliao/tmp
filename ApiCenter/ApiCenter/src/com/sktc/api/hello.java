package com.sktc.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class hello {
	public String version = "20190520-001";
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello, SKTC API Center";
	}

	/**
	 * This method is called if XML is request.
	 * 
	 * @return XML format
	 */
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello, SKTC API Center </hello>";
	}

	/**
	 * This method is called if HTML is request.
	 * 
	 * @return HTML format
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "SKTC API Managermemnt Center" + "</title>" + "<body><h1>" + "Hello, SKTC API Center</body></h1>"
				+ "</html> ";
	}
}
