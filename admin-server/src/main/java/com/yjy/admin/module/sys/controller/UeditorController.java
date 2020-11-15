package com.yjy.admin.module.sys.controller;

import com.yjy.admin.common.ueditor.ActionEnter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 百度编译器
 *
 * 
 */
@RestController
@CrossOrigin
@RequestMapping("/skeleton/ueditor")
public class UeditorController {

    @RequestMapping(value = "/exec")
    public String exec(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String rootPath = request.getServletContext().getRealPath("/");
        return new ActionEnter(request, rootPath).exec();
    }

}
