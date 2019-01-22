package weibo4j.examples.location;

import java.util.List;

import weibo4j.Location;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Geos;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class IpToGeo {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String ip = args[1];
		Location l = new Location(access_token);
		try {
			List<Geos> list = l.ipToGeo(ip);
			for (Geos g : list) {
				Log.logInfo(g.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
