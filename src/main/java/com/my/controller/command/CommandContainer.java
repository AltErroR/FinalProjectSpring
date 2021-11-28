package com.my.controller.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.my.constants.Constants.*;

@Component
public class CommandContainer {


    private static final Logger logger = LoggerFactory.getLogger(CommandContainer.class);
    private static final Map<String,Command> commands= new HashMap<>();

    public static Command getCommand(String commandName){
        logger.debug("command: {} invoked ", commandName);
        return commands.get(commandName);
    }
    @Autowired
    private CommandContainer(AdminHomeCommand adminHomeCommand,BookingCommand bookingCommand,AccountCreationCommand accountCreationCommand,
            ErrorCommand errorCommand,FeedbackCommand feedbackCommand,FeedbackWriteCommand feedbackWriteCommand,
            HomePageCommand homePageCommand,LoginCommand loginCommand,LogoutCommand logoutCommand,
            MainPageCommand mainPageCommand,SortByMasterCommand sortByMasterCommand,SortByServiceCommand sortByServiceCommand,
            SortByRatingCommand sortByRatingCommand,SortByMasterLoginCommand sortByMasterLoginCommand,
            SortByServiceNameCommand sortByServiceNameCommand,MasterHomeInitCommand masterHomeInitCommand,
            OrdersCommand ordersCommand,OrderChangeCommand orderChangeCommand,PaymentCommand paymentCommand,
            PaymentAcceptCommand paymentAcceptCommand,StatusChangeCommand statusChangeCommand,SuccessCommand successCommand,
                             ChangeLanguageCommand changeLanguageCommand){

            commands.put(ADMIN_HOME, adminHomeCommand);
            commands.put(BOOKING, bookingCommand);
            commands.put(CREATION, accountCreationCommand);
            commands.put(ERROR, errorCommand);
            commands.put(FEEDBACK, feedbackCommand);
            commands.put(WRITE_FEEDBACK, feedbackWriteCommand);
            commands.put(HOME, homePageCommand);
            commands.put(LOGIN, loginCommand);
            commands.put(LOG_OUT, logoutCommand);
            commands.put(MAIN,mainPageCommand);
            commands.put(MAIN_MASTER,sortByMasterCommand);
            commands.put(MAIN_SERVICE, sortByServiceCommand);
            commands.put(MAIN_RATING, sortByRatingCommand);
            commands.put(MAIN_MASTER_NAME, sortByMasterLoginCommand);
            commands.put(MAIN_SERVICE_NAME, sortByServiceNameCommand);
            commands.put(MASTER_HOME, masterHomeInitCommand);
            commands.put(ORDERS, ordersCommand);
            commands.put(CHANGE_ORDER, orderChangeCommand);
            commands.put(PAYMENT, paymentCommand);
            commands.put(ACCEPT_PAYMENT, paymentAcceptCommand);
            commands.put(CHANGE_STATUS, statusChangeCommand);
            commands.put(SUCCESS, successCommand);
            commands.put(CHANGE_LANGUAGE, changeLanguageCommand);

    }
}
