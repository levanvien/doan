<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UpLoad File</title>
</head>
<body>
<%-- <h1><bean:message key="label.common.title" /></h1>

<html:messages id="err_name" property="common.file.err">
<div style="color:red">
	<bean:write name="err_name" />
</div>
</html:messages>
<html:messages id="err_name" property="common.file.err.ext">
<div style="color:red">
	<bean:write name="err_name" />
</div>
</html:messages>
<html:messages id="err_name" property="common.file.err.size">
<div style="color:red">
	<bean:write name="err_name" />
</div>
</html:messages>

<html:form action="/Upload" method="post" enctype="multipart/form-data">
<br/>
	<bean:message key="label.common.file.label" /> : <html:file property="images1" size="50"  />
<br/>
<br/>
<html:submit>
	<bean:message key="label.common.button.submit" />
</html:submit>

</html:form> --%>
<html:form action="/adminDTM" method="post" enctype="multipart/form-data">
					<fieldset>
					<legend>ĐĂNG TIN MỚI</legend>
						<pre>Gallery Images:											
							<input type="file" name="upload" multiple />							
						</pre>
						<html:submit value = "S U B M I T"/>
					</fieldset>
				</html:form>
				<ul style="color: red;">
					<logic:messagesPresent>
						<html:messages id="msg">
							${msg}
						</html:messages>
					</logic:messagesPresent>
				</ul>
</body>
</html>