package hu.neuron.junior.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import hu.neuron.junior.client.api.service.data.DataGenerateService;
import hu.neuron.junior.client.api.service.user.UserService;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
@WebListener
public class InitListener implements ServletContextListener {
	private static Logger logger = Logger.getLogger(InitListener.class);

	@Autowired
	DataGenerateService dataGenerateService;

	@Autowired
	UserService userService;

	/**
	 * Default constructor.
	 */
	public InitListener() {
		// Default constructor.
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Context Destroyed
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		if (userService.findAll().isEmpty()) {
			dataGenerateService.generate();
		}
	}

}
