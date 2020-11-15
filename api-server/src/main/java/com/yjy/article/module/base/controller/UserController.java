package com.yjy.article.module.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjy.article.module.base.feign.UserFeignService;
import com.yjy.article.module.base.service.IUserLocalService;
import com.yjy.common.constant.TokenConstant;
import com.yjy.common.vo.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户相关控制器
 * 
 */
@RestController
@Slf4j
@RequestMapping("/api")
public class UserController {

	@Autowired
	IUserLocalService userLocalService;

	@Autowired
	UserFeignService userFeignService;

	/**
	 * 本地接口, 这只是一个示例
	 */
	@GetMapping("/hello/{name}")
	public Result<Object> hello(@PathVariable String name) {
		log.info("调用了Api本地的服务, 参数：{}", name);
		return userLocalService.sayHello(name);
	}

	/**
	 * 调用了user-server 的获取用户信息的接口
	 */
	@GetMapping("/getUserInfo")
	public Result<Object> getUserInfo(HttpServletRequest request) {
		log.info("调用了用户微服务，获取用户信息, token: {}", request.getHeader(TokenConstant.TOKEN_PARAM_NAME));
		return userFeignService.getUserInfo();
	}
}
