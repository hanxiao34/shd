package weibo4j.examples.place;

import weibo4j.Place;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Places;
import weibo4j.model.WeiboException;

public class GetPoisShow {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String poiid = args[1];
		Place p = new Place(access_token);
		try {
			Places pl = p.poisShow(poiid);
			Log.logInfo(pl.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
