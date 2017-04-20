/*
 * This class is responsible for interacting with the Oxford-English dictionary API and handling 
 * server requests and responses from the user.
 */

import java.io.IOException;  
import java.io.InputStream;  
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class Definition extends Main {
	
	public static final String URL_SOURCE = "https://od-api.oxforddictionaries.com/api/v1/entries/en/";

	public static void main(String[] args) {
		
		String word = "apple";
		String query = URL_SOURCE + word.toLowerCase() + "/definition";
		
		query = query.replace(" ", "%20");	//replace blanks with HTML-equivalents
		
		try {
			URL urlObject = new URL(query);
			InputStream in = urlObject.openStream();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
