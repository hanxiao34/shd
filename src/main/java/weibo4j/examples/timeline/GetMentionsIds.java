package weibo4j.examples.timeline;

import weibo4j.Timeline;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.MentionsIds;
import weibo4j.model.WeiboException;

public class GetMentionsIds {
	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		Timeline tm = new Timeline(access_token);
		try {
			MentionsIds ids = tm.getMentionsIds();
			Log.logInfo(ids.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
