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

public class TimBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("bbbbbbb");
		DanhSachBaiDangForm danhSachBaiDangForm = (DanhSachBaiDangForm) form;
		BaiDangBO baidangBo = new BaiDangBO();
		ArrayList<BaiDang> listBaiDang = baidangBo.getListBaiDang();
		String search = danhSachBaiDangForm.getSearch();
		if (search == null) {
			return mapping.findForward("timkhongra");
		} else {
			listBaiDang = baidangBo.getListBaiDangTimKiem(search);
		}
		danhSachBaiDangForm.setListBaiDang(listBaiDang);

		return mapping.findForward("timthay");
	}
}
