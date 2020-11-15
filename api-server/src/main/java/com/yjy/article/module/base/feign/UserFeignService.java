package com.yjy.article.module.base.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.yjy.article.module.base.feign.impl.UserFeignServiceImpl;
import com.yjy.common.vo.Result;

/**
 * 用户服务的远程调用服务
 */
@FeignClient(value = "user-server", fallback = UserFeignServiceImpl.class)
public interface UserFeignService {

	/**
	 * 调用 user-server 服务中的 获取用户信息
	 */
	@GetMapping("/user/info")
	Result<Object> getUserInfo();
}
