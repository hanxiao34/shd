package weibo4j.examples.location;

import java.util.List;

import weibo4j.Location;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Poisition;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class SearchPoisByLocation {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String q = args[1];
		Location l = new Location(access_token);
		try {
			List<Poisition> list = l.searchPoisByLocationByQ(q);
			for (Poisition p : list) {
				Log.logInfo(p.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
