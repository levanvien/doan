<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/prettyPhoto.css">
<link rel="stylesheet" type="text/css" href="css/responsive.css">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Rao Vặt Điện Thoại</title>
</head>
<body>
<div class="container post-productvien">
	<div class="row">
	<html:form action="/them-bd" method="post" styleClass="form-horizontal" enctype="multipart/form-data">
		<!-- <form action="dang_tin" method="get" class="form-horizontal"> -->
			
			
			<html:hidden property="id_account"/>
			
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-10">
					<h2>ĐĂNG TIN</h2>
				</div>
			</div>
            <div class="form-group">
				<label class="col-sm-3 control-label">Tiêu đề:</label>
				<div class="col-sm-4 ">
				<html:text property="title_post" styleClass="form-control"></html:text>
					<!-- <input class="form-control" type="text" name="tieude"> -->
				</div>
			</div>
			<div class="form-group">
				<div class="danhmuc">
					<label class="col-sm-3 control-label">Loại sản phẩm:</label>
					<div class="col-sm-4">
						<!-- <select id="category" name="category"
							class="form-control fr-contrl-head">
							<option value="0">SamSung</option>
							<option value="0">LG</option>
							<option value="0">LG</option>
							<option value="0">NOKIA</option>
						</select> -->
						<html:select property="type_product" styleClass="form-control fr-contrl-head" styleId="category">
						  <html:option value="SamSung">SamSung</html:option>
						  <html:option value="LG">LG</html:option>
						  <html:option value="OPPO">OPPO</html:option>
						  <html:option value="NOKIA">NOKIA</html:option>
						</html:select>
					</div>
				</div>
			</div>
            <div class="form-group">
				<div class="danhmuc">
					<label class="col-sm-3 control-label">Tình trạng:</label>
					<div class="col-sm-4">
						<!-- <select id="category" name="category"
							class="form-control fr-contrl-head">
							<option value="0">50</option>
							<option value="0">60</option>
							<option value="0">70</option>
							
						</select> -->
						<html:select property="percent_product" styleClass="form-control fr-contrl-head" styleId="category">
						  <html:option value="50">50</html:option>
						  <html:option value="60">60</html:option>
						  <html:option value="70">70</html:option>
						  <html:option value="80">80</html:option>
						  <html:option value="90">90</html:option>
						  <html:option value="100">100</html:option>
						</html:select>
					</div>
				</div>
			</div>
            <div class="form-group">
				<label class="col-sm-3 control-label">Giá:</label>
				<div class="col-sm-4 ">
					<!-- <input class="form-control" type="text" name="tieude"> -->
					<html:text property="cost" styleClass="form-control"></html:text>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label ">Khu vực:</label>
				<div class="col-sm-4">
					<!-- <select id="local" name="local" class="form-control fr-contrl-head">
						<option value="0">Hà Nội</option>
						<option value="0">Sài Gòn</option>
						<option value="0">Đà Nẵng</option>
					</select> -->
					<html:select property="address_product" styleClass="form-control fr-contrl-head" styleId="local">
						  <html:option value="Hà Nội">Hà Nội</html:option>
						  <html:option value="Đà Nẵng">Đà Nẵng</html:option>
						  <html:option value="Sài gòn">Sài gòn</html:option>
						  <html:option value="Đà Lạt">Đà Lạt</html:option>
						  
						</html:select>
				</div>
			</div>
			
			
			<div class="form-group show">
				<label class="col-sm-3 control-label">Mô tả:</label>
				<div class="col-sm-4 col">
					<!-- <textarea class="form-control" rows="5" name="noidung" tabindex="6"></textarea> -->
					<html:textarea property="content_post" rows="5" styleClass="form-control"></html:textarea>
				</div>
			</div>
			
			
			<div class="form-group">
				<label class="col-sm-3 control-label">Loại bài đăng:</label>
				<div class="col-sm-2">
						<!-- <select id="category" name="category"
							class="form-control fr-contrl-head">
							<option value="vip">Vip</option>
                            <option value="thuong">Thường</option>
							
						</select> -->
						<html:select property="type_post" styleClass="form-control fr-contrl-head" styleId="category">
						  <html:option value="Normal">Normal</html:option>
						  <html:option value="VIP">VIP</html:option>
						
						  
						</html:select>
			</div>
            </div>
            <div class="form-group formvien">
    <label class="col-sm-3 control-label" for="exampleInputFile">File input</label>
                <div class="col-sm-5">
    <!-- <input type="file" id="exampleInputFile"> -->
    <%-- <html:file property="file" styleId="exampleInputFile"></html:file> --%>
   <!--  <p class="help-block">Example block-level help text here.</p> -->
   
					
						<%-- <html:file property="file">Chọn file: </html:file>	 --%>				
				
					
																
							<input type="file" name="upload" multiple />							
						
						
					
				
				
  </div>
            </div>
 
    	
			<div class="col-sm-offset-4 col-sm-10 ">
				<!-- <button type="submit" class="btn btn-primary ">Submit</button>
                <button type="reset" class="btn btn-danger">Hủy</button> -->
                <html:submit property="submit" styleClass="btn btn-primary">Sửa</html:submit>
                <html:reset property="huy" styleClass="btn btn-danger"> Hủy</html:reset>
			</div>
		</html:form>
	</div>
</div>
</body>
</html>