package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.BaiDang;
import model.dao.BaiDangDAO;
import utils.MyException;

public class BaiDangBO {
	BaiDangDAO baiDangDAO = new BaiDangDAO();

	public ArrayList<BaiDang> getListBaiDang() {
		return baiDangDAO.getListBaiDang(7);
	}

	public BaiDang getThongTinBaiDang(int id_account) {
		return baiDangDAO.getThongTinBaiDang(7);
	}

	public void deleteBaiDang(int id_post) {
		baiDangDAO.deleteBaiDang(id_post);
	}

	public ArrayList<BaiDang> getListBaiDangTimKiem(String sTimKiem) {
		return baiDangDAO.getListBaiDangTimKiem(sTimKiem);
	}

	public void suaBaiDang(String title_post, String content_post, String type_product, int percent_product, int cost,
			String address_product, String type_post) {
		baiDangDAO.suaBaiDang(title_post, content_post, type_product, percent_product, cost, address_product,
				type_post);
	}
	/*
	 * public void themBaiDang(int id_account, String title_post, String
	 * content_post, String type_product, int percent_product, int cost, String
	 * address_product, String type_post) { baiDangDAO.themBaiDang(id_account,
	 * title_post, content_post, type_product, percent_product, cost,
	 * address_product, type_post); }
	 */

	public int createPost(int id_account, String title_post, String content_post, String type_product,
			String percent_product, String cost, String date_post, String address_product, String dateup,
			String type_post, int view_post, String accept, int limit) throws MyException, SQLException {
		boolean kq = baiDangDAO.createPost(id_account, title_post, content_post, type_product, percent_product, cost,
				date_post, address_product, dateup, type_post, view_post, accept, limit);
		if (kq) {
			return baiDangDAO.getIdPostCreate(id_account, title_post, content_post, type_product, percent_product, cost,
					date_post, address_product, dateup, type_post, view_post, accept, limit);

		} else
			return 0;
	}

	public int getidpost(int id_account, String title_post, String content_post, String type_product,
			String percent_product, String cost, String date_post, String address_product, String dateup,
			String type_post, int view_post, String accept, int limit) throws MyException, SQLException {
		return baiDangDAO.getIdPostCreate(id_account, title_post, content_post, type_product, percent_product, cost,
				date_post, address_product, dateup, type_post, view_post, accept, limit);
	}

	public boolean createImages(int id_post, String address) {
		return baiDangDAO.createImages(id_post, address);
	}
}
