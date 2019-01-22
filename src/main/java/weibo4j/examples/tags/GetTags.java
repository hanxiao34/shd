package weibo4j.examples.tags;

import java.util.List;

import weibo4j.Tags;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Tag;
import weibo4j.model.WeiboException;

public class GetTags {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		String uid = weibo4j.util.WeiboConfig.getValue("uid");
		Tags tm  = new Tags(access_token);
		try {
			List<Tag> tags = tm.getTags(uid);
			for(Tag tag:tags ){				
				Log.logInfo(tag.toString());
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
