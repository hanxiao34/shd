package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.RepostTimelineIds;
import weibo4j.model.WeiboException;

public class GetRepostTimelineIds {
	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String id = args[1];
		Timeline tm = new Timeline(access_token);
		try {
			RepostTimelineIds ids = tm.getRepostTimelineIds(id);
			Log.logInfo(ids.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
