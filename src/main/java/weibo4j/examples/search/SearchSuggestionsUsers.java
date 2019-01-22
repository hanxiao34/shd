package weibo4j.examples.search;

import weibo4j.Search;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;

public class SearchSuggestionsUsers {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String q = args[1];
		Search search = new Search(access_token);
		try {
			JSONArray jo = search.searchSuggestionsUsers(q);
			System.out.println(jo.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
