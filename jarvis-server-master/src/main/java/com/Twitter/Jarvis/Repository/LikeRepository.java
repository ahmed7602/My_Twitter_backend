package com.Twitter.Jarvis.Repository;

import com.Twitter.Jarvis.Model.LikeConfigurationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<LikeConfigurationModel, Long> {

    // Query to check if a like exists for a specific user and twit
    @Query("SELECT l FROM LikeConfigurationModel l WHERE l.user.id = :userId AND l.twit.id = :twitId")
    LikeConfigurationModel isLikeExist(@Param("userId") Long userId, @Param("twitId") Long twitId);

    // Query to find all likes for a specific twit
    @Query("SELECT l FROM LikeConfigurationModel l WHERE l.twit.id = :twitId")
    List<LikeConfigurationModel> findByTwitId(@Param("twitId") Long twitId);
}

