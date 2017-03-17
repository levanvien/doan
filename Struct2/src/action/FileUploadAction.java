package action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import form.FileUpLoadForm;

public class FileUploadAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ActionErrors errors = new ActionErrors();

		FileUpLoadForm formDTM = (FileUpLoadForm) form;

		String filePath = getServlet().getServletContext().getRealPath("/") + "images/kk01";
		System.out.println("Server path:" + filePath);
		// create the upload folder if not exists
		File folder = new File(filePath);
		if (!folder.exists()) {
			folder.mkdir();
		}

		if (formDTM.getUpload() != null) {
			System.out.println(formDTM.getUpload().size());
			for (int i = 0; i < formDTM.getUpload().size(); i++) {
				FormFile images = formDTM.getUpload().get(i);
				String fileName = images.getFileName();
				if (!("").equals(fileName)) {
					File newFile = new File(filePath, fileName);
					if (!newFile.exists()) {
						FileOutputStream fos = new FileOutputStream(newFile);
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
			}
			formDTM.getUpload().removeAll(formDTM.getUpload());
		}

		forward = mapping.findForward("thanhCong");
		return forward;
	}

}
