package org.h2o.dao;

import org.h2o.domain.UserDetails;

public interface UserDetailsDao {
	UserDetails findUserByUsername(String username);
	void changePassword(String oldPassword, String newPassword);
	void deleteUser(String username);
}
