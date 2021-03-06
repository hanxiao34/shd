package weibo4j.examples.trends;

import weibo4j.Trend;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;

public class IsFollow {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String trend_name = args[1];
		Trend tm = new Trend(access_token);
		try {
			JSONObject result = tm.isFollow(trend_name);
			Log.logInfo(String.valueOf(result));
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
