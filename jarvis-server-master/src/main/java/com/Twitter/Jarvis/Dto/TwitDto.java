//package com.Twitter.Jarvis.Dto;
//
//import lombok.Data;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Data
//public class TwitDto {
//
//    private Long id;
//    private String content;
//    private String image;
//    private String video;
//    private UserDto user;
//    private LocalDateTime createdAt;
//    private int totalLikes;
//    private int totalReplies;
//    private int totalRetweets;
//    private boolean isLiked;
//    private boolean isRetwit;
//    private List<Long> retwitUserId;
//    private List<TwitDto> replyTwit;
//
//    // Constructor for simplified TwitDto
//    public TwitDto(Long id, String content, Long userId) {
//        this.id = id;
//        this.content = content;
//        this.user = new UserDto(userId, null);
//    }
//
//    // Default constructor
//    public TwitDto() {}
//}
//


package com.Twitter.Jarvis.Dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TwitDto {

    private Long id;
    private String content;
    private String image;
    private String video;
    private UserDto user;
    private LocalDateTime createdAt;
    private int totalLikes;
    private int totalReplies;
    private int totalRetweets;
    private boolean isLiked;
    private boolean isRetwit;

    private List<Long> retwitUserId;
    private List<TwitDto> replyTwit;
}
