package db.hibernate.zjy.web.util;


import org.apache.commons.beanutils.BeanUtils;

import db.hibernate.zjy.bean.Stuinfo;
import db.hibernate.zjy.struts.form.StuinfoForm;

public class ConvertUtil {
	public static Stuinfo convert(StuinfoForm stuinfoFormObject) {
		Stuinfo stuinfoParam = new Stuinfo();
		try {
			stuinfoParam = new Stuinfo();
			BeanUtils.copyProperties(stuinfoParam, stuinfoFormObject);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stuinfoParam;
	}

	public static StuinfoForm convert(Stuinfo stuinfoParam) {
		StuinfoForm stuinfoObject = new StuinfoForm();
		try {
			BeanUtils.copyProperties(stuinfoObject, stuinfoParam);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stuinfoObject;
	}
}