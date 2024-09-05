package com.Twitter.Jarvis.Model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VerificationConfigurationModel {
    private boolean status = false;
    private LocalDateTime startedAt;
    private LocalDateTime endsAt;
    private String planType;
}




//package com.Twitter.Jarvis.Model;
//
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Data
//public class VarificationConfigurationModel {
//    private boolean status = false;
//
//    private LocalDateTime startedAt;
//    private LocalDateTime endsAt;
//
//    private String planType;
//}
