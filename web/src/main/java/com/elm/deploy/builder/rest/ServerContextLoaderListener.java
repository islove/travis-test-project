package com.elm.deploy.builder.rest;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wordnik.swagger.jaxrs.JaxrsApiReader;

/**
 * 
 * @author yf.wu
 * 
 */
public class ServerContextLoaderListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ServletContext context = event.getServletContext();
		// swagger.api.Bootstrap
		JaxrsApiReader.setFormatString("");

		try {
			initContextUtil(context);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void initContextUtil(ServletContext context) throws Exception {
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);

	}
}
