package form;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import common.StringProcess;
import model.bean.BaiDang;
import model.bean.Images;

public class ThemBDForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_post;
	private int id_account;
	private String title_post;
	private String content_post;
	private String type_product;
	private String percent_product;
	private String cost;
	private Date date;
	private String address_product;
	private Date date_up;
	private String type_post;
	private int view_post;
	private String accept;
	private int limit;
	private ArrayList<Images> listImages;
	private ArrayList<BaiDang> listBaiDang;
	private String submit;
	private String huy;
	private String file;

	protected ArrayList<FormFile> uploaded = new ArrayList<FormFile>();

	public void setUpload(List<FormFile> file) {
		uploaded.addAll(file);
	}

	public List<FormFile> getUpload() {
		return uploaded;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public String getHuy() {
		return huy;
	}

	public void setHuy(String huy) {
		this.huy = huy;
	}

	public ThemBDForm() {
		// TODO Auto-generated constructor stub
	}

	public ThemBDForm(int id_post, int id_account, String title_post, String content_post, String type_product,
			String percent_product, String cost, Date date, String address_product, Date date_up, String type_post,
			int view_post, String accept, int limit, ArrayList<Images> listImages, ArrayList<BaiDang> listBaiDang,
			String submit, String huy) {
		super();
		this.id_post = id_post;
		this.id_account = id_account;
		this.title_post = title_post;
		this.content_post = content_post;
		this.type_product = type_product;
		this.percent_product = percent_product;
		this.cost = cost;
		this.date = date;
		this.address_product = address_product;
		this.date_up = date_up;
		this.type_post = type_post;
		this.view_post = view_post;
		this.accept = accept;
		this.limit = limit;
		this.listImages = listImages;
		this.listBaiDang = listBaiDang;
		this.submit = submit;
		this.huy = huy;
	}

	public int getId_post() {
		return id_post;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

	public int getId_account() {
		return id_account;
	}

	public void setId_account(int id_account) {
		this.id_account = id_account;
	}

	public String getTitle_post() {
		return title_post;
	}

	public void setTitle_post(String title_post) {
		this.title_post = StringProcess.IsoToUtf8(title_post);
	}

	public String getContent_post() {
		return content_post;
	}

	public void setContent_post(String content_post) {
		this.content_post = content_post;
	}

	public String getType_product() {
		return type_product;
	}

	public void setType_product(String type_product) {
		this.type_product = type_product;
	}

	public String getPercent_product() {
		return percent_product;
	}

	public void setPercent_product(String percent_product) {
		this.percent_product = percent_product;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress_product() {
		return address_product;
	}

	public void setAddress_product(String address_product) {
		this.address_product = address_product;
	}

	public Date getDate_up() {
		return date_up;
	}

	public void setDate_up(Date date_up) {
		this.date_up = date_up;
	}

	public String getType_post() {
		return type_post;
	}

	public void setType_post(String type_post) {
		this.type_post = type_post;
	}

	public int getView_post() {
		return view_post;
	}

	public void setView_post(int view_post) {
		this.view_post = view_post;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public ArrayList<Images> getListImages() {
		return listImages;
	}

	public void setListImages(ArrayList<Images> listImages) {
		this.listImages = listImages;
	}

	public ArrayList<BaiDang> getListBaiDang() {
		return listBaiDang;
	}

	public void setListBaiDang(ArrayList<BaiDang> listBaiDang) {
		this.listBaiDang = listBaiDang;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		/*
		 * if (title_post != null || content_post != null || type_product !=
		 * null || cost != null) { ActionErrors errors2 =
		 * StringProcess.checkNewPost(id_account, title_post, content_post,
		 * type_product, percent_product, cost, address_product, type_post);
		 * errors.add(errors2); }
		 */

		if (getUpload() != null) {
			if (getUpload().size() <= 5) {
				for (int i = 0; i < getUpload().size(); i++) {
					FormFile image = getUpload().get(i);
					if (image.getFileSize() == 0) {
						errors.add("common.file.err", new ActionMessage("error.common.file.required"));
					}
					// only allow textfile to upload
					System.out.println(image.getContentType());
					if (!"image/jpeg".equals(image.getContentType())
							&& !"application/octet-stream".equals(image.getContentType())) {
						errors.add("common.file.err.ext", new ActionMessage("error.common.file.image.only"));
					}
					// file size cant larger than 10kb
					if (image.getFileSize() > 5120000) { // 10240=10kb
															// 5M=10240*100*5
						errors.add("common.file.err.size", new ActionMessage("error.common.file.size.limit", 5120000));
					}
				}
			} else if (getUpload().size() > 0) {
				errors.add("common.file.multiple", new ActionMessage("error.common.file.multiple"));
			}

		}
		return errors;
	}
}

// validate the Captcha to check we're not dealing with a bot

/* ActionErrors errors = new ActionErrors(); */
/*
 * if (getUpload() != null) { if (getUpload().size() <= 5) { for (int i = 0; i <
 * getUpload().size(); i++) { FormFile image = getUpload().get(i); if
 * (image.getFileSize() == 0) { errors.add("common.file.err", new
 * ActionMessage("error.common.file.required")); return errors; } // only allow
 * textfile to upload System.out.println(image.getContentType()); if
 * (!"image/jpeg".equals(image.getContentType())) {
 * errors.add("common.file.err.ext", new
 * ActionMessage("error.common.file.image.only")); return errors; } // file size
 * cant larger than 10kb if (image.getFileSize() > 5120000) { // 10240=10kb //
 * 5M=10240*100*5 errors.add("common.file.err.size", new
 * ActionMessage("error.common.file.size.limit", 5120000)); return errors; } } }
 * else { errors.add("common.file.multiple", new
 * ActionMessage("error.common.file.multiple")); return errors; } } return
 * errors; } }
 */