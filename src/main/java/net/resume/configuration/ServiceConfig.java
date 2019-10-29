package net.resume.configuration;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

//создает бины для работы сервисов и так же считывает файлы property для использования аннотации value
@Configuration
@ComponentScan({ "net.resume.service.impl", "net.resume.component.impl" })
@EnableAspectJAutoProxy
public class ServiceConfig {
	
	@Bean
	public PropertiesFactoryBean properties(){
		PropertiesFactoryBean properties = new PropertiesFactoryBean();
		properties.setLocations(new ClassPathResource("logic.properties"));
		return properties;
	}
	

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() throws IOException {
		PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
		conf.setLocations(new ClassPathResource("logic.properties"), new ClassPathResource("properties/application.properties"), new ClassPathResource("properties/elasticsearch.properties"));
		return conf;
	}
}
