/**
 * 包打听全知道-微信H5版本
 * weixin.msg
 * ResponseTptMsg.java
 * Ver0.0.1
 * 2016年6月20日-下午2:58:36
 *  2016全智道(北京)科技有限公司-版权所有
 * 
 */
package weixin.msg;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import weixin.base.AccessTokenManager;
import weixin.msg.model.tpt.TemplateMsg;
import weixin.util.HttpsDataManager;


/**
 * 
 * ResponseTptMsg
 * 
 * 返回的为JSON
 * 同时会再进行事件消息的推送
 * 
 * 李华栋
 * 2016年6月20日 下午2:58:36
 * 
 * @version 0.0.1
 * 
 */
public class ResponseTptMsg {
	
	/**
	 * 发送设置所属行业消息
	 * @param industry1	公众号模板消息所属行业1编号
	 * @param industry2	公众号模板消息所属行业2编号
	 * @return String	json格式的数据
	 */
	public String setIndustry(int industry1, int industry2){
		
		String returnStr = "";
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("industry_id1", industry1+"");
			rootJson.put("industry_id2", industry2+"");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
	}
	
	/**
	 * 发送模板消息
	 * @param template	发送的模板
	 * @return String	json格式的数据
	 */
	public String template(TemplateMsg template){
		
		String returnStr = "";
		
		//填充回复内容
		JSONObject rootJson = new JSONObject();
		try {
			rootJson.put("touser", template.getTouser());
			rootJson.put("template_id", template.getTemplate_id());
			rootJson.put("url", template.getUrl());
		
			//填充模板信息
			JSONObject subJson = new JSONObject();
			JSONObject tJson = null;
			List<String> labels = template.getLabels();
			List<String> values = template.getValues();
			List<String> colors = template.getColors();
			for(int i=0;i<values.size();i++){
				tJson = new JSONObject();
				tJson.put("value", values.get(i));
				tJson.put("color", colors.get(i));
				subJson.put(labels.get(i), tJson);
			}
			rootJson.put("data", subJson);
		} catch (JSONException e) {
			e.printStackTrace();
		}
			
		//转换为json格式字符串
		returnStr = rootJson.toString();
		return returnStr;
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
//		String touser = "oFHIYt2guBTMngMiwFCAQdpOlu5k";
//		
//        //1、构造TptMsg对象
//		TemplateMsg  tptMsg  = new TemplateMsg();
//		List<String> labels = new ArrayList<String>();
//		labels.add("first");
//		labels.add("keyword1");
//		labels.add("keyword2");
//		labels.add("keyword3");
//		labels.add("remark");
//		List<String> values = new ArrayList<String>();
//		values.add("哈罗");
//		values.add("一只兔子");
//		values.add("onerabbit");
//		values.add("1");
//		values.add("特别可爱！");
//		List<String> colors = new ArrayList<String>();
//		colors.add("#173177");
//		colors.add("#173177");
//		colors.add("#173177");
//		colors.add("#173177");
//		colors.add("#173177");
//		tptMsg.setTouser(touser);
//		tptMsg.setTemplate_id("d-mBLWd0YQOE_YLC2NLvPUdgK9S73riOsnW7oe-nq9w");
//		tptMsg.setLabels(labels);
//		tptMsg.setValues(values);
//		tptMsg.setColors(colors);
//		tptMsg.setUrl("http://www.playhudong.com/");
//        
//		//2、获取accesstoken
//		AccessTokenManager  atm  = new AccessTokenManager();
//		AccessTokenManager.accesstoken = "rmUP0HoreLT1RSONogEM4Vkir_8G0jVtABf36gwkxbS_LWoOXfd_Weu44T-ErhC5mDc7PmsbxhkPyJXv60vWDA99aOFP4gCnzvTvUyT1CbQXXMfAAAMMB";
//        
//		//3、触发模版消息
//		ResponseTptMsg  rts  = new ResponseTptMsg();
//		String res = rts.template(tptMsg);
//		System.out.println(res);
//		Response resp = new Response();
//		System.out.println(resp.sendTptMsg(res));
		
//-----------------------------------------------------------------------------
//		获取模板列表
//		String response = HttpsDataManager.sendData("https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token="+AccessTokenManager.accesstoken);
//		System.out.println(response);
		
	}

}
