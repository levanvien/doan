package action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import form.ThemBDForm;
import model.bo.BaiDangBO;
import utils.MyException;

public class ThemBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * ThemBDForm themBaiDangForm = (ThemBDForm) form; if (themBaiDangForm
		 * != null && themBaiDangForm.getPercent_product() != null) { int
		 * id_account = themBaiDangForm.getId_account();
		 * System.out.println("blooooo"); String title_post =
		 * themBaiDangForm.getTitle_post(); String content_post =
		 * themBaiDangForm.getContent_post(); String type_product =
		 * themBaiDangForm.getType_product(); int percent_product =
		 * Integer.parseInt(themBaiDangForm.getPercent_product()); int cost =
		 * Integer.parseInt(themBaiDangForm.getCost()); String address_product =
		 * themBaiDangForm.getAddress_product(); String type_post =
		 * themBaiDangForm.getType_post();
		 * System.out.println(themBaiDangForm.getId_account()); BaiDangBO
		 * themBaiDangBo = new BaiDangBO();
		 * themBaiDangBo.themBaiDang(id_account, title_post, content_post,
		 * type_product, percent_product, cost, address_product, type_post);
		 * System.out.println("aaaa" + themBaiDangBo.getListBaiDang());
		 * System.out.println("Tieu De" + title_post);
		 */
		ActionForward forward = new ActionForward();
		ActionErrors errors = new ActionErrors();
		BaiDangBO baiDangBo = new BaiDangBO();
		ThemBDForm formDTM = (ThemBDForm) form;

		if (formDTM.getId_account() != 0) {

			Date date = new Date();
			int id_post = 0;// Gia tri can lay ve khi dang bai
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if (formDTM.getType_post().trim().equals("VIP"))
					id_post = baiDangBo.createPost(formDTM.getId_account(), formDTM.getTitle_post(),
							formDTM.getContent_post(), formDTM.getType_product(), formDTM.getPercent_product(),
							formDTM.getCost(), simpleDateFormat.format(date), formDTM.getAddress_product(),
							simpleDateFormat.format(date), formDTM.getType_post(), 0, "FALSE", 90);
				else
					id_post = baiDangBo.createPost(formDTM.getId_account(), formDTM.getTitle_post(),
							formDTM.getContent_post(), formDTM.getType_product(), formDTM.getPercent_product(),
							formDTM.getCost(), simpleDateFormat.format(date), formDTM.getAddress_product(),
							simpleDateFormat.format(date), formDTM.getType_post(), 0, "FALSE", 30);
			} catch (MyException e) {
				System.out.println("Loi dang bai");
				errors.add("errorCreatePost", new ActionMessage("error.admin.create.post"));
				addErrors(request, errors);
			} catch (SQLException e) {
				e.printStackTrace();
				errors.add("errorCreatePost", new ActionMessage("error.admin.create.post"));
				addErrors(request, errors);
			}

			// Tao thu muc hien hanh
			String filePath = getServlet().getServletContext().getRealPath("/") + "images";
			// create the upload folder if not exists
			File folder = new File(filePath);
			if (!folder.exists()) {
				folder.mkdir();
			}

			// Tao thu muc theo id_post--> sap chep file vao thu muc
			if (id_post != 0) {
				String path = filePath + '\\' + id_post;
				System.out.println(path);
				File folderpost = new File(path);
				if (!folderpost.exists()) {
					folderpost.mkdir();
				}
				if (formDTM.getUpload() != null) {
					System.out.println(formDTM.getUpload().size());
					try {
						for (int i = 0; i < formDTM.getUpload().size(); i++) {
							FormFile images = formDTM.getUpload().get(i);
							String fileName = images.getFileName();
							if (!("").equals(fileName)) {
								File newFile = new File(path, fileName);
								if (!newFile.exists()) {
									FileOutputStream fos;
									fos = new FileOutputStream(newFile);
									fos.write(images.getFileData());
									fos.flush();
									fos.close();
								} else {
									newFile.delete();
									FileOutputStream fos = new FileOutputStream(newFile);
									fos.write(images.getFileData());
									fos.flush();
									fos.close();
								}
							}
							System.out.println("images\\" + id_post + "\\" + fileName);
							boolean kq = baiDangBo.createImages(id_post, "images\\" + id_post + "\\" + fileName);
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						errors.add("errorFile", new ActionMessage("error.admin.upload.file"));
						addErrors(request, errors);
					} catch (IOException e) {
						e.printStackTrace();
						errors.add("errorFile", new ActionMessage("error.admin.upload.file"));
						addErrors(request, errors);
					}
					formDTM.getUpload().removeAll(formDTM.getUpload());
				}
			}
			return mapping.findForward("themThanhCong");

		} else {
			formDTM.setId_account(7);
			return mapping.findForward("themFail");
		}

	}
}

/*
 * else return // upload images ActionForward forward = new ActionForward();
 * ActionErrors errors = new ActionErrors();
 * 
 * String filePath = getServlet().getServletContext().getRealPath("/") +
 * "images"; System.out.println("Server path:" + filePath); // create the upload
 * folder if not exists File folder = new File(filePath); if (!folder.exists())
 * { folder.mkdir(); }
 * 
 * if (themBaiDangForm.getUpload() != null) {
 * System.out.println(themBaiDangForm.getUpload().size()); for (int i = 0; i <
 * themBaiDangForm.getUpload().size(); i++) { FormFile images =
 * themBaiDangForm.getUpload().get(i); String fileName = images.getFileName();
 * if (!("").equals(fileName)) { File newFile = new File(filePath, fileName); if
 * (!newFile.exists()) { FileOutputStream fos = new FileOutputStream(newFile);
 * fos.write(images.getFileData()); fos.flush(); fos.close(); } else {
 * newFile.delete(); FileOutputStream fos = new FileOutputStream(newFile);
 * fos.write(images.getFileData()); fos.flush(); fos.close(); } } }
 * themBaiDangForm.getUpload().removeAll(themBaiDangForm.getUpload()); }
 * 
 * return mapping.findForward("themThanhCong"); } else { return
 * mapping.findForward("themFail"); }
 * 
 * }
 * 
 * }
 */
