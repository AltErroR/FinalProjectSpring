package com.my.repository;

import com.my.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.my.constants.SQLConstants.SQL_AUTO_GET_YESTERDAY_DATE_MAILS;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User getUserById(int id);
    User getByLogin(String login);
    boolean existsUserByLogin(String login);

    @Query(value = SQL_AUTO_GET_YESTERDAY_DATE_MAILS,nativeQuery = true)
    List<String> getmMails();
}
