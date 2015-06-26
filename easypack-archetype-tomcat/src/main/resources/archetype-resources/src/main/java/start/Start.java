package ${package}.start;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

/**
 * EasyPack Tomcat Start
 * 
 */
public class Start {

	public static void main(String[] args) throws Exception {

		Tomcat tomcat = new Tomcat();

		tomcat.setPort(8080);

		Context ctx = tomcat.addWebapp("",
				System.getProperty("java.io.tmpdir"));

		Tomcat.addServlet(ctx, "helloworld", helloWorldServlet());

		ctx.addServletMapping("/helloworld", "helloworld");

		tomcat.start();

		tomcat.getServer().await();

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
						"<h1>Welcome to the EasyPack Tomcat Embedded example</h1>");
			}
		};
	}
}