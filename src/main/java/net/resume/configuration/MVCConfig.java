package net.resume.configuration;

import java.util.List;

import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import net.resume.component.impl.ErrorHandler;

//описание web конфигурации, а так же обработка контроллеров
@Configuration
@EnableWebMvc
@ComponentScan({ "net.resume.controller"})
@EnableSpringDataWebSupport
public class MVCConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	private ErrorHandler errorHandler;
	//правила передачи управления контроллером на view
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/JSP/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	//обработка картинок
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		return multipartResolver;
	}
	//пути статических ресурсов не обрабатываемые контроллером
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/media/**").addResourceLocations("/media/");
		registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");
		registry.addResourceHandler("/browserconfig.xml").addResourceLocations("/browserconfig.xml");
	}
	//кастомный обработчик ошибок, взамен спринговому
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(errorHandler);
	}
	//конфигурация валидатора,форм
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
	    LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
	    localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
	    localValidatorFactoryBean.setValidationMessageSource(messageSource());
	    return localValidatorFactoryBean;
	}
	//описание файла с сообщениями при ошибках валидации
	@Bean
    public MessageSource messageSource() { 
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n.messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
