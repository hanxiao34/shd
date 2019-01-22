package weibo4j.examples.trends;

import java.util.List;

import weibo4j.Trend;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.UserTrend;
import weibo4j.model.WeiboException;

public class GetTrends {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String uid = weibo4j.util.WeiboConfig.getValue("uid");
		Trend tm = new Trend(access_token);
		try {
			List<UserTrend> trends = tm.getTrends(uid);
			for(UserTrend t : trends){
				Log.logInfo(t.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
