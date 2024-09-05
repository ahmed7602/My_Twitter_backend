package com.Twitter.Jarvis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class UserConfigurationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String location;
    private String website;
    private String dateOfBirth;
    private String email;
    private String password;
    private String mobile;
    private String image;
    private String backGroundImage;
    private String bio;
    private boolean req_user;
    private boolean login_with_google;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TwitConfigurationModel> twits = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LikeConfigurationModel> likes = new ArrayList<>();

    @Embedded
    private VerificationConfigurationModel verification;

//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "followers",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "follower_id")
//    )
    @JsonIgnore
    @ManyToMany
    private List<UserConfigurationModel> followers = new ArrayList<>();
//
//    @JsonIgnore
//    @ManyToMany
//    @JoinTable(
//            name = "user_followings",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "following_id")
//    )
    @JsonIgnore
    @ManyToMany
    private List<UserConfigurationModel> followings = new ArrayList<>();

    @Override
    public String toString() {
        return "UserConfigurationModel{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", location='" + location + '\'' +
                ", website='" + website + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", image='" + image + '\'' +
                ", backGroundImage='" + backGroundImage + '\'' +
                ", bio='" + bio + '\'' +
                ", req_user=" + req_user +
                ", login_with_google=" + login_with_google +
                '}';
    }
}


//package com.Twitter.Jarvis.Model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Data
//public class UserConfigurationModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private String fullName;
//    private String location;
//    private String website;
//    private String dateOfBirth;
//    private String email;
//    private String password;
//    private String mobile;
//    private String image;
//    private String backGroundImage;
//    private String bio;
//    private boolean req_user;
//    private boolean login_with_google;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<TwitConfigurationModel> twit = new ArrayList<>();
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<LikeConfigurationModel> likes = new ArrayList<>();
//
//    @Embedded
//    private VarificationConfigurationModel verification;
//
//    @ManyToMany
//    private List<UserConfigurationModel> followers = new ArrayList<>();
//
////    @ManyToMany(mappedBy = "followers")
//// Define the mapping from the other side
//    @ManyToMany
//    private List<UserConfigurationModel> followings = new ArrayList<>();
//
//    // Override toString() to prevent infinite recursion
//    @Override
//    public String toString() {
//        return "UserConfigurationModel{" +
//                "id=" + id +
//                ", fullName='" + fullName + '\'' +
//                ", location='" + location + '\'' +
//                ", website='" + website + '\'' +
//                ", dateOfBirth='" + dateOfBirth + '\'' +
//                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", mobile='" + mobile + '\'' +
//                ", image='" + image + '\'' +
//                ", backGroundImage='" + backGroundImage + '\'' +
//                ", bio='" + bio + '\'' +
//                ", req_user=" + req_user +
//                ", login_with_google=" + login_with_google +
//                // Do not include relationships that might cause recursion
//                '}';
//    }
//}
//
//
//
//
////package com.Twitter.Jarvis.Model;
////
////import com.fasterxml.jackson.annotation.JsonIgnore;
////import jakarta.persistence.*;
////import lombok.Data;
////
////import java.util.ArrayList;
////import java.util.List;
////
////@Entity
////@Data
//////@Table(name = "userconfigurationmodel")
////public class UserConfigurationModel {
////    @Id
////    @GeneratedValue(strategy = GenerationType.AUTO)
////    private Long id;
////
////    private String fullName;
////    private String location;
////    private String website;
////    private String dateOfBirth;
////    private String email;
////    private String password;
////    private String mobile;
////    private String image;
////    private String backGroundImage;
////    private String bio;
////    private boolean req_user;
////    private boolean login_with_google;
////
////    @JsonIgnore
////    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
////    private List<TwitConfigurationModel> twit = new ArrayList<>();
////
////    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
////    private List<LikeConfigurationModel> likes = new ArrayList<>();
////
////    @Embedded
////    private VarificationConfigurationModel verification;
////
////    @ManyToMany
////    private List<UserConfigurationModel> followers = new ArrayList<>();
////
////    @ManyToMany
////    private List<UserConfigurationModel> followings = new ArrayList<>();
////
////}
