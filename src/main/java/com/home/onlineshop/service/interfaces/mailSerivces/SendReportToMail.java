package com.home.onlineshop.service.interfaces.mailSerivces;


public interface SendReportToMail {
    void sendEmail(String to, String subject, String message) throws Exception;
}
