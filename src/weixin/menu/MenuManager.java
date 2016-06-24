/**
 * 包打听全知道-微信H5版本
 * weixin.menu
 * MenuManager.java
 * Ver0.0.1
 * 2016年6月20日-下午4:21:55
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.menu;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIConfig;
import weixin.base.AccessTokenManager;
import weixin.util.HttpsDataManager;

/**
 * 
 * MenuManager
 * 
 * 李华栋
 * 李华栋
 * 2016年6月20日 下午4:21:55
 * 
 * @version 0.0.1
 * 
 */
public class MenuManager {

	/**
	 * 
	 * createMenu(自定义菜单创建接口)
	 *1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
	 *2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
	 *3、创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，
	 *如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。
	 *测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
	 * @param jsonStr
	 * @return 
	 *boolean
	 * @exception 
	 * @since  0.0.1
	 */
	public boolean createMenu(String jsonStr){
		
		boolean success = false;
		
		//调用自定义菜单创建接口
	    String url = APIConfig.CREATE_MENU+AccessTokenManager.accesstoken;
	    String response = HttpsDataManager.sendData(url, jsonStr);
	    
	    //解析对应的JSON代码
	    try{
	    	JSONObject responseJson  = new JSONObject(response);
	    	if(responseJson.getString("errmsg").equals("ok"))
	    		success = true;
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
	    return success;
	}
	
	/**
	 * 
	 * getMenu(自定义菜单查询接口)
	 * (这里描述这个方法适用条件 – 可选)
	 * @return 
	 *String
	 * @throws JSONException 
	 * @exception 
	 * @since  0.0.1
	 */
	public JSONObject getMenu() throws JSONException{
		
		String response = null;
		
		//调用自定义菜单查询接口
		String url = APIConfig.GET_MENU+AccessTokenManager.accesstoken;
		response = HttpsDataManager.sendData(url);
		
		return new JSONObject(response);
	}
	
	/**
	 * 
	 * deleteMenu(自定义菜单删除接口)
	 * (这里描述这个方法适用条件 – 可选)
	 * @return 
	 *boolean
	 * @exception 
	 * @since  0.0.1
	 */
	public boolean deleteMenu(){
		
		boolean success = false;
		
		//调用自定义菜单删除接口
		String url = APIConfig.DELETE_MENU+AccessTokenManager.accesstoken;
		String response = HttpsDataManager.sendData(url);//!!!HttpsDataManager需要有GET的请求方式
		
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson  = new JSONObject(response);
	    	if(responseJson.getString("errmsg").equals("ok"))
	    		success = true;
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
		return success;
	}
	
	/**
	 * main(这里用一句话描述这个方法的作用)
	 * (这里描述这个方法适用条件 – 可选)
	 * @param args 
	 *void
	 * @exception 
	 * @since  0.0.1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
