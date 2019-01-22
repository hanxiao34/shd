package weibo4j.examples.friendships;

import weibo4j.Friendships;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;

public class GetRemark {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String uids = args[1];
		Friendships fm = new Friendships(access_token);
		try {
			JSONArray user = fm.getRemark(uids);
			System.out.println(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
