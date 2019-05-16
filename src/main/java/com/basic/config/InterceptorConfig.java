package com.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.basic.handler.AuthenticationInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    			//添加拦截器
        registry.addInterceptor(authenticationInterceptor())
        		//拦截地址
                .addPathPatterns("/**")
                //排除地址
                .excludePathPatterns("/login**");
        //多拦截器配置,添加顺序即为执行顺序
		/* registry.addInterceptor(myInterceptor).addPathPatterns("/test/**"); */
    }
    
    //注册拦截器
    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
    
	/*	//注册拦截器,与上等同
	 * @Resource private AuthenticationInterceptor authenticationInterceptor;
	 */
}
