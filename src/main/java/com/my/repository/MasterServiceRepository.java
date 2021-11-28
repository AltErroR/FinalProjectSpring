package com.my.repository;

import com.my.entity.MasterService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.my.constants.SQLConstants.*;

@Repository
public interface MasterServiceRepository extends JpaRepository<MasterService,Integer> {

    MasterService getMasterServiceById(int integer);

    @Query(value = SQL_SUBLIST_BY_SERVICE,nativeQuery = true)
    List<MasterService> findAllByService();

    @Query(value = SQL_SUBLIST_BY_MASTER,nativeQuery = true)
    List<MasterService> findAllByMaster();

    @Query(value = SQL_SUBLIST_BY_RATING,nativeQuery = true)
    List<MasterService> findAllByRating();

    List<MasterService> findAllByServiceName(String serviceName);
    List<MasterService> findAllByMasterLogin(String masterLogin);

}
