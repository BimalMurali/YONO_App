package com.nissan.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.model.User;
import com.nissan.repository.IUserRepository;
import com.nissan.util.JwtUtil;

@Service
public class UserServiceImple implements IUserService {

	@Autowired
	private IUserRepository userRespository;

	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	//verify user exist or no
	public APIResponse findAdminByNameAndPassword(String userName, String password) {
		
		User user=userRespository.findAdminByUserNameAndPassword(userName, password);
		if(user==null) {
			apiResponse.setData("Invalid credentials");
			return apiResponse;
			
		}
		//credentials are correct then
		String token=jwtUtil.generateJwt(user);
				
				//storing more details and token
				Map<String,Object>data = new HashMap<String,Object>();
		data.put("ACCESSTOKEN", token);
		data.put("role", user.getRoleId());
		data.put("UserName", user.getUserName());
		
		apiResponse.setStatus(200);
		apiResponse.setData(data);
		
		return apiResponse;
	}

	@Override
	public APIResponse findUserByNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
