package personalfinancemanager;

import encrypt.Encryptor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geek Squad
 */
/**
 * The ProfileDB loads/saves profiles to the ProfilesDB.txt file.
 */
public class ProfileDB { //We'll name the flat file containing the profiles "ProfilesDB.txt".

    private File f;
    private List<ProfileEntry> profileEntries;
    private boolean connected;
    private Encryptor encryptor;
    private Profile currentProfile;

    public ProfileDB() {
        profileEntries = new ArrayList();
        f = new File("ProfilesDB.txt");

        if (!f.exists()) {
            connected = false;
            System.out.println("We don't have any profiles yet.");

        }
        else {
            loadProfilesFromFile();
            connected = true;
        }

    }

    public Profile getCurrentProfile() {
        return currentProfile;
    }

    public int getNumProfiles() {
        return profileEntries.size();
    }

    /**
     * Load profiles from the ProfilesDB.txt file. When the file is read, the
     * entries are decrypted.
     *
     * @pre The profiles DB flat file exists and is accessible.
     * @post The profileEntries List is populated based on the entries found in
     * the profiles DB flat file, or if it doesn't exist or is empty, it is
     * created and the user will be asked to create a new profile.
     */
    private void loadProfilesFromFile() {
        Scanner s;
        encryptor = new Encryptor();
        try {
            s = new Scanner(f);
            s.useDelimiter(",");
            while (s.hasNextLine()) {
                profileEntries.add(new ProfileEntry(s.nextInt(),
                                                    encryptor.decrypt(s.next()),
                                                    encryptor.decrypt(s.next()),
                                                    encryptor.decrypt(s.next())));
            }
            s.close(); //Close scanner when done using.
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ProfileDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @pre The profiles DB flat file exists and is accesible.
     * @post A true or false value is returned based on whether the profile DB
     * flat file exists and is accessible.
     * @return True or false of whether or not profiles were loaded from the
     * flat file.
     */
    public boolean isConnected() {
        return this.connected;
    }

    /**
     * Checks if the user name and password match a profile in the profiles DB.
     *
     * @param userName
     * @param password
     * @return True if userName and password passed in is found in the profiles
     * DB false otherwise.
     */
    public boolean isAMatchingUsernameAndPassword(String userName, String password) {
        boolean isValidUser = false;
        for (int i = 0; i < profileEntries.size(); i++) {
            if (userName.equals(profileEntries.get(i).getUserName())
                    && password.equals(profileEntries.get(i).getPassword())) {
                isValidUser = true;
                currentProfile = new Profile(i, profileEntries.get(i).getUserName(), new TransactionsModel().loadTransactionsFromFlatFile(new File("Profiles\\" + profileEntries.get(i).getUserID() + "\\transactions.txt")));
                break;
            }
        }
        return isValidUser;
    }

    /**
     * Adds a new profile to the List of profile entries.
     *
     * @pre The profile entry has yet to be added to the List.
     * @post The profile entry is now added to the List of profile entries.
     */
    public void addNewProfile(int userID, String userName, String password, String eMail) {
        profileEntries.add(new ProfileEntry(userID, userName, password, eMail));
    }

    /**
     * Saves the List of profiles to the profiles DB flat file.
     *
     * @pre The profiles DB flat file exists and is accessible.
     * @post The profiles DB flat file is now updated based on the profiles that
     * were in the profile entries List.
     */
    public void saveProfilesToFile() {
        FileWriter fw = null;
        BufferedWriter bw = null;
        encryptor = new Encryptor();
        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < profileEntries.size(); i++) {
                bw.write(encryptor.encryptProfileEntry(profileEntries.get(i)) + System.lineSeparator());
            }
        }
        catch (IOException ex) {
            Logger.getLogger(ProfileDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                bw.close();
                fw.close();
            }
            catch (IOException ex) {
                Logger.getLogger(ProfileDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void printProfiles() {
        for (int i = 0; i < profileEntries.size(); i++) {
            System.out.println(profileEntries.get(i));
        }
    }
}
