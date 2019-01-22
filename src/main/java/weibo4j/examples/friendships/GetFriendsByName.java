package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class GetFriendsByName {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String name = args[1];
		Friendships fm = new Friendships(access_token);
		try {
			UserWapper users = fm.getFriendsByScreenName(name);
			for(User u : users.getUsers()){
				System.out.println(u.toString());
			}
			System.out.println(users.getNextCursor());
			System.out.println(users.getPreviousCursor());
			System.out.println(users.getTotalNumber());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
