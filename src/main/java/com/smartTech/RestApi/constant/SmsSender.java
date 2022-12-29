package com.smartTech.RestApi.constant;

import com.smartTech.RestApi.dto.SmsRequest;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
    // or maybe void sendSms(String phoneNumber, String message);
}