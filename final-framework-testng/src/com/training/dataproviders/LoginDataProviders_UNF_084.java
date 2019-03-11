package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.ReturnsBean_UNF_084;
import com.training.dao.ReturnsDAO_UNF_084;

public class LoginDataProviders_UNF_084 {

	@DataProvider(name = "db-inputs")
	public Object[][] getDBData() {

		List<ReturnsBean_UNF_084> list = new ReturnsDAO_UNF_084().getReturns();

		Object[][] result = new Object[list.size()][];
		int count = 0;
		for (ReturnsBean_UNF_084 temp : list) {
			Object[] obj = new Object[6];
			obj[0] = temp.getPdtName();
			obj[1] = temp.getMetaTitle();
			obj[2] = temp.getModel();
			obj[3] = temp.getPrice();
			obj[4] = temp.getQty();
			obj[5] = temp.getCategory();

			result[count++] = obj;
		}
		return result;
	}

}
