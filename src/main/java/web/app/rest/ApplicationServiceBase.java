package web.app.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

public class ApplicationServiceBase {

	@Context protected ServletContext servletContext;
	
}
