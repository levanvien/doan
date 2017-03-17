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

	<div class="container">
		<div class="row">
		
			<div class="container main-tain">
				<nav class="navbar navbar-inverse ">

				<div class="navbar-header">
					<a class="navbar-brand" href="#">Vilatoth</a>
				</div>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							Sign Up</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Log out</a></li>
				</ul>

				</nav>

				<div class="col-sm-3 menu-category">
					 <div class="category">
					<html:form action="/tim-bd">
						<div class="input-group custom-search-form">
							
							<html:text property="search" styleClass="form-control"></html:text>
							<span class="input-group-btn">
							
								<html:submit styleClass="btn btn-default">
								Search!</html:submit>
							</span>
							
						</div>
						</html:form>
						<br>

					</div> 
					<div class="category">
						<div class="nav nav-pills nav-stacked category">
							<li class="active"><a href="#"><i
									class="glyphicon glyphicon-list-alt"></i> Thông tin bài đăng</a></li>
							<li><a href="#"><i
									class="glyphicon glyphicon-align-justify"></i>Danh sách bài
									đăng</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-plus"></i>Thêm
									bài đăng</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-thumbs-up"></i>Danh
									sách bài đăng yêu thích</a>
							<li><a href="#"><i class="glyphicon glyphicon-bell"></i>Thông
									báo</a>
							<li><a href="#"><i class="glyphicon glyphicon-refresh"></i>Danh
									sách bài đăng chờ duyệt</a></li>


						</div>
					</div>

				</div>
				<div class="col-sm-9 product-list">

				<div class="bs-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>id_post</th>
                <th>title_post</th>
                <th>content_post</th>
                <th>cost</th>
                 <th>type post</th>
                
               	<th></th>
               		<th></th>
               			<th></th>
               	
            </tr>
            </thead>
            <tbody>
            
            <logic:iterate id="i" name="danhSachBaiDangForm" property="listBaiDang" >
            	<tr>
                <th scope="row">
                	<bean:write name="i" property="id_post"/>
				</th>
                <td>
                	<bean:write name="i" property="title_post"/>
                </td>
                <td>
                	<bean:write name="i" property="content_post"/>
				</td>
                <td>
                	<bean:write name="i" property="cost"/>
                	
                </td>
                 <td>
                	<bean:write name="i" property="type_post"/>
                	
                </td>
               
             
               
             
               	<td>
               		<bean:define id="idpost" name="i" property="id_post"></bean:define>
               		
                	
                  <html:link action="/xoaSV?id_post=${idpost}" style="margin-left: 30px;" styleClass="confirmation" >
                		<span class="glyphicon glyphicon-trash"></span> 
                	</html:link> 

               	</td>   
               	<td>
               	<%-- <bean:define id="idpost1" name="i" property="id_post"></bean:define>
                	<html:link action="/suaSV?id_post=${idpost1}">
                		<span class="glyphicon glyphicon-edit"></span>
                	</html:link> --%>
                	<span class="glyphicon glyphicon-edit"></span>
               	</td>
               	 
                
                
            </tr>
            </logic:iterate>
         
            </tbody>
        </table>
    </div> 
<!-- <div class="product-box">
						 <a href="#"> <img src="bootstrap-3.3.7-dist/img/4s.jpg"></a>
						<a href="#">
							<h4>Cần bán Samsung Galaxy J7 đã qua sử dụng, full box, còn
								bảo hành</h4>
						</a>
						<p>
							<i class="glyphicon glyphicon-usd"></i><b> 3,500,000 vnd</b>
						</p>
						<p>
							<i class="glyphicon glyphicon-map-marker"></i> Đà Nẵng
						</p>
						<p>
							<i class="glyphicon glyphicon-phone"></i> 0162652127
						</p>
						<a href="#"><i class="glyphicon glyphicon-pencil"></i>Sửa</a> <a
							href="#"><i class="glyphicon glyphicon-trash"></i>Xóa</a>
					</div>
					<div class="product-box">
						<a href="#"> <img src="bootstrap-3.3.7-dist/img/3.jpg"></a>
						<a href="#">
							<h4>Cần bán Samsung Galaxy J7 đã qua sử dụng, full box, còn
								bảo hành</h4>
						</a>
						<p>
							<i class="glyphicon glyphicon-usd"></i><b> 3,500,000 vnd</b>
						</p>
						<p>
							<i class="glyphicon glyphicon-map-marker"></i> Đà Nẵng
						</p>
						<p>
							<i class="glyphicon glyphicon-phone"></i> 0162652127
						</p>
						<a href="#"><i class="glyphicon glyphicon-pencil"></i>Sửa</a> <a
							href="#"><i class="glyphicon glyphicon-trash"></i>Xóa</a>
					</div>
					<div class="product-box">
						<a href="#"> <img src="bootstrap-3.3.7-dist/img/2.jpg"></a>
						<a href="#">
							<h4>Cần bán Samsung Galaxy J7 đã qua sử dụng, full box, còn
								bảo hành</h4>
						</a>
						<p>
							<i class="glyphicon glyphicon-usd"></i><b> 3,500,000 vnd</b>
						</p>
						<p>
							<i class="glyphicon glyphicon-map-marker"></i> Đà Nẵng
						</p>
						<p>
							<i class="glyphicon glyphicon-phone"></i> 0162652127
						</p>
						<a href="#"><i class="glyphicon glyphicon-pencil"></i>Sửa</a> <a
							href="#"><i class="glyphicon glyphicon-trash"></i>Xóa</a>
					</div>
					<div class="product-box">
						<a href="#"> <img src="bootstrap-3.3.7-dist/img/1.jpg"></a>
						<a href="#">
							<h4>Cần bán Samsung Galaxy J7 đã qua sử dụng, full box, còn
								bảo hành</h4>
						</a>
						<p>
							<i class="glyphicon glyphicon-usd"></i><b> 3,500,000 vnd</b>
						</p>
						<p>
							<i class="glyphicon glyphicon-map-marker"></i> Đà Nẵng
						</p>
						<p>
							<i class="glyphicon glyphicon-phone"></i> 0162652127
						</p>
						<a href="#"><i class="glyphicon glyphicon-pencil"></i>Sửa</a> <a
							href="#"><i class="glyphicon glyphicon-trash"></i>Xóa</a>
					</div>
					<div class="product-box">
						<a href="#"> <img src="bootstrap-3.3.7-dist/img/5.jpg"></a>
						<a href="#">
							<h4>Cần bán Samsung Galaxy J7 đã qua sử dụng, full box, còn
								bảo hành</h4>
						</a>
						<p>
							<i class="glyphicon glyphicon-usd"></i><b> 3,500,000 vnd</b>
						</p>
						<p>
							<i class="glyphicon glyphicon-map-marker"></i> Đà Nẵng
						</p>
						<p>
							<i class="glyphicon glyphicon-phone"></i> 0162652127
						</p>
						<a href="#"><i class="glyphicon glyphicon-pencil"></i>Sửa</a> <a
							href="#"><i class="glyphicon glyphicon-trash"></i>Xóa</a> 
					</div> -->

 </div>
 </div>
 </table>

				</div>
				<p>
					<br />
				</p>
				<ul class="pagination" style="float: right">
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">Trang Tiếp</a></li>
				</ul>
			</div>
			<script type="text/javascript">
    $('.confirmation').on('click', function () {
        return confirm('Are you sure?');
    });
</script> 
</script>
</body>
</html>