package com.home.onlineshop.service.interfaces.mailSerivces;


public interface SendReportToMail {
    void SendEmail(String to, String subject,String message) throws Exception;
}