package personalfinancemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Geek Squad
 */

/**
 * The ProfileCreatorController controls the ProfileCreatorDialog (view) and uses
 * profileDatabase as a model.
 */
public class ProfileCreatorController {

    ProfileDB profileDatabase;
    ProfileCreatorDialog profileCreatorDialog;
    ProfileEntry profileCreated;

    public ProfileCreatorController(ProfileDB profileDatabase, ProfileCreatorDialog profileCreatorDialog) {
        this.profileDatabase = profileDatabase;
        this.profileCreatorDialog = profileCreatorDialog;
        if (!profileDatabase.isConnected()) {
            profileCreatorDialog.addCreateProfileButtonListener(new CreateProfileButtonListener());
            profileCreatorDialog.addVerifyPasswordFieldFocusListener(new VerifyPasswordFieldFocusListener());
            profileCreatorDialog.hidePasswordMismatchLabel();
            profileCreatorDialog.setVisible(true);
        }
    }

    public ProfileEntry getProfileEntry() {
        return profileCreated;
    }

    class VerifyPasswordFieldFocusListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (!profileCreatorDialog.getPassword().equals(profileCreatorDialog.getVerifiedPassword())) {
                profileCreatorDialog.showPasswordMismatchLabel();
            }
            else {
                profileCreatorDialog.hidePasswordMismatchLabel();
            }
        }
    }

    class CreateProfileButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) { //Add the profile to the list of profiles
//            System.out.println("Create button pressed.");

            if (!profileCreatorDialog.getPassword().equals(profileCreatorDialog.getVerifiedPassword())) {
                //FIXME: Same as in LoginDialogController, why does it shrink the password field to the number of characters that were entered?
                profileCreatorDialog.showPasswordMismatchLabel();
            }
            else {
                profileCreated = new ProfileEntry(profileDatabase.getNumProfiles(), profileCreatorDialog.getUserName(), profileCreatorDialog.getPassword(), profileCreatorDialog.getEmail());
                profileDatabase.addNewProfile(profileDatabase.getNumProfiles(), profileCreatorDialog.getUserName(), profileCreatorDialog.getPassword(), profileCreatorDialog.getEmail());
//            System.out.println("num profiles = " + profileDatabase.getNumProfiles());

                profileCreatorDialog.dispose();
            }
        }
    }
}
