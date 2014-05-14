package encrypt;

import java.security.MessageDigest;
import personalfinancemanager.ProfileEntry;

/**
 *
 * @author Geek Squad
 */
/**
 * The Encryptor class provides an Encryptor object that encrypts and decrypts
 * strings.
 */
public class Encryptor {

    private char origString[];

    /**
     * @pre A string has yet to be encrypted.
     * @post An encrypted string is returned.
     * @param s The string to encrypt.
     * @return The encrypted string.
     */
    public String encrypt(String s) {
        //To encrypt, add 10 to each character's corresponding ASCII value.
        origString = s.toCharArray();
        for (int i = 0; i < origString.length; i++) {
            origString[i] += 10;
        }

        return new String(origString);
    }

    /**
     * @pre A string has yet to be decrypted.
     * @post A decrypted string is returned.
     * @param s The string to decrypt.
     * @return The decrypted string.
     */
    public String decrypt(String s) {
        //To decrypt, subtract 10 to each character's corresponding ASCII value.
        origString = s.toCharArray();
        for (int i = 0; i < origString.length; i++) {
            origString[i] -= 10;
        }

        return new String(origString);
    }

    /**
     *
     * @param pe The profile entry needed to be encrypted.
     * @return A comma separated String format of the encrypted profile ready to
     * be stored in the flatfile ProfilesDB.txt.
     */
    public String encryptProfileEntry(ProfileEntry pe) {
        return pe.getUserID() + "," + encrypt(pe.getUserName()) + "," + encrypt(pe.getPassword()) + "," + encrypt(pe.getEmail());
    }

    public byte[] storePasswordAsMD5(String username, String password) {
        // This method takes the user's username and password and calculates (returns) 
        // an MD5 hash salted with their username, which can be stored securely in the DB
        // This cannot be reversed/decrypted, so the 'decryption' algo simply
        // re-calculates the user's attempt at entering their password and compares
        // it with the old calculated value.

        byte[] pwdBytes = null; // Initliaze some empty byte arrays
        byte[] usrBytesSalt = null;

        try { // convert username string into byte array
            usrBytesSalt = username.getBytes("UTF8");
        }
        catch (java.io.UnsupportedEncodingException e) {
        }

        try { // convert pwd string into byte array
            pwdBytes = password.getBytes("UTF8");
        }
        catch (java.io.UnsupportedEncodingException e) {
        }

        // get a MessageDigest object
        MessageDigest encrypter = null;
        byte[] compHash = null; // create a bytearray to store the final value
        try { // Initialise encrypter with MD5 encryption algorithm
            encrypter = MessageDigest.getInstance("MD5");
            encrypter.update(usrBytesSalt); // set the salt as the username.
            encrypter.update(pwdBytes); // add the password.
            compHash = encrypter.digest(); // finish the job, storing the final pwd in compHash
        }
        catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Error during password encryption.");
        }

        return compHash;
    }

    /**
     * This method will hash the entered password and compare it with the stored
     * hash This way the passwords are never decrypted, and are much more
     * secure. Means that a username cannot be changed without also changing the
     * password but for the security that seems like an acceptable trade-off.
     *
     * @param username
     * @param password
     * @param retrievedPassword
     * @return
     */
    public boolean isPasswordCorrect(String username, String password, byte[] retrievedPassword) {
        //TODO: Put in ProfileDB.java maybe? Because this is where the other password checking method is.
        boolean response;

        byte[] pwdBytes = null; // Initliaze some empty byte arrays
        byte[] usrBytesSalt = null;

        try { // convert username string into byte array
            usrBytesSalt = username.getBytes("UTF8");
        }
        catch (java.io.UnsupportedEncodingException e) {
        }

        try { // convert pwd string into byte array
            pwdBytes = password.getBytes("UTF8");
        }
        catch (java.io.UnsupportedEncodingException e) {
        }

        // get a MessageDigest object
        MessageDigest encrypter = null;
        byte[] newHash = null; // create a bytearray to store the final value
        try { // Initialise encrypter with MD5 encryption algorithm
            encrypter = MessageDigest.getInstance("MD5");
            encrypter.update(usrBytesSalt); // set the salt as the username.
            encrypter.update(pwdBytes); // add the password.
            newHash = encrypter.digest(); // finish the job, storing the final pwd in compHash
        }
        catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Error during password encryption.");
        }
        response = encrypter.isEqual(newHash, retrievedPassword);

        return response;
    }
//    public String decryptProfileEntry(ProfileEntry pe) {
//    }
}
