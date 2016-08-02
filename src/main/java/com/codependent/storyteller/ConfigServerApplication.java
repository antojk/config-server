package com.codependent.storyteller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.config.EnvironmentRepositoryConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
@EnableAutoConfiguration
public class ConfigServerApplication {

	private Logger logger = LoggerFactory.getLogger(getClass());
	static {

		// System.setProperty("archaius.configurationSource.defaultFileName",
		// "config.properties");
	}

	@Autowired
	EnvironmentRepositoryConfiguration config;

	/*@Autowired
	EnvironmentRepository repo;*/

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
		setProxyOn();
	}

	private static void setProxyOn() {
		System.setProperty("https.proxyHost", "kcaws1prx");
		System.setProperty("https.proxyPort", "8080");
		System.setProperty("http.proxyHost", "kcaws1prx");
		System.setProperty("http.proxyPort", "8080");
		// To By Pass the proxy
		System.setProperty("http.nonProxyHosts",
				"kcaws1bpm01.kcapps.kpmg.com|kcaws1dvbpm01.kcapps.kpmg.com|kcaws1dvexp02.kcapps.kpmg.com");
		// System.setProperty("archaius.configurationSource.defaultFileName",
		// "config.properties");
	}

	/*private void logConfig() {
		config.configServerHealthIndicator(repo).health().getDetails();
	}
*/
	/*
	 * @Bean public AbstractConfiguration sampleArchaiusConfiguration() throws
	 * Exception { ConcurrentMapConfiguration concurrentMapConfiguration = new
	 * ConcurrentMapConfiguration();
	 * concurrentMapConfiguration.addProperty("testkey", "testvalue");
	 * System.out.println(concurrentMapConfiguration.getString("longprop"));
	 * return concurrentMapConfiguration; }
	 */

}
