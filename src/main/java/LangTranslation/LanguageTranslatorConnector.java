package LangTranslation;

import java.util.Map;
import java.text.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LanguageTranslatorConnector {

    private String username;
	private String password;

    public LanguageTranslatorConnector() {
        setCredentials();
    }

    private void setCredentials() {
        Map<String, String> env = System.getenv();

        if (env.containsKey("VCAP_SERVICES")) {

            try {
                JSONParser parser = new JSONParser();
                JSONObject vcap = (JSONObject) parser.parse(env.get("VCAP_SERVICES"));
                JSONObject service = null;

                for (Object key : vcap.keySet()) {
                    String keyStr = (String) key;
                    if (keyStr.toLowerCase().contains("language_translation")) {
                        service = (JSONObject) ((JSONArray) vcap.get(keyStr)).get(0);
                        break;
                    }
                }

                if (service != null) {
                    JSONObject creds = (JSONObject) service.get("credentials");
                    String username = (String) creds.get("username");
					String password = (String) creds.get("password");
                    this.username = username;
					this.password = password;
                }
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
        }
    }

    public String getUsername() {
        return username;
    }

	public String getPassword() {
        return password;
    }
}