<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/24
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<head>
    <title>添加商品</title>
</head>
<body class="container-fluid">
<h2>添加商品：</h2>
<form class="form-horizontal" enctype="multipart/form-data" method="post" action="addproduct.do">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">商品名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" name="pro_name" placeholder="商品名">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">商品价格</label>
        <div class="col-sm-10">
            <input type="test" class="form-control" id="inputPassword3" name="pro_price" placeholder="商品价格">
        </div>
    </div>
    <div class="form-group">
        <label for="pro_image" class="col-sm-2 control-label">商品图片</label>
        <div class="col-sm-10">
            <input type="file" id="pro_image" name="pro_img">
        </div>
    </div>
    <div class="form-group">
        <label for="pro_des" class="col-sm-2 control-label">商品详情</label>
        <div class="col-sm-10">
            <input style="width: 100%" class="form-control" id="pro_des" name="pro_des" placeholder="商品详情">
        </div>
    </div>
    <div class="form-group">
        <label for="pro_stock" class="col-sm-2 control-label">商品库存</label>
        <div class="col-sm-10">
            <input type="test" id="pro_stock" class="form-control" name="pro_stock" placeholder="商品库存">
        </div>
    </div>
    <div class="form-group">
        <label for="pro_date" class="col-sm-2 control-label">商品上架日期</label>
        <div class="col-sm-10">
            <input type="date" id="pro_date" class="form-control" name="pro_date">
        </div>
    </div>
    <div class="form-group">
        <label for="pro_category_id" class="col-sm-2 control-label">商品类别ID</label>
        <div class="col-sm-10">
            <input type="text" id="pro_category_id" class="form-control"  name="pro_category_id" placeholder="商品类别ID">
        </div>
    </div>
    <div class="form-group">
        <label for="pro_factory" class="col-sm-2 control-label">生产厂家</label>
        <div class="col-sm-10">
            <input type="text" id="pro_factory" class="form-control" name="pro_factory" placeholder="生产厂家">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">添加</button>
        </div>
    </div>
</form>
</body>
</html>
