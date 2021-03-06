package weibo4j.examples.favorites;

import java.util.List;

import weibo4j.Favorite;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.FavoritesIds;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class GetFavoritesIds {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		Favorite fm = new Favorite(access_token);
		try {
			List<FavoritesIds> ids = fm.getFavoritesIds();
			for(FavoritesIds s : ids){
				Log.logInfo(s.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}

	}

}
