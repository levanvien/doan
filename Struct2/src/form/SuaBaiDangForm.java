package form;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import common.StringProcess;
import model.bean.BaiDang;
import model.bean.Images;

public class SuaBaiDangForm extends ActionForm {
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

}
