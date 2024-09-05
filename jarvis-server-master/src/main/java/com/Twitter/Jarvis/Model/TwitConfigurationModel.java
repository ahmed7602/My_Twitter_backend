package com.Twitter.Jarvis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TwitConfigurationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    @ManyToOne
    private UserConfigurationModel user;

    private String content;
    private String image;
    private String video;

    @JsonIgnore
    @OneToMany(mappedBy = "twit", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<LikeConfigurationModel> likes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "replyFor", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<TwitConfigurationModel> replyTwits = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(
//            name = "twit_retwit_user",
//            joinColumns = @JoinColumn(name = "twit_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
    @JsonIgnore
    @ManyToMany
    @ToString.Exclude
    private List<UserConfigurationModel> retwitUser = new ArrayList<>();

//    @JoinColumn(name = "reply_for_id")
    @JsonIgnore
    @ManyToOne
    private TwitConfigurationModel replyFor;

    private boolean isReply;
    private boolean isTwit;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}



//package com.Twitter.Jarvis.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//public class TwitConfigurationModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @ManyToOne
//    private UserConfigurationModel user;
//
//    private String content;
//    private String image;
//    private String video;
//
////    @OneToMany(mappedBy = "twit", cascade = CascadeType.ALL)
//    @OneToMany
//    private List<LikeConfigurationModel> likes = new ArrayList<>();
//
//    @OneToMany
//    private List<TwitConfigurationModel> replyTwits = new ArrayList<>();
//
//    @ManyToMany
//    private List<UserConfigurationModel> retwitUser = new ArrayList<>();
//
//    @ManyToOne
//    private TwitConfigurationModel replyFor;
//
//    private boolean isReply;
//    private boolean isTwit;
////    private boolean isLiked;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime createdAt;
//}
