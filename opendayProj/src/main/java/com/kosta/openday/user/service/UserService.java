package com.kosta.openday.user.service;

import com.kosta.openday.user.dto.UserDTO;

public interface UserService {
	void joinUser(UserDTO user) throws Exception;
}
