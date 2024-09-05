package com.Twitter.Jarvis.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LikeConfigurationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    @ManyToOne
    @ToString.Exclude
    private UserConfigurationModel user;

//    @JoinColumn(name = "twit_id", nullable = false)
    @JsonIgnore
    @ManyToOne
    @ToString.Exclude
    private TwitConfigurationModel twit;
}


//package com.Twitter.Jarvis.Model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Data
//@Entity
//public class LikeConfigurationModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @ManyToOne
//    private UserConfigurationModel user;
//
//    @ManyToOne
//    private TwitConfigurationModel twit;
//}
