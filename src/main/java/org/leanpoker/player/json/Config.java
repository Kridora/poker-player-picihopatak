package org.leanpoker.player;
package org.leanpoker.player.json;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {
    
    public static void main(String[] args) {
        Config conf = new Config();
        JSONObject json = conf.readJsonFromUrl();
        System.out.println(json.toString());
        System.out.println(json.get("KEEP_POCKET_PAIRS"));
        
    }
		
	
    
    final URL url = new URL("http://owlab.hu/conf.txt");
    
    public static JSONObject readJsonFromUrl() throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          JSONObject json = new JSONObject(jsonText);
          return json;
        } finally {
          is.close();
        }
    }
        
    
}