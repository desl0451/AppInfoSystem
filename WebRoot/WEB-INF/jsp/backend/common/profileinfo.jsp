<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="profile">
  <div class="profile_pic">
      <img src="${pageContext.request.contextPath }/statics/images/img.jpg" alt="..." class="img-circle profile_img">
  </div>
  <div class="profile_info">
    <span>欢迎,</span>
    <h2><c:out value="${userSession.userName}"/></h2>
  </div>
</div>
