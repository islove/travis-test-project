
import java.io.File;
import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class Runner implements Runnable {
	private static Server server = null;
	private static WebAppContext webapp = null;
	private static NetworkTrafficServerConnector connector = null;

	public Runner() {
		Runtime.getRuntime().addShutdownHook(new Thread(this));
		System.out.println(">>> shutdown hook registered");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new Runner();
		final int port = Integer.parseInt(System.getProperty("port", "9999"));
		final int thread = Integer.parseInt(System.getProperty("thread", "50"));
		final int idleTimeout = Integer.parseInt(System.getProperty("thread", "60000"));
		final QueuedThreadPool threadPool = new QueuedThreadPool();
		threadPool.setMaxThreads(thread);
		server = new Server(threadPool);

		String jettyVersion = Server.getVersion();
		ProtectionDomain protectionDomain = NetworkTrafficServerConnector.class.getProtectionDomain();
		URL location = protectionDomain.getCodeSource().getLocation();
		String warFile = location.toExternalForm();
		String currentDir = new File(location.getPath()).getParent();
		File workDir = new File(currentDir, "work");

		System.out.println("##########port=" + port);
		System.out.println("##########thread=" + thread);
		System.out.println("##########idleTimeout=" + idleTimeout);
		System.out.println("##########jettyVersion=" + jettyVersion);
		System.out.println("##########port=" + port);
		System.out.println("##########currentDir=" + currentDir);
		System.out.println("##########workDir=" + workDir);
		System.out.println("##########warFile=" + warFile);

		webapp = new WebAppContext();
		webapp.setContextPath("/");
		// webapp.setResourceBase(".");
		webapp.setTempDirectory(workDir);
		// webapp.setClassLoader(Thread.currentThread().getContextClassLoader());
		webapp.setWar(warFile);

		connector = new NetworkTrafficServerConnector(server);
		connector.setPort(port);
		connector.setIdleTimeout(idleTimeout);
		server.addConnector(connector);
		server.setHandler(webapp);
		server.start();
		server.join();

	}

	@Override
	public void run() {

		System.out.println("/n>>> About to execute: " + Runner.class.getName() + ".run() to clean up before JV");
		if (webapp.isStarted()) {
			try {
				webapp.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (connector.isStarted()) {
			try {
				connector.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (server.isStarted()) {
			try {
				server.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(">>> Finished execution: " + Runner.class.getName() + ".run()");
	}
}
