package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.BaiDang;
import utils.MyException;

public class BaiDangDAO {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=QLRVDT";
	String userName = "sa";
	String password = "12345678";
	Connection connection;

	void connect() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Ket noi loi");
		}
	}

	// dug dua id getlistbd(1)
	public BaiDang getThongTinBaiDang(int id_account) {
		connect();
		String sql = "select distinct * from POST inner join IMAGES on POST.id_post = IMAGES.id_post where id_account= '"
				+ id_account + "'";

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		BaiDang baiDang = new BaiDang();
		try {
			while (rs.next()) {
				baiDang.setId_post(rs.getInt("id_post"));
				baiDang.setId_account(rs.getInt("id_account"));
				baiDang.setTitle_post(rs.getString("title_post"));
				baiDang.setContent_post(rs.getString("content_post"));

				baiDang.setType_post(rs.getString("type_post"));
				baiDang.setPercent_product(rs.getInt("percent_product"));

				baiDang.setCost(rs.getInt("cost"));
				baiDang.setDate(rs.getDate("date_post"));
				baiDang.setDate_up(rs.getDate("dateup"));
				baiDang.setType_product(rs.getString("type_product"));

				baiDang.setAddress_product(rs.getString("address_product"));
				baiDang.setView_post(rs.getInt("view_post"));
				baiDang.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return baiDang;
	}

	public ArrayList<BaiDang> getListBaiDang(int id_account) {
		connect();
		/*
		 * String sql =
		 * "select POST.id_post,id_account,title_post,content_post,percent_product,cost,dateup,date,view_post, address_product,type_product,type_post,img.address"
		 * + "from POST inner join IMAGES img on POST.id_post = img.id_post";
		 */

		String sql = "select * from POST where id_account= '" + id_account + "'";

		/*
		 * String sql =
		 * "select distinct * from POST inner join IMAGES on POST.id_post = IMAGES.id_post where id_account= '"
		 * + id_account + "'";
		 */
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			/* e.printStackTrace(); */

			System.out.println("cau lenh sql bi sai");
		}

		ArrayList<BaiDang> list = new ArrayList<BaiDang>();
		BaiDang baiDang;
		try {
			while (rs.next()) {

				/*
				 * baiDang = new BaiDang(); baiDang.setMsv(rs.getString("msv"));
				 * baiDang.setHoTen(rs.getString("HoTen"));
				 * baiDang.setGioiTinh(rs.getString("GioiTinh"));
				 * baiDang.setTenKhoa(rs.getString("TenKhoa"));
				 * baiDang.setDiaChi(rs.getString("DiaChi"));
				 * list.add(sinhVien);
				 * 
				 */
				baiDang = new BaiDang();
				baiDang.setId_post(rs.getInt("id_post"));
				baiDang.setId_account(rs.getInt("id_account"));
				baiDang.setTitle_post(rs.getString("title_post"));
				baiDang.setContent_post(rs.getString("content_post"));

				baiDang.setType_post(rs.getString("type_post"));
				baiDang.setPercent_product(rs.getInt("percent_product"));

				baiDang.setCost(rs.getInt("cost"));
				baiDang.setDate(rs.getDate("date_post"));
				baiDang.setDate_up(rs.getDate("dateup"));
				baiDang.setType_product(rs.getString("type_product"));

				baiDang.setAddress_product(rs.getString("address_product"));
				baiDang.setView_post(rs.getInt("view_post"));
				// baiDang.setAddress(rs.getString("address"));

				list.add(baiDang);

			}
		} catch (SQLException e) {
			/* e.printStackTrace(); */

			System.out.println("duyet du lieu bi sai");
		}
		return list;
	}

	public void deleteBaiDang(int id_post) {
		connect();
		String sql = String.format("DELETE FROM Comment WHERE id_post = %s", id_post);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cau lenh sai roi");

		}
		String sql1 = String.format("DELETE FROM like WHERE id_post = %s", id_post);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql1);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cau lenh sai roi1");

		}
		String sql2 = String.format("DELETE FROM images WHERE id_post = %s", id_post);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql2);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cau lenh sai roi2");

		}
		sql = String.format("DELETE FROM POST WHERE id_post = %s", id_post);
		System.out.println(sql);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cau lenh sai roi3");

		}

	}

	/*
	 * public void themBaiDang(int id_account, String title_post, String
	 * content_post, String type_product, int percent_product, int cost, String
	 * address_product, String type_post) {
	 * 
	 * String ngayPost = StringProcess.getDate(); String ngayUpTop =
	 * StringProcess.getDate(); connect(); String sql =
	 * "INSERT INTO POST(id_account ,title_post,content_post,type_product,percent_product,cost,date_post,address_product,dateup,type_post,view_post,accept,limit) VALUES"
	 * + "(5,'" + title_post + "','" + content_post + "','" + type_product +
	 * "'," + percent_product + "," + cost + ",'" + ngayPost + "','" +
	 * address_product + "','" + ngayUpTop + "','" + type_post +
	 * "',0,'active',30)";
	 * 
	 * try { Statement stmt = connection.createStatement();
	 * stmt.executeUpdate(sql); } catch (SQLException e) { e.printStackTrace();
	 * System.out.println("sql sai roi");
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * public static void main(String[] args) { BaiDangDAO k = new BaiDangDAO();
	 * if (k.themBaiDang(2, "tieu de", "noi dung", "abc", 22, 2000, "da nang",
	 * "vn")) System.out.println("---ok---"); else
	 * System.out.println("----loi--");
	 * 
	 * }
	 */

	public ArrayList<BaiDang> getListBaiDangTimKiem(String sTimKiem) {

		connect();
		String sql = "select * from POST join images on POST.id_post=IMAGES.id_post where  id_account=7 and contains (content_post,'%"
				+ sTimKiem + "%') or contains (title_post,'%" + sTimKiem + "%')   ";

		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			/* e.printStackTrace(); */

			System.out.println("cau lenh sql bi sai");
		}

		ArrayList<BaiDang> list = new ArrayList<BaiDang>();
		BaiDang baiDang;
		try {
			while (rs.next()) {

				/*
				 * baiDang = new BaiDang(); baiDang.setMsv(rs.getString("msv"));
				 * baiDang.setHoTen(rs.getString("HoTen"));
				 * baiDang.setGioiTinh(rs.getString("GioiTinh"));
				 * baiDang.setTenKhoa(rs.getString("TenKhoa"));
				 * baiDang.setDiaChi(rs.getString("DiaChi"));
				 * list.add(sinhVien);
				 * 
				 */
				baiDang = new BaiDang();
				baiDang.setId_post(rs.getInt("id_post"));
				baiDang.setId_account(rs.getInt("id_account"));
				baiDang.setTitle_post(rs.getString("title_post"));
				baiDang.setContent_post(rs.getString("content_post"));

				baiDang.setType_post(rs.getString("type_post"));
				baiDang.setPercent_product(rs.getInt("percent_product"));

				baiDang.setCost(rs.getInt("cost"));
				baiDang.setDate(rs.getDate("date_post"));
				baiDang.setDate_up(rs.getDate("dateup"));
				baiDang.setType_product(rs.getString("type_product"));

				baiDang.setAddress_product(rs.getString("address_product"));
				baiDang.setView_post(rs.getInt("view_post"));
				baiDang.setAddress(rs.getString("address"));

				list.add(baiDang);

			}
		} catch (SQLException e) {
			/* e.printStackTrace(); */

			System.out.println("duyet du lieu bi sai");
		}
		return list;
	}

	public void suaBaiDang(String title_post, String content_post, String type_product, int percent_product, int cost,
			String address_product, String type_post) {
		connect();
		String sql = String.format(
				"UPDATE SinhVien "
						+ " SET title_post = N'%s', content_post = '%s', type_product = '%s', percent_product = %s,cost = %s,address_product = '%s',type_post = '%s'"
						+ " WHERE id_post = %s",
				title_post, content_post, type_product, percent_product, cost, address_product, type_post);
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("cau lenh sai roi");
		}
	}

	public boolean createPost(int id_account, String title_post, String content_post, String type_product,
			String percent_product, String cost, String date_post, String address_product, String dateup,
			String type_post, int view_post, String accept, int limit) {

		connect();
		String sql = "INSERT INTO POST(id_account,title_post,content_post,type_product,percent_product,cost,date_post,address_product,dateup,type_post,view_post,accept,limit)"
				+ " VALUES(" + id_account + ",N'" + title_post + "',N'" + content_post + "',N'" + type_product + "',"
				+ percent_product + "," + cost + ",'" + date_post + "',N'" + address_product + "','" + dateup + "',N'"
				+ type_post + "'," + view_post + ",N'" + accept + "'," + limit + ")";

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql sai roi");
			return false;
		}
		return true;

		/*
		 * if (DataAccess.truyVan(
		 * "INSERT INTO POST(id_account,title_post,content_post,type_product,percent_product,cost,date_post,address_product,dateup,type_post,view_post,accept,limit)"
		 * + " VALUES(" + id_account + ",N'" + title_post + "',N'" +
		 * content_post + "',N'" + type_product + "'," + percent_product + "," +
		 * cost + ",'" + date_post + "',N'" + address_product + "','" + dateup +
		 * "',N'" + type_post + "'," + view_post + ",N'" + accept + "'," + limit
		 * + ")")) return true; else return false;
		 */
	}

	public int getIdPostCreate(int id_account, String title_post, String content_post, String type_product,
			String percent_product, String cost, String date_post, String address_product, String dateup,
			String type_post, int view_post, String accept, int limit) throws MyException, SQLException {

		connect();
		String sql = "SELECT id_post FROM POST WHERE id_account=" + id_account + " AND title_post=N'" + title_post
				+ "'AND content_post=N'" + content_post + "' AND type_product=N'" + type_product
				+ "' AND percent_product=" + percent_product + " AND cost=" + cost + " AND date_post='" + date_post
				+ "' AND address_product=N'" + address_product + "' AND dateup='" + dateup + "' AND type_post=N'"
				+ type_post + "' AND view_post=" + view_post + " AND accept=N'" + accept + "' AND limit=" + limit + "";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		try {
			while (rs.next()) {
				return rs.getInt("id_post");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	public boolean createImages(int id_post, String address) {
		connect();

		String sql = "INSERT INTO IMAGES(id_post,address) VALUES(" + id_post + ",N'" + address + "')";
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql sai roi");
			return false;
		}
		return true;
	}

}
