package com.yjy.user.authorization.config;

import com.yjy.user.authorization.resolvers.CurrentUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import java.util.List;

/**
 * 配置类，增加自定义拦截器和解析器
 * 
 * @see com.yjy.user.authorization.resolvers.CurrentUserMethodArgumentResolver
 * 
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {

	@Autowired
	private CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(currentUserMethodArgumentResolver);
	}
}
