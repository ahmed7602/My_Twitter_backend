//package com.Twitter.Jarvis.Dto;
//
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//public class UserDto {
//
//    private Long Id;
//    private String fullName;
//    private String email;
//    private String image;
//    private String location;
//    private String website;
//    private String birthDate;
//    private String mobile;
//    private String backGroundImage;
//    private String bio;
//    private boolean req_user;
//    private boolean login_with_google;
//    private List<UserDto> followers = new ArrayList<>();
//    private List<UserDto> following = new ArrayList<>();
//    private boolean followed;
//    private boolean isVerified;
//
//    // Constructor for simplified UserDto
//    public UserDto(Long id, String fullName) {
//        this.Id = id;
//        this.fullName = fullName;
//    }
//
//    // Default constructor
//    public UserDto() {}
//}



package com.Twitter.Jarvis.Dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Long Id;
    private String fullName;
    private String email;
    private String image;
    private String location;
    private String website;
    private String birthDate;
    private String mobile;
    private String backGroundImage;
    private String bio;
    private boolean req_user;

    private boolean login_with_google;

    private List<UserDto> followers = new ArrayList<>();
    private List<UserDto> following = new ArrayList<>();

    private boolean followed;

    private boolean isVerified;
}
