package com.my.controller.service.implementation;

import com.my.controller.service.LoginService;
import com.my.entity.Admin;
import com.my.entity.Master;
import com.my.entity.User;
import com.my.repository.AdminRepository;
import com.my.repository.MasterRepository;
import com.my.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.my.constants.Constants.*;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
            public LoginServiceImpl(AdminRepository adminRepository, MasterRepository masterRepository,
            UserRepository userRepository){
       this.adminRepository=adminRepository;
        this.masterRepository=masterRepository;
        this.userRepository=userRepository;
    }
    @Lookup
    public Admin getAdmin() {
        return null;
    }
    @Lookup
    public Master getMaster() {
        return null;
    }
    @Lookup
    public User getUser() {
        return null;
    }
    AdminRepository adminRepository;
    MasterRepository masterRepository;
    UserRepository userRepository;
    User user;
    Master master;
    Admin admin;
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session.getAttribute(USER_LOGGED_IN)==null) {
            session.invalidate();
        }
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String role = request.getParameter(ROLE);

        if (!userRepository.existsUserByLogin(login) &&
                !masterRepository.existsMasterByLogin(login) &&
                !adminRepository.existsAdminByLogin(login)) {
            logger.warn("no such user");
            throw new Exception("No such user");
        }
        if (USER.equals(role) && userRepository.existsUserByLogin(login)) {
            user=getUser();
            user = userRepository.getByLogin(login);
            if (!user.getPassword().equals(password)) {
                logger.warn(WRONG_PASSWORD);
                throw new Exception(WRONG_PASSWORD);
            }
            session = request.getSession();
            session.setAttribute(WALLET, user.getWallet());
            session.setMaxInactiveInterval(300);
            session.setAttribute(ROLE, role);
            session.setAttribute(USER_ID, user.getId());
            session.setAttribute(USER_LOGIN, user.getLogin());
            session.setAttribute(USER_LOGGED_IN, true);
            logger.debug("user logged in");
            return MAIN_PAGE_COMMAND;
        }
        if (MASTER.equals(role) && masterRepository.existsMasterByLogin(login)) {
            master=getMaster();
            master = masterRepository.getMasterByLogin(login);
            if (!master.getPassword().equals(password)) {
                logger.warn(WRONG_PASSWORD);
                throw new Exception(WRONG_PASSWORD);
            }
            session = request.getSession();
            session.setMaxInactiveInterval(300);
            session.setAttribute(ROLE, role);
            session.setAttribute(USER_ID, master.getId());
            session.setAttribute(USER_LOGIN, master.getLogin());
            session.setAttribute(USER_LOGGED_IN, true);
            logger.debug("master logged in");
            return MASTER_HOMEPAGE_COMMAND;
        }
        if (!adminRepository.existsAdminByLogin(login)) {
            logger.warn("log in failed");
            session.invalidate();
            throw new Exception("Your data is as invalid as you");
        }
        admin=getAdmin();
        admin=adminRepository.getByLogin(login);
        if (!admin.getPassword().equals(password)) {
            logger.warn(WRONG_PASSWORD);
            throw new Exception(WRONG_PASSWORD);
        }
        session = request.getSession();
        session.setMaxInactiveInterval(300);
        session.setAttribute(ROLE, ADMIN);
        session.setAttribute(USER_ID, admin.getId());
        session.setAttribute(USER_LOGIN, admin.getLogin());
        session.setAttribute(USER_LOGGED_IN, true);
        logger.debug("admin logged in");
        return ADMIN_HOMEPAGE_COMMAND;
    }


}
