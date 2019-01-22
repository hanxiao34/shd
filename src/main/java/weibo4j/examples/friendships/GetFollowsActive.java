package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

public class GetFollowsActive {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String uid = weibo4j.util.WeiboConfig.getValue("uid");
		Friendships fm = new Friendships(access_token);
		try {
			UserWapper users = fm.getFollowersActive(uid);
			for(User u : users.getUsers()){
				Log.logInfo(u.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
