package org.sreesoft.graphql.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.tomcat.
TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author k_sre
 *
 */
@Component
public class CustomContainer implements
  WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
  /**
 *
 */
private static final Logger LOG =
LoggerFactory.getLogger(CustomContainer.class);
  @Override
public final void customize(final TomcatServletWebServerFactory factory) {
    LOG.info("!!!!!!!!!!!!!!!!!!Application Started !!!!!!!!!!!!!!!!");
     factory.setContextPath("/sreesoft");
         }
}
