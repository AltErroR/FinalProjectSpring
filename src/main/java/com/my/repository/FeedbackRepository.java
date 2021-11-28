package com.my.repository;

import com.my.entity.Admin;
import com.my.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    Feedback getFeedbackById(int id);
    Feedback findByUserIdAndMasterLogin(int userId, String login);
    boolean existsFeedbackByUserIdAndMasterLogin(int userId, String login);
}
