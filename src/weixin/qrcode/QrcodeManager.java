/**
 * 包打听全知道-微信H5版本
 * weixin.qrcode
 * QrcodeManager.java
 * Ver0.0.1
 * 2016年6月27日-下午1:51:16
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.qrcode;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.APIConfig;
import weixin.base.AccessTokenManager;
import weixin.util.HttpsDataManager;

/**
 * 
 * QrcodeManager
 * 
 * 李华栋
 * 李华栋
 * 2016年6月27日 下午1:51:16
 * 
 * @version 0.0.1
 * 
 */
public class QrcodeManager {
	
	/**
	 * getTempQrcode(获取临时二维码ticket)
	 * @param expire, sceneId
	 * @return 
	 *Map
	 * @exception 
	 * @since  0.0.1
	 */
	public Map getTempQrcode(int expire, int sceneId){
		
		HashMap hm = new HashMap();
		
		//临时二维码有效时间最长为30天
		if(expire>2592000){
			expire = 2592000;
		}
		
		//填充请求内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("expire_seconds", expire);
			rootJson.put("action_name", "QR_SCENE");
			
			JSONObject scene_id = new JSONObject();
			scene_id.put("scene_id", sceneId);
			JSONObject scene = new JSONObject();
			scene.put("scene", scene_id);
			rootJson.put("action_info", scene);
		} catch (JSONException e) {
			e.printStackTrace();
		}		
				
		//调用创建标签接口
	    String url = APIConfig.QRCode_GET_URL+AccessTokenManager.accesstoken;
	    String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson = new JSONObject(response);
	    	hm.put("ticket", responseJson.getString("ticket"));
	    	hm.put("expire_seconds", responseJson.getInt("expire_seconds"));
	    	hm.put("url", responseJson.getString("url").replace("\\",""));
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
	    return hm;
	}
	
	/**
	 * getTempQrcode(获取临时二维码ticket)
	 * @param sceneId
	 * @return 
	 *Map
	 * @exception 
	 * @since  0.0.1
	 */
	public Map getTempQrcode(int sceneId){
		
		//临时二维码默认有效期为30秒
		return getTempQrcode(30, sceneId);
	}
	
	/**
	 * getPermQrcode(获取永久二维码ticket_指定字符串)
	 * @param sceneStr
	 * @return 
	 *Map
	 * @exception 
	 * @since  0.0.1
	 */
	public Map getPermQrcode(String sceneStr){
		
		HashMap<String, String> hm = new HashMap<String, String>();
				
		//填充请求内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("action_name", "QR_LIMIT_STR_SCENE");
			
			JSONObject scene_str = new JSONObject();
			scene_str.put("scene_str", sceneStr);
			JSONObject scene = new JSONObject();
			scene.put("scene", scene_str);
			rootJson.put("action_info", scene);
		} catch (JSONException e) {
			e.printStackTrace();
		}		
				
		//调用创建标签接口
	    String url = APIConfig.QRCode_GET_URL+AccessTokenManager.accesstoken;
	    String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson = new JSONObject(response);
	    	hm.put("ticket", responseJson.getString("ticket"));
	    	hm.put("url", responseJson.getString("url").replace("\\",""));
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
	    return hm;
	}
	
	/**
	 * getPermQrcode(获取永久二维码ticket_指定ID)
	 * @param sceneId
	 * @return 
	 *Map
	 * @exception 
	 * @since  0.0.1
	 */
	public Map getPermQrcode(int sceneId){
		
		HashMap<String, String> hm = new HashMap<String, String>();
				
		//填充请求内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("action_name", "QR_LIMIT_SCENE");
			
			JSONObject scene_id = new JSONObject();
			scene_id.put("scene_id", sceneId);
			JSONObject scene = new JSONObject();
			scene.put("scene", scene_id);
			rootJson.put("action_info", scene);
		} catch (JSONException e) {
			e.printStackTrace();
		}		
				
		//调用创建标签接口
	    String url = APIConfig.QRCode_GET_URL+AccessTokenManager.accesstoken;
	    String response = HttpsDataManager.sendData(url, rootJson.toString());
	    
		//解析对应的JSON代码
	    try{
	    	JSONObject responseJson = new JSONObject(response);
	    	hm.put("ticket", responseJson.getString("ticket"));
	    	hm.put("url", responseJson.getString("url").replace("\\",""));
	    } catch(JSONException e){
	    	System.out.println(response);
	    }
	    
	    return hm;
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
