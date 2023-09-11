package com.system.toursandtravelmanagement.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class ThymeleafConfig {
	
	@Bean
	public ClassLoaderTemplateResolver templateResolver() {
		ClassLoaderTemplateResolver template = new ClassLoaderTemplateResolver();
		template.setPrefix("templates/");
		template.setTemplateMode("HTML");
		template.setSuffix(".html");
		template.setTemplateMode("HTML");
		template.setCharacterEncoding("UTF-8");
		template.setOrder(1);
		return template;
	}

}
