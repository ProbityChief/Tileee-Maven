package fr.dawan.tileee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.dawan.tileee.bean.Tags;

public class TagsDAO {
	public static ArrayList<String> findTags(Connection cnx, boolean CloseConnection) {
		ArrayList<String> tagsList = new ArrayList<>();
		PreparedStatement st;
		try {
			st = cnx.prepareStatement("SELECT tag1, tag2, tag3, tag4, tag5 from cards;");
			ResultSet res = st.executeQuery();
			while (res.next()) {
				if ("null".equals(res.getString("tag1")) || tagsList.contains(res.getString("tag1"))) {
					continue;
				}
				else {
					tagsList.add(res.getString("tag1"));
					System.out.println("ajout d'un tag");
				}
				if ("null".equals(res.getString("tag2")) || !tagsList.contains(res.getString("tag2"))) {
					continue;
				}
				else {
					tagsList.add(res.getString("tag2"));
					System.out.println("ajout d'un tag");
				}
				if ("null".equals(res.getString("tag3")) || !tagsList.contains(res.getString("tag3"))) {
					continue;
				}
				else {
					tagsList.add(res.getString("tag3"));
					System.out.println("ajout d'un tag");
				}
				if ("null".equals(res.getString("tag4")) || !tagsList.contains(res.getString("tag4"))) {
					continue;
				}
				else {
					tagsList.add(res.getString("tag4"));
					System.out.println("ajout d'un tag");
				}
				if ("null".equals(res.getString("tag5")) || !tagsList.contains(res.getString("tag5"))) {
					continue;
				}
				else {
					tagsList.add(res.getString("tag5"));
					System.out.println("ajout d'un tag");
				}
			}
			if (CloseConnection) {
				cnx.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tagsList;
	}
}
