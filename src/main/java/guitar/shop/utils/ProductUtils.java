package guitar.shop.utils;

import java.security.SecureRandom;

public class ProductUtils {
    private static final String RDSTRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * this method to generate auto 8 chart 0-9, a-z, A-Z
     * @param length of expected string
     * @return expected random string
     */
    public static String generateCustomerId(int length){
        StringBuilder stringBuilder = new StringBuilder(length);
        SecureRandom rnd = new SecureRandom();
        for (int i = 0; i < length; i++){
            stringBuilder.append(RDSTRING.charAt(rnd.nextInt(RDSTRING.length())));
        }
        return stringBuilder.toString();
    }
}
