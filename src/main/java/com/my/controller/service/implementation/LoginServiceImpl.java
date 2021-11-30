package com.my.controller.service.implementation;

import com.my.controller.service.LoginService;
import com.my.entity.Account;
import com.my.entity.Admin;
import com.my.entity.Master;
import com.my.entity.User;
import com.my.repository.AccountRepository;
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
import javax.transaction.Transactional;

import static com.my.constants.Constants.*;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    public LoginServiceImpl(AdminRepository adminRepository, MasterRepository masterRepository,
                            UserRepository userRepository, AccountRepository accountRepository) {
        this.adminRepository = adminRepository;
        this.masterRepository = masterRepository;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
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

    @Lookup
    public Account getAccount() {
        return null;
    }

    AdminRepository adminRepository;
    MasterRepository masterRepository;
    UserRepository userRepository;
    AccountRepository accountRepository;
    User user;
    Master master;
    Admin admin;
    Account account;
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Transactional
    @Override
    public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if (session.getAttribute(USER_LOGGED_IN) == null) {
            session.invalidate();
        }
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String role = request.getParameter(ROLE);

        if (!accountRepository.existsAccountByLogin(login)) {
            logger.warn("no such user");
            throw new Exception("No such user");
        }
        account = getAccount();
        account = accountRepository.getByLogin(login);
        if (!account.getPassword().equals(password)) {
            logger.warn(WRONG_PASSWORD);
            throw new Exception(WRONG_PASSWORD);
        }
        if(accountRepository.existsAccountByLogin(login)){
        if (USER.equals(role) && userRepository.existsUserById(account.getId())) {
            user = getUser();
            user = userRepository.getById(account.getId());
            session = request.getSession();
            session.setAttribute(WALLET, user.getWallet());
            session.setMaxInactiveInterval(300);
            session.setAttribute(ROLE, role);
            session.setAttribute(USER_ID, user.getId());
            session.setAttribute(USER_LOGIN, account.getLogin());
            session.setAttribute(USER_LOGGED_IN, true);
            logger.debug("user logged in");
            return MAIN_PAGE_COMMAND;
        }
        if (MASTER.equals(role) && masterRepository.existsMasterById(account.getId())) {
            master = getMaster();
            master = masterRepository.getMasterById(account.getId());
            session = request.getSession();
            session.setMaxInactiveInterval(300);
            session.setAttribute(ROLE, role);
            session.setAttribute(USER_ID, master.getId());
            session.setAttribute(USER_LOGIN, account.getLogin());
            session.setAttribute(USER_LOGGED_IN, true);
            logger.debug("master logged in");
            return MASTER_HOMEPAGE_COMMAND;
        }
        if (adminRepository.existsAdminById(account.getId())) {
            admin = getAdmin();
            admin = adminRepository.getAdminById(account.getId());
            session = request.getSession();
            session.setMaxInactiveInterval(300);
            session.setAttribute(ROLE, ADMIN);
            session.setAttribute(USER_ID, admin.getId());
            session.setAttribute(USER_LOGIN, account.getLogin());
            session.setAttribute(USER_LOGGED_IN, true);
            logger.debug("admin logged in");
            return ADMIN_HOMEPAGE_COMMAND;
        }
        }
        logger.warn("log in failed");
        session.invalidate();
        return ERROR_JSP;
    }
}
