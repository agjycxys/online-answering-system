package test;

import domain.Token;
import net.sf.json.JSONObject;
import util.WeiXinUtil;

public class Test_Access_token {
	public static void main(String[] args) {
		Token accessToken = WeiXinUtil.getAccessToken();
		System.out.println("access_token:"+accessToken.getAccessToken());
		System.out.println("expries_in:"+accessToken.getExpiresIn());
		String menu= JSONObject.fromObject(WeiXinUtil.initMenu()).toString();
	    System.out.println(menu);
	    WeiXinUtil.deleteMenu(accessToken.getAccessToken());
	    int result = WeiXinUtil.createMenu(accessToken.getAccessToken(), menu);
        if(result==0)
        {
            System.out.println("创建菜单成功");
        }
        else{
            System.out.println("错误码："+result);
        }
    }
}
