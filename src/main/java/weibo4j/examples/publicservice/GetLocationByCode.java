package weibo4j.examples.publicservice;

import weibo4j.PublicService;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;

public class GetLocationByCode {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String codes = args[1];
		PublicService ps = new PublicService(access_token);
		try {
			JSONArray jo = ps.getLocationByCode(codes);
			System.out.println(jo.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		
	}

}
