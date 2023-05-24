package com.kosta.openday.user.dao;

import com.kosta.openday.user.dto.UserDTO;

public interface UserDAO {

	void insertUser(UserDTO user) throws Exception;
}
