package com.my;

import com.my.entity.*;
import com.my.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class BeautySalon extends SpringBootServletInitializer {

    static Logger logger = LoggerFactory.getLogger("reportsLogger");

    public static void main(String[] args) {
        logger.info("*** REPORTING SERVICE STARTED ***");
        SpringApplication.run(BeautySalon.class, args);
    }
}

//@SpringBootApplication
//public class BeautySalon  extends SpringBootServletInitializer {
////    @Autowired
////    AdminRepository adminRepository;
////    @Autowired
////    UserRepository userRepository;
////    @Autowired
////    MasterRepository masterRepository;
////    @Autowired
////    Admin admin;
////    @Autowired
////    User user;
////    @Autowired
////    Master master;
////    @Autowired
////    OrderRepository orderRepository;
//    @Autowired
//    Order order;
//    @Autowired
//    MasterServiceRepository masterServiceRepository;
//    @Autowired
//    MasterService masterService;
//    @Autowired
//    FeedbackRepository feedbackRepository;
//    @Autowired
//    Feedback feedback;
//
//
//        public static void main(String[] args) {
//            SpringApplication.run(BeautySalon.class, args);
//
//
//        }


//        @Bean
//    CommandLineRunner commandLineRunner(){return args -> {
////            admin=adminRepository.getByLogin("admin2");
////            user=userRepository.getByLogin("user3");
////            master=masterRepository.getMasterByLogin("master1");
////            System.out.println(admin.toString());
////            System.out.println(user.toString());
////            System.out.println(master.toString());
//
//            List<MasterService> mss= masterServiceRepository.findAllByServiceName("service1");
//            List<MasterService> msl= masterServiceRepository.findAllByMasterLogin("master1");
//            for (MasterService ms: mss) {
//                System.out.println(ms);
//            }
//            System.out.println();
//            for (MasterService ms: msl) {
//                System.out.println(ms);
//            }
//            System.out.println();
//            System.out.println(masterServiceRepository.count());
//        };
//        }
//}
