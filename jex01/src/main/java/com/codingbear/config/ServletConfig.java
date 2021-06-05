package com.codingbear.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"com.codingbear.controller", "com.codingbear.exception"})
public class ServletConfig implements WebMvcConfigurer {
	
	// @Controllers 에서 .jsp 리소스에 렌더링 하도록 /WEB-INF/views 뷰 폴더를 설정함
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	
	// /resources/** 에 대한 HTTP GET 요청을  정적 리소스인  ${webappRoot}/resources 로 이동 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	// 파일 업로드 관련 설정
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		// 업로드 최대 용량 :  10MB
		resolver.setMaxUploadSize(1024 * 1024 * 10);
		// 파일당 업로드 용량 : 2MB
		resolver.setMaxUploadSizePerFile(1024 * 1024 * 2);
		// 최대 메모리 크기 : 1MB
		resolver.setMaxInMemorySize(1024 * 1024);
		// temp upload 폴더
		resolver.setUploadTempDir(new FileSystemResource("D:\\upload\\tmp"));
		// 파일 인코딩 : UTF-8		
		resolver.setDefaultEncoding("UTF-8");
		
		return resolver;		
	}
	
}
