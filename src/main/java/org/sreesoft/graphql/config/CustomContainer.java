package org.sreesoft.graphql.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomContainer implements 
  WebServerFactoryCustomizer<TomcatServletWebServerFactory>{
  private static final Logger log= LoggerFactory.getLogger(CustomContainer.class);
  @Override
     public void customize(TomcatServletWebServerFactory factory){
    	log.info("!!!!!!!!!!!!!!!!!!Application Started !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    		 factory.setContextPath("/sreesoft");
         }
}