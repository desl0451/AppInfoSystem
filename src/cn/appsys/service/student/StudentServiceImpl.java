package cn.appsys.service.student;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.student.StudentMapper;
import cn.appsys.pojo.Student;
import cn.appsys.service.backend.BackendUserService;

@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentMapper studentMapper;

	@Override
	public List<Student> getStudentAll() {
		// TODO Auto-generated method stub
		List<Student> sList = null;
		try {
			sList = new ArrayList<Student>();
			sList = studentMapper.getStudentList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sList;
	}

}
