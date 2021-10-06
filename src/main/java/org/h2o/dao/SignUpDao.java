package org.h2o.dao;

import org.h2o.domain.SignUpDTO;

public interface SignUpDao {
	void saveUser(SignUpDTO signUpDto);
}
