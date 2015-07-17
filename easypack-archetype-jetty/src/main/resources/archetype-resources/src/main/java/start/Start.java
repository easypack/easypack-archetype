package ${package}.start;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * EasyPack Jetty Start
 * 
 */
public class Start {

	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);
		
		server.setHandler(helloWorldHandler());
		
		registerShutdown(server);

		server.start();
		
		server.join();
	}
	
	/**
	 * Creates a Handler hello world example.
	 * 
	 */
	private static Handler helloWorldHandler() {

		return new AbstractHandler() {

			@Override
			public void handle(String target, Request baseRequest,
					HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException {

				response.setContentType("text/html;charset=utf-8");
				response.setStatus(HttpServletResponse.SC_OK);
				baseRequest.setHandled(true);
				response.getWriter().println("<h1>Welcome to the EasyPack Jetty Embedded example</h1>");

			}
		};
	}

    /**
	 * Registers a shut down hook for a graceful server stop.
	 * 
	 * @param server the Jetty server
	 */
	private static void registerShutdown(final Server server) {
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			
			@Override
			public void run() {
				
				System.out.println("Shutting down ...");
				
				try {
		
					server.stop();
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
	}
}

	