package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.SalesBean_UNF_81;
import com.training.dao.SalesDAO_UNF_81;

public class LoginDataProviders_UNF_81 {

	@DataProvider(name = "db-inputs_081")
	public Object[][] getDBData() {

		List<SalesBean_UNF_81> list = new SalesDAO_UNF_81().getReturns();

		Object[][] result = new Object[list.size()][];
		int count = 0;
		for (SalesBean_UNF_81 temp : list) {
			Object[] obj = new Object[8];
			obj[0] = temp.getOrderId();
			obj[1] = temp.getCustomer();
			obj[2] = temp.getFirstName();
			obj[3] = temp.getLastName();
			obj[4] = temp.getEmailId();
			obj[5] = temp.getPhone();
			obj[6] = temp.getProduct();
			obj[7] = temp.getModel();
			result[count++] = obj;
		}
		return result;
	}

}
