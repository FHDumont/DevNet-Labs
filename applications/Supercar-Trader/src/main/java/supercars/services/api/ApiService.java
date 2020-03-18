/**
 * 
 */
package supercars.services.api;

import java.util.Properties;

import supercars.services.JettyServer;
import supercars.services.inventory.InventoryService;
import supercars.utils.PropertiesHelper;

/**
 * @author james
 *
 */
public class ApiService {

	private static JettyServer server;
	
	/**
	 * 
	 */
	public ApiService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// here we need to instantiate a Jetty Server and start it
		
		try {
			
			Properties serviceProps = PropertiesHelper.getApiServiceProps();
			server = new JettyServer();
			server.start(Integer.parseInt(serviceProps.getProperty("jetty.max.threads")), 
					Integer.parseInt(serviceProps.getProperty("jetty.min.threads")), 
					Integer.parseInt(serviceProps.getProperty("jetty.idle.timeout")), 
					Integer.parseInt(serviceProps.getProperty("listener.port")), 
					serviceProps.getProperty("servlet.class"), 
					serviceProps.getProperty("root.context"));
			
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}

	public static void stop() throws Throwable {
		if (ApiService.server != null) {
			ApiService.server.stop();
		}
	}

	
}
