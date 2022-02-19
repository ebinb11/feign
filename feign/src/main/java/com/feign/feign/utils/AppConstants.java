package com.feign.feign.utils;

public interface AppConstants {
	
	long TOKEN_VALIDITY_SECONDS = 6 * 60 * 60;
    long REMEMBER_ME_TOKEN_VALIDITY_SECONDS = 7 * 24 * 60 * 60;
    String SECRET_KEY = "K5KqA5G5sku";
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
	String INFO_EMAIL_ID = "ebinproject11@gmail.com";
	String INFO_EMAIL_PASSWORD = "ebinb11219";
	String USER_NAME = "ebinb11@gmail.com";
	String PASSWORD = "passwd";
	String EVERY_HOUR_OF_EVERY_DAY = "0 0 * * * *";
	String EVERY_TEN_SECONDS = "*/10 * * * * *";
}
