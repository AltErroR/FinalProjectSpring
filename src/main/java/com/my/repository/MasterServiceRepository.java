package com.my.repository;

import com.my.dto.MasterServiceDTO;
import com.my.entity.MasterService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.my.constants.SQLConstants.*;

@Repository
public interface MasterServiceRepository extends JpaRepository<MasterService,Integer> {

    @Query(value = SQL_SUBLIST_BY_ID,nativeQuery = true)
    List<Map<String, String>> findAllById(int limit, int offset);
    @Query(value = SQL_SUBLIST_BY_SERVICE,nativeQuery = true)
    List<Map<String, String>> findAllByService(int limit,int offset);

    @Query(value = SQL_SUBLIST_BY_MASTER,nativeQuery = true)
    List<Map<String, String>> findAllByMaster(int limit,int offset);

    @Query(value = SQL_SUBLIST_BY_RATING,nativeQuery = true)
    List<Map<String, String>> findAllByRating(int limit,int offset);

    @Query(value = SQL_SUBLIST_BY_SERVICE_NAME,nativeQuery = true)
    List<Map<String, String>> findAllByServiceName(String serviceName,int limit,int offset);

    @Query(value = SQL_SUBLIST_BY_MASTER_NAME,nativeQuery = true)
    List<Map<String, String>> findAllByMasterLogin(String masterLogin, int limit,int offset);

}
