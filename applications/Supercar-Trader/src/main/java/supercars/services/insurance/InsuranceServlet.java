/**
 * 
 */
package supercars.services.insurance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * @author james
 *
 */
public class InsuranceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7889011897341720634L;

	/**
	 * 
	 */
	public InsuranceServlet() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			System.out.println("!!!!!!!!!!!!!!!! Insurance Service Recieved Request URI: " + request.getRequestURI());

			String url = "https://ratekick.com/";
			HttpClient client = HttpClientBuilder.create().build();
			
			
			HttpGet req = new HttpGet(url);
			HttpResponse res = client.execute(req);
			res.getStatusLine();

			url = "http://www.geico.com/";
			req = new HttpGet(url);
			res = client.execute(req);
			res.getStatusLine();
			
			url = "http://www.progressive.com/";
			req = new HttpGet(url);
			res = client.execute(req);
			res.getStatusLine();
			
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			response.getWriter().println("{ \"status\": \"ok\"}");	  				


		} catch (Throwable ex) {
			System.out.println("########################## Insurance Service Failure ##########################");
			System.out.println("########################## " + ex.getMessage() + " ##########################");
			ex.printStackTrace();
				
		}
		

    }

    
}
