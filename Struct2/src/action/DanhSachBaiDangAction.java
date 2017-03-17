package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachBaiDangForm;
import model.bean.BaiDang;
import model.bo.BaiDangBO;

public class DanhSachBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DanhSachBaiDangForm dsBaiDangForm = (DanhSachBaiDangForm) form;
		BaiDangBO baiDangBo = new BaiDangBO();
		ArrayList<BaiDang> listBaiDang = baiDangBo.getListBaiDang();

		for (BaiDang baiDang : listBaiDang) {
			System.out.println("---:" + baiDang.getTitle_post());
		}

		dsBaiDangForm.setListBaiDang(listBaiDang);
		System.out.println("aaaa" + dsBaiDangForm.getListBaiDang().size());
		return mapping.findForward("thanhCong");

	}

}
