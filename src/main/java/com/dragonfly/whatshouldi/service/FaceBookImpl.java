package com.dragonfly.whatshouldi.service;

import facebook4j.*;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import facebook4j.internal.org.json.JSONObject;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FaceBookImpl {

    public List<String> retrieveFaceBookData() {
	ConfigurationBuilder confBuilder = new ConfigurationBuilder();
	confBuilder.setDebugEnabled(true);
	confBuilder.setOAuthAppId("583477562182097");
	confBuilder.setOAuthAppSecret("c7e8dfe06dd5366f1d35551a53365fa7");
	confBuilder.setOAuthAccessToken(
			"EAAISq3TUCdEBAI3vQpOWpVYQdSaSKZAktal12mwX9vSkPZBL3cNfmp9sTAGWdJQ6Tjfgyru1v8iwZBRjRwr63V3eqPwrCSQeygbvEra4SCXrfG9zXNTHAZApi4ZACNOp2ey6FMrCaS6hFW7XKeIvv37Y63ZCGEre2LE8Cxc6mKM2q0vzAXccmjtdFJVnH8rLnGBmKqw9RwZBofkodHWrrXhp3TL8UCd308ZD");

	//confBuilder.setOAuthAccessToken("EAAG3ZCS31zfYBAMkHbAuXzQtyvS4WRrNsMhGxoUuquECq6hCNcsyvsWKTZA24li3LGpgu6DmJHDBykhSHtgiTb3kJEVfmEwVUjisOJxowhV3rCfls8Q2zaZB4E1ZBHUFTqt4fzpz0jeUgAoY1B3FjdtD5UyvmrbHZCZCwpJMg5Rdc7DPZCCZAqfJH49SHLwN6UZCglZA7dUM2kKwZDZD");
	// Set permission
	confBuilder.setOAuthPermissions("email,publish_stream, id, name, first_name, last_name, generic");
	confBuilder.setUseSSL(true);
	confBuilder.setJSONStoreEnabled(true);
	List<String> results = null;
	// Create facebook instance
	Configuration configuration = confBuilder.build();
	FacebookFactory ff = new FacebookFactory(configuration);
	Facebook facebook = ff.getInstance();

	try {
	    results = getFacebookPostes(facebook);

	} catch (Exception e) {

	    e.printStackTrace();
	}
	return results;
    }

    private List<String> getFacebookPostes(Facebook facebook) throws FacebookException {
	ResponseList<Like> results = facebook.getUserLikes();
	List<String> likes = new ArrayList<>();
	System.out.println("facebook Account :: " + facebook.getAccounts());

	for (Like like : results) {
	    likes.add(like.getName());
	    System.out.println("Name of the Likes  ::" + like.getName());

	}

	System.out.println(JSONObject.getNames(results.toString()));
	//stringToJson(results.toString());
	return likes;
    }

    public static void main(String[] args) {
	FaceBookImpl faceBook = new FaceBookImpl();
	faceBook.retrieveFaceBookData();

    }

}
