package com.my.constants;

public class SQLConstants {

    private  SQLConstants(){
        //constructor to make this class have no public constructors
    }


    public static final String SELECT_RESERVED_ORDERS ="SELECT * FROM beauty_salon_2.orders where status = 'reserved'";
        public static final String SELECT_DONE_ORDERS ="SELECT * FROM beauty_salon_2.orders where status = 'done'";
    public static final String SELECT_ORDERS_FOR_USER= "SELECT * From beauty_salon_2.orders " +
            "WHERE date_slot = CURDATE() - 1 and status='paid' and user_id= ?";
    public static final String SELECT_ORDERS_FOR_MASTER= "SELECT * FROM beauty_salon_2.orders \n" +
            " WHERE master_id = ? && date_slot = CURDATE()&& (status = 'reserved'||status = 'in progress')";

    public static final String SQL_SUBLIST_BY_ID = "SELECT accounts.login,services_masters.name_service\n" +
            "FROM services_masters, accounts\n" +
            "WHERE services_masters.master_id  = accounts.id\n" +
            "  ORDER BY services_masters.id LIMIT ? OFFSET ?";

    public static final String SQL_SUBLIST_BY_MASTER = "SELECT accounts.login,services_masters.name_service\n" +
            "FROM services_masters, accounts\n" +
            "WHERE services_masters.master_id  = accounts.id\n" +
            "  ORDER BY accounts.login LIMIT ? OFFSET ?";

    public static final String SQL_SUBLIST_BY_SERVICE = "SELECT accounts.login,services_masters.name_service\n" +
            "FROM services_masters, accounts\n" +
            "WHERE services_masters.master_id  = accounts.id\n" +
            "  ORDER BY services_masters.name_service LIMIT ? OFFSET ?";

    public static final String SQL_SUBLIST_BY_RATING = "SELECT accounts.login,services_masters.name_service\n" +
            "FROM services_masters, accounts,masters\n" +
            "WHERE services_masters.master_id  = accounts.id\n" +
            "  ORDER BY masters.rating*1 desc LIMIT ? OFFSET ? ";

    public static final String SQL_SUBLIST_BY_MASTER_NAME= "SELECT DISTINCT accounts.login,services_masters.name_service\n" +
            "FROM services_masters, accounts,masters\n" +
            "WHERE services_masters.master_id  = accounts.id \n" +
            "AND accounts.login= ?\n" +
            "  ORDER BY masters.rating*1 desc LIMIT ? OFFSET ? ";

    public static final String SQL_SUBLIST_BY_SERVICE_NAME=" SELECT DISTINCT accounts.login,services_masters.name_service\n" +
            "FROM services_masters, accounts,masters\n" +
            "WHERE services_masters.master_id  = accounts.id \n" +
            "AND services_masters.name_service= ?\n" +
            "  ORDER BY masters.rating*1 desc LIMIT ? OFFSET ?";

    public static final String SQL_AUTO_GET_YESTERDAY_DATE_MAILS = "SELECT email\n" +
            " From beauty_salon_2.accounts as a\n" +
            " INNER JOIN beauty_salon_2.orders as o ON a.id = o.user_id\n" +
            " WHERE o.date_slot = CURDATE() - 1 and o.status='paid'";
}
