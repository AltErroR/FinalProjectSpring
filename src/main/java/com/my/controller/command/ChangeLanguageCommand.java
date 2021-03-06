package com.my.controller.command;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.constants.Constants.*;
@Component
public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().setAttribute(SESSION_LANGUAGE, request.getParameter(LANGUAGE));
        String lastPath= request.getHeader("referer");
        if(lastPath.contains("?language")||lastPath.contains("&language")){
            return LOG_OUT_COMMAND;
        }
        if(lastPath!=null){
            return lastPath.substring(lastPath.indexOf("/controller"));
        }
        return "";
    }
}
