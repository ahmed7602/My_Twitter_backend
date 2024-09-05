package com.Twitter.Jarvis.Repository;

import com.Twitter.Jarvis.Model.TwitConfigurationModel;
import com.Twitter.Jarvis.Model.UserConfigurationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TwitRepository extends JpaRepository<TwitConfigurationModel, Long> {
    List<TwitConfigurationModel> findAllByIsTwitTrueOrderByCreatedAtDesc();
    List<TwitConfigurationModel> findByRetwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(UserConfigurationModel user, Long userId);

    List<TwitConfigurationModel> findByLikesContainingOrderByCreatedAtDesc(UserConfigurationModel user);
    @Query("Select t from TwitConfigurationModel t JOIN t.likes I where I.user.id=:userId")
    List<TwitConfigurationModel> findByLikesUser_id(@Param("userId") Long userId);
}
