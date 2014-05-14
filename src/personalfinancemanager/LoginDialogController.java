package personalfinancemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Geek Squad
 */

/**
 * The purpose of this class is to make the login dialog perform actions when certain buttons are clicked.
 */
public class LoginDialogController {

    private ProfileDB profileDatabase;
    private LoginDialog loginDialog;
    private String userNameEntered;
    private String passwordEntered;
    private Profile profileFoundFromProfileDatabase;

    public LoginDialogController(LoginDialog loginDialog, ProfileDB profileDatabase) {
        this.profileDatabase = profileDatabase;
        this.loginDialog = loginDialog;

        loginDialog.addLoginButtonListener(new LoginButtonListener()); //Add the login button listener.
        
        //Hide the incorrect password label when first showing the login dialog, because the user hasn't entered anything yet.
        loginDialog.hideIncorrectPasswordLabel();
        
        loginDialog.addCreateNewProfileLabelListener(new CreateNewProfileLabelListener());

    }

    /**
     * When the Create New Profile Label is clicked, the loginDialog should be
     * closed and the account setup wizard should open up.
     */
    private class CreateNewProfileLabelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            loginDialog.dispose(); //When clicked, close the login dialog.
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    //When the login button is pressed, perform these actions.
    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            userNameEntered = loginDialog.getUserNameFromTextField(); //Get the user name from the text entered in the user name text field.
            passwordEntered = loginDialog.getPasswordFromTextField(); //Get the password from the text entered in the password field.
            if (profileDatabase.isAMatchingUsernameAndPassword(userNameEntered, passwordEntered)) {
                //Go through all stored profiles to see if there is a match between the user name and password entered.
                profileFoundFromProfileDatabase = profileDatabase.getCurrentProfile();
                loginDialog.dispose();
            }
            else {
                //FIXME: Same as in ProfileCreatorController, why does it shrink the password field to the number of characters?
                loginDialog.showIncorrectPasswordLabel();
                System.out.println("Wrong password.");
            }
        }
    }

    public Profile getProfile() {
        return profileFoundFromProfileDatabase;
    }
}
