/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    /**
 * This Class is used to get the list of status.
 */
package Twitter;

import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class ajouterTweet {
	
	public String tweeter(String ch) {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
                cb.setDebugEnabled(true)
                .setOAuthConsumerKey("JFpW0Gry4Wwst4jRT8ViuFcHz")
                .setOAuthConsumerSecret("dre4sGP8yjqRil59yCfHMWzgGzvM47AbddudsNaLaTWtFSdN8u")
                .setOAuthAccessToken("4174408527-H22us84yvMouxO9PgHKxfSswamhzreT3VOeeMYS")
                .setOAuthAccessTokenSecret("u5vlzN32AUv6UPLiblqQzs8vsnasMp0oZpiEaeRfVXRdH");
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        
        twitter4j.Twitter tw =tf.getInstance();
        Status stat;
        try {
            stat = tw.updateStatus(ch);
            return "Tweet ajouté";
            //System.out.println("twitter updated");
        } catch (TwitterException ex) {
            ex.printStackTrace();
            return "Tweet non ajouté";
        }
    }
       
        }
	

