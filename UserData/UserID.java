/*
 This UserID Class is used to assign the user ID and store the user ID.
 -- ArrayList is used to store User ID
 -- This appliaction only allows 100 users (User ID from 1000-1100)
 -- When the user registers into this application, he will get a userID randomly
 */

package UserData;

import java.util.*;

public class UserID {
    ArrayList<Integer> IDcollection = new ArrayList<Integer>();
    Random random;
    String userID;

    public UserID() {
        // Use For loop to add 100 user ID into ArrayList
        for (Integer i = 1000; i <= 1100; i++) {
            IDcollection.add(i);
        }
    }

    // Method used to assign random user ID to the user who has registed himself
    public String getID() {
        // A user ID will be randomly assign to the current user
        random = new Random();
        random.setSeed(2000);
        int randomIndex = random.nextInt(IDcollection.size());
        userID = String.valueOf(IDcollection.get(randomIndex));

        return userID;
    }

}
