package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class CreateFriendships {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String uid = weibo4j.util.WeiboConfig.getValue("uid");
		Friendships fm = new Friendships(access_token);
		try {
			User user = fm.createFriendshipsById(uid);
			Log.logInfo(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
