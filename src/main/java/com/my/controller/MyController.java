package com.my.controller;


import com.my.controller.command.Command;
import com.my.controller.command.CommandContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

import static com.my.constants.Constants.*;


@Controller
@RequestMapping ({"/"})
public class MyController {
    private static final Logger logger = LoggerFactory.getLogger(MyController.class);
    @Autowired
    public CommandContainer commandContainer;

//    public void init() {
//        String filePath = this.getClass().getResource("/").getPath();
//        filePath = filePath.substring(1).replace(BIN, SRC);
//        PropertyConfigurator.configure(filePath + LOG4J_PROPERTIES);
//        logger.debug("servlet initialized");
//    }


    @GetMapping({"/controller","/view"})
    public void doGet(@RequestParam("command")String[] commandName,HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        logger.debug("controller DoGet");
        Command command= CommandContainer.getCommand(commandName[0]);
        String address= ERROR_JSP;
        try{
            address=command.execute(request,response);
        }
        catch (Exception ex){
            logger.warn("command in CommandContainer don't exist");
            request.setAttribute("ex",ex);
        }
        request.getRequestDispatcher(address).forward(request,response);
    }



    @PostMapping({"/controller","/view"})
    public void doPost(@RequestParam("command")String commandName,HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        logger.debug("controller DoPost");
        Command command= CommandContainer.getCommand(commandName);
        String address= ERROR_JSP;
        try{
        address=command.execute(request,response);
        }
        catch (Exception ex){
            logger.warn("command in CommandContainer don't exist");
            request.getSession().setAttribute("ex",ex);
        }
        response.sendRedirect(address);
    }


}