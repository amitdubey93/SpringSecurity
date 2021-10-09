package org.h2o.dao;

import org.h2o.domain.UserDetails;

public interface SignUpDao {
	void saveUser(UserDetails signUpDto);
}
