package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.StatusWapper;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class GetUserTimeline {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		Timeline tm = new Timeline(access_token);
		try {
			StatusWapper status = tm.getUserTimeline();
			Log.logInfo(status.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
