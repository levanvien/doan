package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.XoaBDForm;
import model.bo.BaiDangBO;

public class XoaBaiDangAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		XoaBDForm xoaBaiDangForm = (XoaBDForm) form;
		BaiDangBO baiDangBo = new BaiDangBO();

		int id_post = xoaBaiDangForm.getId_post();
		baiDangBo.deleteBaiDang(id_post);

		System.out.println("Dang Xoa:" + xoaBaiDangForm.getId_post());

		return mapping.findForward("thanhCong");

	}

}
