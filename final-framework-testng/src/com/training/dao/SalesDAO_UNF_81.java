package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.SalesBean_UNF_81;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class SalesDAO_UNF_81 {

	Properties properties;

	public SalesDAO_UNF_81() {
		try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<SalesBean_UNF_81> getReturns() {
		String sql = properties.getProperty("get.sales");

		GetConnection gc = new GetConnection();
		List<SalesBean_UNF_81> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql);
			list = new ArrayList<SalesBean_UNF_81>();

			gc.rs1 = gc.ps1.executeQuery();

			while (gc.rs1.next()) {

				SalesBean_UNF_81 temp = new SalesBean_UNF_81();
				temp.setOrderId(gc.rs1.getString(1));
				temp.setCustomer(gc.rs1.getString(2));
				temp.setFirstName(gc.rs1.getString(3));
				temp.setLastName(gc.rs1.getString(4));
				temp.setEmailId(gc.rs1.getString(5));
				temp.setPhone(gc.rs1.getString(6));
				temp.setProduct(gc.rs1.getString(7));
				temp.setModel(gc.rs1.getString(8));
				list.add(temp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		new SalesDAO_UNF_81().getReturns().forEach(System.out::println);
	}

}
