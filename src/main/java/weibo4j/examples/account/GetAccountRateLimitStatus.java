package weibo4j.examples.account;

import weibo4j.Account;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.RateLimitStatus;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

public class GetAccountRateLimitStatus {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		Account am = new Account(access_token);
		try {
            RateLimitStatus json = am.getAccountRateLimitStatus();
			Log.logInfo(json.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
