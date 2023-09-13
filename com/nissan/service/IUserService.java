package com.nissan.service;

import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
@Service
public interface IUserService {
	public APIResponse findUserByNameAndPassword(String userName,String password);
	

}
 