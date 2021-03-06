package data;

import org.testng.annotations.DataProvider;
import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserData {
        private Faker faker = new Faker();

    public Map<String, String> newUser() {
            Map<String, String> data = new HashMap<String, String>();
            data.put("emailAddress", faker.internet().emailAddress());
            data.put("password", faker.internet().password());
            return data;
        }

        public Map<String, String> newUser(Map<String, String> toMerge) {
            Map<String, String> data = new HashMap<String, String>();
            data.put("emailAddress", faker.internet().emailAddress());
            data.put("password", faker.internet().password());

            Set<String> keys = toMerge.keySet();
            for (String key : keys) {
                data.put(key, toMerge.get(key));
            }
            return data;
        }

        @DataProvider(name = "validUser")
        public static Object[][] valid() {
            return new Object[][] {{ "saucecon@example.com", "password" }};
        }
    }

