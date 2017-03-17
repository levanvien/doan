package form;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class FileUpLoadForm extends ActionForm {
	protected ArrayList<FormFile> uploaded = new ArrayList<FormFile>();

	public void setUpload(List<FormFile> file) {
		uploaded.addAll(file);
	}

	public List<FormFile> getUpload() {
		return uploaded;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (getUpload() != null) {
			if (getUpload().size() <= 5) {
				for (int i = 0; i < getUpload().size(); i++) {
					FormFile image = getUpload().get(i);
					if (image.getFileSize() == 0) {
						errors.add("common.file.err", new ActionMessage("error.common.file.required"));
						return errors;
					}
					// only allow textfile to upload
					System.out.println(image.getContentType());
					if (!"image/jpeg".equals(image.getContentType())) {
						errors.add("common.file.err.ext", new ActionMessage("error.common.file.image.only"));
						return errors;
					}
					// file size cant larger than 10kb
					if (image.getFileSize() > 5120000) { // 10240=10kb
															// 5M=10240*100*5
						errors.add("common.file.err.size", new ActionMessage("error.common.file.size.limit", 5120000));
						return errors;
					}
				}
			} else {
				errors.add("common.file.multiple", new ActionMessage("error.common.file.multiple"));
				return errors;
			}
		}
		return errors;
	}

}
