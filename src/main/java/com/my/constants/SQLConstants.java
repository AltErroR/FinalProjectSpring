package com.my.constants;

public class SQLConstants {

    private  SQLConstants(){
        //constructor to make this class have no public constructors
    }

    public static final String INSERT_INTO_ACCOUNT = "INSERT INTO beauty_salon_2.account (id,login) VALUES (DEFAULT,?)";
    public static final String UPDATE_ACCOUNT ="UPDATE beauty_salon_2.account SET login = ?, pasword = ?, email = ? WHERE (id = ?)";
    public static final String SELECT_ACCOUNT="SELECT * FROM beauty_salon_2.account WHERE (id = ?)";
    public static final String SELECT_ACCOUNT_BY_LOGIN ="SELECT * FROM beauty_salon_2.account WHERE (login = ?)";
    public static final String DELETE_ACCOUNT="DELETE FROM beauty_salon_2.account WHERE (id = ?)";
    public static final String SELECT_ALL_ACCOUNTS = "SELECT * FROM beauty_salon_2.account";
    public static final String SELECT_ACCOUNT_ID="SELECT id FROM beauty_salon_2.account";

    public static final String INSERT_INTO_ADMIN = "INSERT INTO beauty_salon_2.admin (id) VALUES (?)";
    public static final String SELECT_ADMIN="SELECT * " +
            " FROM beauty_salon_2.account as ac " +
            " INNER JOIN beauty_salon_2.admin as ad ON ac.id= ad.id" +
            " WHERE ad.id = ? ";
    public static final String DELETE_ADMIN="DELETE FROM beauty_salon_2.admin WHERE (id = ?)";
    public static final String SELECT_ADMIN_ID="SELECT id FROM beauty_salon_2.admin";

    public static final String INSERT_INTO_FEEDBACK ="INSERT INTO beauty_salon_2.feedback (id,user_id, master_login) VALUES (DEFAULT,?,?)" ;
    public static final String UPDATE_FEEDBACK ="UPDATE beauty_salon_2.feedback SET user_id = ?, master_login = ?," +
            " feedback = ?,user_rate = ? WHERE (id = ?)";
    public static final String SELECT_FEEDBACK="SELECT * FROM beauty_salon_2.feedback WHERE (id = ?)";
    public static final String SELECT_FEEDBACK_BY_USER_MASTER="SELECT * FROM beauty_salon_2.feedback WHERE (user_id = ? and master_login= ?)";
    public static final String DELETE_FEEDBACK="DELETE FROM beauty_salon_2.feedback WHERE (id = ?)";
    public static final String SELECT_FEEDBACK_ID="SELECT id FROM beauty_salon_2.feedback";

    public static final String INSERT_INTO_MASTER = "INSERT INTO beauty_salon.master (login) VALUES (?)";
    public static final String UPDATE_MASTER ="UPDATE beauty_salon_2.master SET status = ?, rating = ? WHERE (login = ?)";
    public static final String SELECT_MASTER="SELECT * " +
            "FROM beauty_salon_2.account as a " +
            "INNER JOIN beauty_salon_2.master as m ON a.login = m.login " +
            "WHERE m.login = ? ";
    public static final String DELETE_MASTER="DELETE FROM beauty_salon_2.master WHERE (login = ?)";
    public static final String SELECT_MASTER_LOGIN="SELECT login FROM beauty_salon_2.master";

    public static final String INSERT_INTO_ORDER ="INSERT INTO beauty_salon_2.order (id,user_id, master_login,time_slot,date_slot,service_name) VALUES (DEFAULT,?,?,?,?,?)";
    public static final String UPDATE_ORDER ="UPDATE beauty_salon_2.order SET user_id = ?, master_login = ?," +
            " service_name = ?,time_slot = ?, date_slot= ?, status= ? WHERE (id = ?)";
    public static final String SELECT_ORDER="SELECT * FROM beauty_salon_2.order WHERE (id = ?)";
    public static final String SELECT_ORDER_WITHOUT_ID="SELECT * FROM beauty_salon_2.order WHERE(service_name = ? && time_slot= ? && master_login = ? && date_slot= ?)";
    public static final String DELETE_ORDER="DELETE FROM beauty_salon_2.order WHERE (id = ?)";
    public static final String SELECT_ORDER_ID="SELECT id FROM beauty_salon_2.order";
    public static final String SELECT_RESERVED_ORDERS ="SELECT * FROM beauty_salon_2.orders where status = 'reserved'";
        public static final String SELECT_DONE_ORDERS ="SELECT * FROM beauty_salon_2.orders where status = 'done'";
    public static final String SELECT_ORDERS_FOR_USER= "SELECT * From beauty_salon_2.orders " +
            "WHERE date_slot = CURDATE() - 1 and status='paid' and user_id= ?";
    public static final String SELECT_ORDERS_FOR_MASTER= "SELECT * FROM beauty_salon_2.orders \n" +
            " WHERE master_id = ? && date_slot = CURDATE()&& (status = 'reserved'||status = 'in progress')";

    public static final String INSERT_INTO_SERVICE = "INSERT INTO beauty_salon_2.service (name) VALUES (?)";
    public static final String UPDATE_SERVICE ="UPDATE beauty_salon_2.service SET price = ? WHERE (name = ?)";
    public static final String SELECT_SERVICE="SELECT * FROM beauty_salon_2.service WHERE (name = ?)";
    public static final String DELETE_SERVICE="DELETE FROM beauty_salon_2.service WHERE (name = ?)";
    public static final String SELECT_SERVICE_NAME="SELECT name FROM beauty_salon_2.service";

    public static final String INSERT_INTO_USER ="INSERT INTO beauty_salon_2.user (id) VALUES (?)" ;
    public static final String UPDATE_USER ="UPDATE beauty_salon_2.user SET wallet = ? WHERE (id = ?)";
    public static final String SELECT_USER="SELECT * " +
            " FROM beauty_salon_2.account as a " +
            " INNER JOIN beauty_salon_2.user as u ON a.id = u.id " +
            " WHERE u.id = ? ";
    public static final String DELETE_USER="DELETE FROM beauty_salon_2.user WHERE (id = ?)";
    public static final String SELECT_USER_ID="SELECT id FROM beauty_salon_2.user";

    public static final String INSERT_INTO_MASTER_SERVICES ="INSERT INTO beauty_salon_2.service_master (id,login_master, name_service) VALUES (DEFAULT,?,?)";
    public static final String UPDATE_MASTER_SERVICES ="UPDATE beauty_salon_2.service_master SET name_service = ?, login_master= ? WHERE (id =?)";
    public static final String SELECT_MASTER_SERVICES ="SELECT * FROM beauty_salon_2.service_master WHERE (id = ?)";
    public static final String DELETE_MASTER_SERVICES ="DELETE FROM  beauty_salon_2.service_master WHERE (id= ?)";
    public static final String SELECT_MASTER_SERVICES_ID ="SELECT id FROM beauty_salon_2.service_master";
    public static final String COUNT_MASTER_SERVICES = "select count(*) from services_masters";
    ////////////////////////experiments/////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    ////////////////////////experiments/////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String SQL_AUTO_GET_YESTERDAY_DATE_MAILS = "SELECT email\n" +
            " From beauty_salon_2.accounts as a\n" +
            " INNER JOIN beauty_salon_2.orders as o ON a.id = o.user_id\n" +
            " WHERE o.date_slot = CURDATE() - 1 and o.status='paid'";
}
