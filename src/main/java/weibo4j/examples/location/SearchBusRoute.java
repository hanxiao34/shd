package weibo4j.examples.location;

import weibo4j.Location;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class SearchBusRoute {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String beginCoordinate = args[1];
		String endCoordinate = args[2];
		Location l = new Location(access_token);
		try {
			JSONObject json = l.searchBusRouteByCoordinate(
					beginCoordinate, endCoordinate);
			Log.logInfo(json.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
