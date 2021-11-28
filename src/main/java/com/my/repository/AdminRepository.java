package com.my.repository;

import com.my.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin getAdminById(int id);
    Admin getByLogin(String login);
    boolean existsAdminByLogin(String login);
}
