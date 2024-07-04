/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author black
 */
public class ENV {

    // Google capcha
    public static final String GOOGLE_RECAPTCHA_SITE_KEY = "6Ldt9SIkAAAAAJXweley4ZWpvdz_bMC5xQkIMCcm";
    public static final String GOOGLE_RECAPTCHA_SECRET_KEY = "6Ldt9SIkAAAAACrvcZSQ4kj-HNSU_WfRfccgDgAI";

    // SMTP Account
    public static final String SMTP_HOST = "smtp-mail.outlook.com";
    public static final String SMTP_PORT = "587";
    public static final String SMTP_ACCOUNT_EMAIL = "swp391_Group5@outlook.com";
    public static final String SMTP_ACCOUNT_PASSWORD = "swp391group5";

    //Authentication Secret Key for HMAC Algorithm
    public static final String AUTH_SECRET_KEY = "swp391_group5_111";

    //SMS
    public static final String SMS_ACOUNT_SID = "AC897f38a6ad7b654bf3fa3be1b46ad66c";
    public static final String SMS_AUTH_TOKEN = "238fd2706cedd2024a22566bfd6c6225";
    public static final String HOST_SMS = "+13044076271";

    // Depoyed
    public static final String DOMAIN = "localhost";
    public static final Integer PORT = 9999;
    public static final String HOST = DOMAIN + ":" + PORT + "/SWP391-Group5";

    //login google
    public static final String GOOGLE_CLIENT_ID = "932191573723-aetmlq3bltg97q1isuebe1oaehmu2126.apps.googleusercontent.com";
    public static final String GOOGLE_CLIENT_SECRET = "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";
    public static final String GOOGLE_REDIRECT_URI = "http://localhost:9999/SWP391-Group5/loginGoogle";
    public static final String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    public static final String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    public static final String GOOGLE_GRANT_TYPE = "authorization_code";

}
