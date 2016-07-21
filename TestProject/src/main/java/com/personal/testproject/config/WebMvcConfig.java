package com.personal.testproject.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.AppCacheManifestTransformer;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"com.personal.testproject.config",
		"com.personal.testproject.controllers"})
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	private static final String version = "1.2.2";
	
	@Bean
	public ViewResolver viewResolver() {
		Map<String, String> attributes = new HashMap<>();
		attributes.put("version", version);
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setViewNames("home");
		viewResolver.setAttributesMap(attributes);
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }    
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		boolean enableCacheBusting = true;
		
		VersionResourceResolver versionResolver = new VersionResourceResolver()
			.addFixedVersionStrategy(version, "/**/*.js")
			.addContentVersionStrategy("/**");

		registry.addResourceHandler("/resources/**")
			.setCachePeriod(enableCacheBusting ? 365 * 24 * 60 * 60 : 0)
	    	.addResourceLocations("/resources/", "classpath:/resources/")
	    	.resourceChain(true)
	    	.addResolver(versionResolver)
	    	.addTransformer(new AppCacheManifestTransformer());
	 }
}
