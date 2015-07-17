package ${package}.start;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;


/**
 * EasyPack Undertow Start
 * 
 */
public class Start {

	public static void main(String[] args) throws Exception {

		Undertow server = Undertow.builder().addHttpListener(8080, "localhost")
				.setHandler(new HttpHandler() {
					@Override
					public void handleRequest(final HttpServerExchange exchange)
							throws Exception {
						exchange.getResponseHeaders().put(Headers.CONTENT_TYPE,
								"text/html");
						exchange.getResponseSender().send("<h1>Welcome to the EasyPack Undertow example</h1>");
					}
				}).build();
		
		registerShutdown(server);
		
		server.start();

	}

	/**
	 * Registers a shut down hook for a graceful server stop.
	 * 
	 * @param server
	 *            the Undertow instance.
	 */
	private static void registerShutdown(final Undertow server) {

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