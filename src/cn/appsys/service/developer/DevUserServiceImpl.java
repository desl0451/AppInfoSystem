package cn.appsys.service.developer;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;

@Service
public class DevUserServiceImpl implements DevUserService {

	@Resource
	private DevUserMapper devUserMapper;

	@Override
	public DevUser login(String devCode, String devPassword) throws Exception {
		DevUser devUser = null;
		devUser = devUserMapper.getLoginUser(devCode);
		// 匹配密码
		if (devUser != null) {
			if (!devUser.getDevPassword().equals(devPassword)) {
				devUser = null;
			}
		}
		return devUser;
	}

}
