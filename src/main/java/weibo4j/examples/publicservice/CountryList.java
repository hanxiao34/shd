package weibo4j.examples.publicservice;

import weibo4j.PublicService;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.util.WeiboConfig;

public class CountryList {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		PublicService ps = new PublicService(access_token);
		try {
			JSONArray jo = ps.countryList();
			System.out.println(jo.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
	}

}
