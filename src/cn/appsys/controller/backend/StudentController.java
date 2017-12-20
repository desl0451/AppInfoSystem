package cn.appsys.controller.backend;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.pojo.Student;
import cn.appsys.service.student.StudentService;
import cn.appsys.tools.Constants;

@Controller
public class StudentController {
	private Logger logger = Logger.getLogger(UserLoginController.class);
	@Resource
	private StudentService studentService;

	@RequestMapping(value = "/findstudent")
	public String findStudent( HttpServletRequest request,HttpSession session)  {
		logger.debug("StudentController welcome StudentInfo backend==================");
		List<Student> stuList = studentService.getStudentAll();
		session.setAttribute(Constants.STUDENT_SESSION, stuList);
		return "backend/stuinfo";
	}

}
