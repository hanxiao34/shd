package weibo4j.examples.comment;

import weibo4j.Comments;
import weibo4j.examples.oauth2.Log;
import weibo4j.model.Comment;
import weibo4j.model.CommentWapper;
import weibo4j.model.WeiboException;
import weibo4j.util.WeiboConfig;

import java.util.List;

public class GetCommentMentions {

	public static void main(String[] args) {
		String access_token = weibo4j.util.WeiboConfig.getValue("access_token");
		Comments cm = new Comments(access_token);
		try {
			CommentWapper comment = cm.getCommentMentions();
			List<Comment> comments = comment.getComments();
			for (Comment c :comments){
				Log.logInfo(c.toString());
			}
			Log.logInfo(comment.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}

}
