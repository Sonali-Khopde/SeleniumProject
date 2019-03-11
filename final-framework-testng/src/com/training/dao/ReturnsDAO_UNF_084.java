package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.ReturnsBean_UNF_084;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ReturnsDAO_UNF_084 {

	Properties properties;

	public ReturnsDAO_UNF_084() {
		try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<ReturnsBean_UNF_084> getReturns() {
		String sql = properties.getProperty("get.returns");

		GetConnection gc = new GetConnection();
		List<ReturnsBean_UNF_084> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql);
			list = new ArrayList<ReturnsBean_UNF_084>();

			gc.rs1 = gc.ps1.executeQuery();

			while (gc.rs1.next()) {

				ReturnsBean_UNF_084 temp = new ReturnsBean_UNF_084();
				temp.setPdtName(gc.rs1.getString(1));
				temp.setMetaTitle(gc.rs1.getString(2));
				temp.setModel(gc.rs1.getString(3));
				temp.setPrice(gc.rs1.getString(4));
				temp.setQty(gc.rs1.getString(5));
				temp.setCategory(gc.rs1.getString(6));

				list.add(temp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		new ReturnsDAO_UNF_084().getReturns().forEach(System.out::println);
	}

}
