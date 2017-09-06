package cn.appsys.service.backend;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.dao.backenduser.BackendUserMapper;
import cn.appsys.pojo.BackendUser;

@Service
public class BackendUserServiceImpl implements BackendUserService {

	@Resource
	private BackendUserMapper backendUserMapper;

	@Override
	public BackendUser login(String userCode, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		BackendUser backendUser = (BackendUser) backendUserMapper.getLoginUser(userCode);
		if (backendUser != null) {
			if (!backendUser.getUserPassword().equals(userPassword)) {
				return null;
			}
		}
		return backendUser;
	}
	
}
