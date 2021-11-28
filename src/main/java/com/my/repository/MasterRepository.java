package com.my.repository;


import com.my.entity.Admin;
import com.my.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Master,Integer> {
    Master getMasterById(int id);
    Master getMasterByLogin(String login);
    boolean existsMasterByLogin(String login);
}
