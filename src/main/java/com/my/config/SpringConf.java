package com.my.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * Replacement of applicationContextMvc xml
 */

@Configuration
@EnableJpaRepositories("com.my.repository")
@EnableAutoConfiguration
@ComponentScan("com.my")
@EntityScan(basePackages = "com.my.entity")
@EnableWebMvc
@EnableTransactionManagement
public class SpringConf implements WebMvcConfigurer {

    @Bean
    InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
        viewResolver.setPrefix("/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/beauty_salon_2")
                .username("root")
                .password("1111")
                .build();
    }

//    @Bean
//    @Scope("prototype")
//    public Admin admin(){return new Admin();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public User user(){return new User();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Master master(){return new Master();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Feedback feedback(){return new Feedback();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public MasterService masterService(){return new MasterService();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Order order(){return new Order();
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Service service(){return new Service();
//    }
//    @Bean
//    AdminHomeCommand adminHomeCommand() {
//        return new AdminHomeCommand();
//    }
//    @Bean
//    BookingCommand bookingCommand() {
//        return new BookingCommand();
//    }
//
//    @Bean
//    AccountCreationCommand accountCreationCommand() {
//        return new AccountCreationCommand();
//    }
//
//    @Bean
//    ErrorCommand errorCommand() {
//        return new ErrorCommand();
//    }
//
//    @Bean
//    FeedbackCommand feedbackCommand() {
//        return new FeedbackCommand();
//    }
//
//    @Bean
//    FeedbackWriteCommand feedbackWriteCommand() {
//        return new FeedbackWriteCommand();
//    }
//
//    @Bean
//    HomePageCommand homePageCommand() {
//        return new HomePageCommand();
//    }
//
//    @Bean
//    LoginCommand loginCommand() {
//        return new LoginCommand();
//    }
//
//    @Bean
//    LogoutCommand logoutCommand() {
//        return new LogoutCommand();
//    }
//
//    @Bean
//    MainPageCommand mainPageCommand() {
//        return new MainPageCommand();
//    }
//
//    @Bean
//    SortByMasterCommand sortByMasterCommand() {
//        return new SortByMasterCommand();
//    }
//
//    @Bean
//    SortByServiceCommand sortByServiceCommand() {
//        return new SortByServiceCommand();
//    }
//
//    @Bean
//    SortByRatingCommand sortByRatingCommand() {
//        return new SortByRatingCommand();
//    }
//
//    @Bean
//    SortByMasterLoginCommand sortByMasterLoginCommand() {
//        return new SortByMasterLoginCommand();
//    }
//
//    @Bean
//    SortByServiceNameCommand sortByServiceNameCommand() {
//        return new SortByServiceNameCommand();
//    }
//
//    @Bean
//    MasterHomeInitCommand masterHomeInitCommand() {
//        return new MasterHomeInitCommand();
//    }
//
//    @Bean
//    OrdersCommand ordersCommand() {
//        return new OrdersCommand();
//    }
//
//    @Bean
//    OrderChangeCommand orderChangeCommand() {
//        return new OrderChangeCommand();
//    }
//
//    @Bean
//    PaymentCommand paymentCommand() {
//        return new PaymentCommand();
//    }
//
//    @Bean
//    PaymentAcceptCommand paymentAcceptCommand() {
//        return new PaymentAcceptCommand();
//    }
//
//    @Bean
//    StatusChangeCommand statusChangeCommand() {
//        return new StatusChangeCommand();
//    }
//
//    @Bean
//    SuccessCommand successCommand() {
//        return new SuccessCommand();
//    }
//
//    @Bean
//    ChangeLanguageCommand changeLanguageCommand() {
//        return new ChangeLanguageCommand();
//    }
//    @Bean
//    CommandContainer commandContainer() {return new CommandContainer();}
//    @Bean
////    @Autowired
//    MainPageServiceImpl mainPageService(){return new MainPageServiceImpl();}

}



