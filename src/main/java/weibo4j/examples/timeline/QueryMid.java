package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;

public class QueryMid {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String id = args[1];
		Timeline tm = new Timeline(access_token);
		try {
			JSONObject mid = tm.queryMid(1, id);
			Log.logInfo(mid.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
