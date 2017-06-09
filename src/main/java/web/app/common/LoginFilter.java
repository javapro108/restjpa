package web.app.common;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class LoginFilter implements ContainerRequestFilter{
<<<<<<< HEAD
	
	@Context private ServletContext context;
=======
    
	@Context private ServletContext servletContext;
>>>>>>> branch 'master' of https://github.com/javapro108/restjpa.git
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
        
		String path = requestContext.getUriInfo().getPath(true);		
		String token = "";
		User user = null;
		
		if (path.equals("login")){
			return;
		}
		
	    token = requestContext.getHeaderString("Authorization");
		System.out.println("Inside JAX-RS Filter");
		System.out.println(path);
		System.out.println(token);
	    try {
	    	user = SystemServices.getInstance().getUser(token);
<<<<<<< HEAD
=======
	    	requestContext.setSecurityContext(user);
>>>>>>> branch 'master' of https://github.com/javapro108/restjpa.git
	    } catch(IllegalArgumentException e){
	    	
	    } catch(IllegalStateException e){
	    	
	    }
	    
		if (user == null){
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
	}

}
