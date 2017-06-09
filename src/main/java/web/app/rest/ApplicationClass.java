package web.app.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("/api")
public class ApplicationClass extends ResourceConfig {
	
	public ApplicationClass(){	
	 	super();	
	 	packages("web.app");
		register(RolesAllowedDynamicFeature.class);
	}	
	
}

