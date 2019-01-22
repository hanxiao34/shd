package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONObject;
import weibo4j.util.WeiboConfig;

public class QueryId {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String mid = args[1];
		Timeline tm = new Timeline(access_token);
		try {
			JSONObject id = tm.queryId( mid, 1,1);
			Log.logInfo(id.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
