package weibo4j.examples.suggestions;

import weibo4j.Suggestion;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;

public class SuggestionsUsersHot {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		Suggestion suggestion = new Suggestion(access_token);
		try {
			JSONArray jo = suggestion.suggestionsUsersHot();
			System.out.println(jo.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
