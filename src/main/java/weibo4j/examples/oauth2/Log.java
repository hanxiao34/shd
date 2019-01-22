package weibo4j.examples.oauth2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
	
	static Logger log = LoggerFactory.getLogger(Log.class);
	
    public static void logDebug(String message) {
			log.debug(message);
	}

	public static void logInfo(String message) {
			log.info(message);
	}


}
