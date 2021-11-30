package com.my.repository;

import com.my.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
    Feedback getFeedbackById(int id);
    Feedback findByUserIdAndMasterId(int userId, int masterId);
    boolean existsFeedbackByUserIdAndMasterId(int userId, int masterId);
}
