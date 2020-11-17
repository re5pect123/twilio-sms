package com.twilio.sms.controllers;

import com.twilio.sms.model.SmsSender;
import org.springframework.web.bind.annotation.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class TwilioController {

    @CrossOrigin(origins = "*")
    @GetMapping("test")
    public String test(){
        return "GET TEST";
    }

    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "";
//            14. "Aadav83a1a6e45fff8sad9dc3002713a932e7";
//            211. "Asd83a1a6e45asd8bda9dc3002713a3212e44";
//            32. "AC83a1a64213fff8bda9dc3002713ad2ed";
//            29. "AC83a1a6e45fff8bda9dc3002713a932e7";
//            54. "AC83a1a6e45fff8bda9dasdasd33a556e1";
    public static final String AUTH_TOKEN = "";
//            29. "b0c52daadbafd6e2ac4a5e1f1f552eef";
//            18. "b0c52daadbafd6e2ac4a5e1f1f5das2";
//            887."b0c52dadasd6e2ac4a5e1f1f5bvavee2f";
//            44. "b0c21saaadbafd6e2ac4a5e1f1f552ee11";
//            339. "b0casdaadbafdasd4a5e1f1f55saf";

    @CrossOrigin
    @PostMapping("send-sms1")
    public String sendSMS(@RequestBody SmsSender smsSender){

        System.out.println(smsSender);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(smsSender.getToNumber()), // to
                        new PhoneNumber("+32460204052"), // from
                        smsSender.getTextMessage())
                .create();

        System.out.println(message.getSid());
        return "TEST";
    }

}
