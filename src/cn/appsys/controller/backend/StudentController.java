package cn.appsys.controller.backend;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.appsys.pojo.Student;
import cn.appsys.service.student.StudentService;
import cn.appsys.tools.Constants;

@Controller
public class StudentController {
	private Logger logger = Logger.getLogger(UserLoginController.class);
	@Resource
	private StudentService studentService;

	@RequestMapping(value = "/findstudent")
	public String findStudent(HttpServletRequest request, HttpSession session) {
		logger.debug("StudentController welcome StudentInfo backend==================");
		List<Student> stuList = studentService.getStudentAll();
		session.setAttribute(Constants.STUDENT_SESSION, stuList);
		return "backend/stuinfo";
	}
	@RequestMapping(value="/stuadd")
	public String stuadd(){
		return "backend/stuadd";
	}

	@RequestMapping(value = "/addsave.html", method = RequestMethod.POST)
	public String addUserSave(Student stu, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs) {
		logger.debug("StudentController insert StudentInfo backend==================");
		String idPicPath = null;
		String workPicPath = null;
		String errorInfo = null;
		boolean flag = true;
		String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
		String path2 = "smbms" + File.separator + "statics" + File.separator + "uploadfiles";
		logger.debug("path====================" + path);
		logger.debug("path====================" + path2);
		logger.info("uploadFile path ============== > " + path);
		
		
		for (int i = 0; i < attachs.length; i++) {
			MultipartFile attach = attachs[i];
			if (!attach.isEmpty()) {
				if (i == 0) {
					errorInfo = "uploadFileError";
				} else if (i == 1) {
					errorInfo = "uploadWpError";
				}
				String oldFileName = attach.getOriginalFilename();// 原文件名
				logger.info("uploadFile oldFileName ============== > " + oldFileName);
				String prefix = FilenameUtils.getExtension(oldFileName);// 原文件后缀
				logger.debug("uploadFile prefix============> " + prefix);
				int filesize = 500000;
				logger.debug("uploadFile size============> " + attach.getSize());
				if (attach.getSize() > filesize) {// 上传大小不得超过 500k
					request.setAttribute(errorInfo, " * 上传大小不得超过 500k");
					flag = false;
				} else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
						|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {// 上传图片格式不正确
					String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Personal.jpg";
					logger.debug("new fileName======== " + attach.getName());
					File targetFile = new File(path, fileName);
					if (!targetFile.exists()) {
						targetFile.mkdirs();
					}
					// 保存
					try {
						attach.transferTo(targetFile);
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute(errorInfo, " * 上传失败！");
						flag = false;
					}
					if (i == 0) {

						idPicPath = File.separator + path2 + File.separator + fileName;

					} else if (i == 1) {
						workPicPath = File.separator + path2 + File.separator + fileName;
					}
					logger.debug("idPicPath: " + idPicPath);
					logger.debug("workPicPath: " + workPicPath);

				} else {
					request.setAttribute(errorInfo, " * 上传图片格式不正确");
					flag = false;
				}
			}
		}
		if (flag) {
//			stu.setCreatedBy(((Student) session.getAttribute(Constants.USER_SESSION)).getsId());
//			stu.setCreationDate(new Date());
//			stu.setIdPicPath(idPicPath);
//			stu.setWorkPicPath(workPicPath);
			try {
//				if (userService.addUser(user)) {
//					return "redirect:/sys/user/list.html";
//				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "user/useradd";
	}
}
