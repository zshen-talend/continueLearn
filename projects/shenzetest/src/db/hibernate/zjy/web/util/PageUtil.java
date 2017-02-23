package db.hibernate.zjy.web.util;

import javax.servlet.http.HttpServletRequest;

public class PageUtil {
	public int getPageId(HttpServletRequest httpServletRequestParam) {
		int pageId;
		try {
			String pagestr = httpServletRequestParam.getParameter("pageId");
			pageId = java.lang.Integer.parseInt(pagestr, 10);
		} catch (Exception e) {
			pageId = 1;
		}
		if (pageId < 1)
			pageId = 1;
		return pageId;
	}

	public String getPageInfor(int rowCount, int pageId, int pageSize,
			String path) {
		int pageCount = rowCount / pageSize
				+ (rowCount % pageSize == 0 ? 0 : 1);
		StringBuffer result = new StringBuffer();
		if (pageSize > 0) {
			result.append("共" + String.valueOf(rowCount));
			result.append("条记录，共" + String.valueOf(pageCount) + "页，");
			result.append("当前是第" + String.valueOf(pageId) + "页，      ");
			int istart, iend;
			istart = pageId - 5;
			if (istart < 0) {
				istart = 0;
			}
			iend = istart + 10;
			if (iend > pageCount) {
				iend = pageCount;
			}
			istart = iend - 10;
			if (istart < 0) {
				istart = 0;
			}
			for (int i = istart; i < iend; i++) {
				result.append("<a href='" + path + "?pageId=" + (i + 1) + " ");
				result.append("'>");
				result.append(String.valueOf(i + 1));
				result.append("</a>");
			}
		}
		return result.toString();
	}
}