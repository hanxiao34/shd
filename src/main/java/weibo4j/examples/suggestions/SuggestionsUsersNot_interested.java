package weibo4j.examples.suggestions;

import weibo4j.Suggestion;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

public class SuggestionsUsersNot_interested {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String uid = weibo4j.util.WeiboConfig.getValue("uid");
		Suggestion suggestion = new Suggestion(access_token);
		try {
			User user = suggestion.suggestionsUsersNotInterested(uid);
			System.out.println(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
