package Hash;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class PasswordHasher {
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    // Method to generate a random salt
    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // Method to hash a password with a salt
//    public static String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        md.update(salt);
//        byte[] hashedPassword = md.digest(password.getBytes());
//        return Hex.encodeHexString(hashedPassword);
//    }
    public static String hashPassword(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }
}