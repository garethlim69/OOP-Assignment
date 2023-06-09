/*
This LoginInfo Class is used to store Users' Usernames and Passwords
---- The users information (username and password) are stored in HashMap
 */

package UserData;

import java.util.HashMap;

public class LoginInfo {
    // Declare the HashMap
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    // Method to insert new username and password into the HashMap when the user
    // registers himself into the app
    public void putToMap(String username, String password) {
        loginInfo.put(username, password);
    }

    // To return the username and password
    public HashMap getLoginInfo() {
        return loginInfo;
    }
}