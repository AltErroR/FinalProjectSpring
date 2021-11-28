package com.my.controller.service;

import java.sql.Date;

public interface BookingService {
    String booking(Date dateSlot, String timeSlot, String masterLogin, String serviceName, int userId) throws Exception;
}
