package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.SuaBaiDangForm;
import model.bean.BaiDang;
import model.bo.BaiDangBO;

public class SuaBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		SuaBaiDangForm suaBaiDangForm = (SuaBaiDangForm) form;

		BaiDangBO baiDangBO = new BaiDangBO();
		// lay danh sach cac khoa

		// sua sinh vien
		// String msv=sinhVienForm.getMsv();
		if ("submit".equals(suaBaiDangForm.getSubmit())) { // nhan nut Xac nhan
															// o trang Them sinh
															// vien
			String title_post = suaBaiDangForm.getTitle_post();
			String content_post = suaBaiDangForm.getContent_post();
			String type_product = suaBaiDangForm.getType_product();
			int percent_product = Integer.parseInt(suaBaiDangForm.getPercent_product());
			int cost = Integer.parseInt(suaBaiDangForm.getCost());
			String address_product = suaBaiDangForm.getAddress_product();
			String type_post = suaBaiDangForm.getType_post();
			baiDangBO.suaBaiDang(title_post, content_post, type_product, percent_product, cost, address_product,
					type_post);
			return mapping.findForward("suaSVxong");
		} else { // chuyen sang trang Sua sinh vien
			BaiDang baiDang = baiDangBO.getThongTinBaiDang(7);
			suaBaiDangForm.setTitle_post(baiDang.getTitle_post());
			suaBaiDangForm.setContent_post(baiDang.getContent_post());
			suaBaiDangForm.setType_product(baiDang.getType_product());
			suaBaiDangForm.setPercent_product(baiDang.getPercent_product() + "");
			suaBaiDangForm.setCost(baiDang.getCost() + "");
			suaBaiDangForm.setAddress_product(baiDang.getAddress_product());
			suaBaiDangForm.setType_post(baiDang.getType_post());
			return mapping.findForward("suaSV");
		}

	}

}
