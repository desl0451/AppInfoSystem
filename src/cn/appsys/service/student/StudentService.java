package cn.appsys.service.student;

import java.util.List;

import cn.appsys.pojo.Student;

public interface StudentService {
	/**
	 * 查询全部信息
	 * @return
	 */
	public List<Student> getStudentAll();
}
