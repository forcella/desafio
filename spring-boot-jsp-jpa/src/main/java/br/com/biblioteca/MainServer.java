package br.com.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "br.com.biblioteca.service", "br.com.biblioteca.repository", "br.com.biblioteca.controller","br.com.biblioteca.config" })
@EnableJpaRepositories(basePackages = "br.com.biblioteca.repository")
public class MainServer extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MainServer.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainServer.class);
	}

}
