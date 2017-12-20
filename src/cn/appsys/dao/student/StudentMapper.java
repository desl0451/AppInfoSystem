package cn.appsys.dao.student;

import java.util.List;

import cn.appsys.pojo.Student;

public interface StudentMapper {
	/**
	 * 查询全部学生信息
	 * @return
	 */
	public List<Student> getStudentList();
}
