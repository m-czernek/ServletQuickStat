package cz.endhalf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marek on 02/07/2017.
 */
public class Database {
    public static final Map<String, String> db;
    static {
        db = new HashMap<String, String>()
        {{
            put("user1", "password");
        }};

    }

    public static boolean authenticate(Person user){
        if(db.containsKey(user.getUsername())){
            if(db.get(user.getUsername()).equals(user.getPassword())){
                user.setAuth(true);
                return true;
            }
        }
        return false;
    }
}
