package wx.xt.service;

import java.util.Set;

import configuration.Tool;

public class MyTool {

	/**
	 * 将"x,xx,xxx"的字符串化为String[]集合后，与 Set<String>集中的字符比较，如果同样，侧过滤出去。然后将过滤后的结果返回。
	 * <br/>
	 * 主要作用于权限
	 * @param resources 源
	 * @param reject 过滤的字符集合
	 * @return String
	 */
	public static String toRejectStr(String resources, Set<String> reject) {
		if (Tool.isEmpty(resources) || reject.isEmpty()) {
			return resources;
		}
		StringBuilder sb = new StringBuilder();
		for (String str : resources.split(",")) {
			if (!reject.contains(str)) {
				sb.append(",").append(str);
			}
		}
		return sb.length() > 0 ? sb.substring(1) : "";
	}
}
