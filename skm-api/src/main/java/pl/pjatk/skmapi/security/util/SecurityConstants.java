package pl.pjatk.skmapi.security.util;

public class SecurityConstants {
    public static final String SECRET = "SECURE_SECRET_AF";
    public static final long EXPIRATION_TIME = 1000 * 60 * 15 ; // 15 minutes
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
