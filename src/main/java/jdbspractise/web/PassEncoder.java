package jdbspractise.web;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PassEncoder {
    private static MessageDigest md;

    public static String encode(String pass) {
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();

            md.reset();

            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PassEncoder.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
