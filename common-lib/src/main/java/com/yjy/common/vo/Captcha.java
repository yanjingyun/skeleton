package com.yjy.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Captcha implements Serializable {

	private static final long serialVersionUID = 5261999185139870815L;

	private String captchaId;

    private String code;
}
