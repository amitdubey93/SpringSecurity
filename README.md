# In this project.

## First Commit:

1. We have added spring security, mvc and configured the project.
2. Then created custom login, signup, logout and dashboard for user and admin.
3. Added different api for access control check.
3. Added default schema to database and loading user from there.
4. Added Dao layer for signing up user by our own dao method.

## Second Commit:

1. Using jdbcUserDetailsManager for creating, deleting user and update password for user.

## Third Commit

1. Created custom schema in mysql.
```
--
-- Table: user_roles
--
CREATE TABLE `user_roles`(
  `username` VARCHAR(255) NOT NULL,
  `role` VARCHAR(255) NOT NULL,
  KEY `fk_roles_users` (`username`)
)
ENGINE = InnoDB
ROW_FORMAT = COMPACT;

--
-- Table: user_details
--
CREATE TABLE `user_details`(
  `username` VARCHAR(255) NOT NULL DEFAULT '',
  `email` VARCHAR(50) DEFAULT NULL,
  `firstname` VARCHAR(255) NOT NULL,
  `lastname` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) DEFAULT NULL,
  `mobile` INT(11) NOT NULL,
  `enabled` BOOL NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
)
ENGINE = InnoDB
ROW_FORMAT = COMPACT;

--
-- Data: user_roles
--
INSERT INTO `user_roles` VALUES
    ('amit', 'USER');

--
-- Data: user_details
--
INSERT INTO `user_details` VALUES
    ('amit', 'amit@gmail.com', 'Amit', 'Dubey', '$2a$10$SuY73Rh6Cs9EQnuwVranjODOoMpHxvJepvqDhRwlqR9b/U454189S', 1234567890, TRUE);

--
-- References: user_roles
--
ALTER TABLE `user_roles` ADD FOREIGN KEY `fk_roles_users` (`username`) REFERENCES `user_details` (`username`) ON DELETE RESTRICT ON UPDATE RESTRICT;

```

2. Providing usersByUsernameQuery,authoritiesByUsernameQuery to authenticationManager to use it for loadUserByUsername to laod user from above schema.

3. Creating custom UserDetailsService for loading user from custom schema and notifying the authenticationManagerBuilder for using custom to do so.

4. Creating custom JdbcUserDetailsManager implementing UserDetailsManager to deal with all crud operation and loadUserByUsername() because not able to save complete custom user sign up data into database.
Implemented createUser, changePassword and deleteUser features. can do the same for all.

5. Added custom Filter InfoFilter to loginfo after the UsernamePasswordAuthenticationFilter is executed in the SecurityFilterChain. 