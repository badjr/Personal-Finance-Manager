package personalfinancemanager;

/**
 *
 * @author Geek Squad
 */

/**
 * A ProfileEntry consists of only the user ID, username, password, and
 * e-mail of a profile.
 */
public class ProfileEntry {
    private int userID;
    private String userName;
    private String password;
    private String eMail;
    
    public ProfileEntry(int userID, String userName, String password, String eMail) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.eMail = eMail;
    }
    
    public int getUserID() {
        return this.userID;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getEmail() {
        return this.eMail;
    }
    
    @Override
    public String toString() {
        return this.userName + "," + this.password + "," + this.eMail;
    }
    
}
