package weibo4j.examples.place;

import weibo4j.Place;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Status;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class GetStatusesShow {
	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String id = args[1];
		Place p = new Place(access_token);
		try {
			Status s = p.statusesShow(id);
			Log.logInfo(s.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
