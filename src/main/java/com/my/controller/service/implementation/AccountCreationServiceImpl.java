package com.my.controller.service.implementation;

import com.my.controller.service.AccountCreationService;
import com.my.entity.Account;
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

@Service("AccountCreationService")
public class AccountCreationServiceImpl implements AccountCreationService {
    private static final Logger logger = LoggerFactory.getLogger(AccountCreationServiceImpl.class);
    UserRepository userRepository;
    MasterRepository masterRepository;
    AdminRepository adminRepository;
    AccountRepository accountRepository;
    User user;
    Master master;
    Account account;

    @Autowired
    public AccountCreationServiceImpl(UserRepository userRepository, MasterRepository masterRepository,
                                      AdminRepository adminRepository, AccountRepository accountRepository){

        this.adminRepository= adminRepository;
        this.userRepository=userRepository;
        this.masterRepository=masterRepository;
        this.accountRepository=accountRepository;
    }
    @Lookup
    public User getUser() {
        return null;
    }
    @Lookup
    public Account getAccount() {
        return null;
    }
    @Lookup
    public Master getMaster() {
        return null;
    }

    @Transactional
        @Override
        public String creation(HttpServletRequest request, HttpServletResponse response) throws Exception {
            logger.debug("account creation");
            HttpSession session =  request.getSession(false);
            if (session != null) {
                session.invalidate();
                logger.debug("session invalidation");
            }
            String login= request.getParameter(LOGIN);
            String password=request.getParameter(PASSWORD);
            String passwordRepeat=request.getParameter(PASSWORD_REPEAT);
            String email=request.getParameter(EMAIL);
            String role= request.getParameter(ROLE);

            if (accountRepository.existsAccountByLogin(login)||
                     !password.equals(passwordRepeat)) {
                logger.warn("wrong input or account exist");
                throw new Exception("Bad credentials for entered user data during account creation");
            }
            account= getAccount();
            account.setEmail(email);
            account.setPassword(password);
            account.setLogin(login);
            accountRepository.save(account);
            if (USER.equals(role)) {
                logger.debug("role - user");
                session = request.getSession();
                user=getUser();
                user.setId(account.getId());
                user.setWallet(0);
                userRepository.save(user);
                session.setAttribute(ROLE, role);
                session.setAttribute(USER_ID, user.getId());
                session.setAttribute(USER_LOGIN, account.getLogin());
                session.setAttribute(USER_LOGGED_IN, true);
                session.setAttribute(WALLET,user.getWallet());
                return MAIN_JSP;
            }
            if (MASTER.equals(role)) {
                logger.debug("role - master");
                session = request.getSession();
                master=getMaster();
                master.setId(account.getId());
                master.setStatus("notVIP");
                master.setRating("0");
                masterRepository.save(master);
                session.setAttribute(ROLE, role);
                session.setAttribute(USER_ID, master.getId());
                session.setAttribute(USER_LOGIN, account.getLogin());
                session.setAttribute(USER_LOGGED_IN, true);
                return MASTER_HOME_JSP;
            }
            logger.warn("some strange happened, redirect on error.jsp");
            return ERROR_JSP;
        }

}

