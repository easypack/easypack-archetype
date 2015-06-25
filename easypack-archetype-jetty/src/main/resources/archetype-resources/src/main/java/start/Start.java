package ${package}.start;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * EasyPack Jetty Start
 * 
 */
public class Start {

	public static void main(String[] args) throws Exception {

        Server server = new Server();
		
		ServerConnector c = new ServerConnector(server);
		c.setHost("localhost");
		c.setPort(8080);

		ServletContextHandler handler = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		handler.setContextPath("/");
		
		server.setHandler(handler);

		ServletHolder servletHolder = new ServletHolder(helloWorldServlet());
		handler.addServlet(servletHolder, "/helloworld");
		
		server.addConnector(c);
		
		server.start();
		
		server.join();

	}

	/**
	 * An HttpServlet example.
	 * 
	 * @return the servlet.
	 */
	private static HttpServlet helloWorldServlet() {

		return new HttpServlet() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void doGet(HttpServletRequest req,
					HttpServletResponse resp) throws ServletException,
					IOException {

				resp.getWriter().println(
						"<h1>Welcome to the EasyPack Jetty Embedded example</h1>");
			}
		};
	}
}