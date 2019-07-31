package cpapi.utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {

    public static String generateMD5(String text) {
        String out;
        try {
            byte[] bytesOfMessage = text.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            StringBuilder hexString = new StringBuilder();
            byte[] hash = md.digest(bytesOfMessage);
            for (byte aHash : hash) {
                if ((0xff & aHash) < 0x10) {
                    hexString.append("0").append(Integer.toHexString((0xFF & aHash)));
                } else {
                    hexString.append(Integer.toHexString(0xFF & aHash));
                }
            }
            out = hexString.toString().toUpperCase();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            Logger.logThis(null, "ERROR MD5", e);
            out = null;
        }
        return out;
    }
}
