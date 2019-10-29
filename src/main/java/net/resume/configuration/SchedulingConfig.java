package net.resume.configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

//конфиг для работы сервиса по удалению незавершенных профилей по времени
@Configuration
@EnableScheduling
public class SchedulingConfig implements SchedulingConfigurer {
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(applicationScheduler());
	}


	@Bean(/*destroyMethod="shutdown"*/)
	public ScheduledExecutorService applicationScheduler(){
		return Executors.newScheduledThreadPool(1);
	}
}
