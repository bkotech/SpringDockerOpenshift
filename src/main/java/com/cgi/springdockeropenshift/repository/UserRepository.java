package com.cgi.springdockeropenshift.repository;

import com.cgi.springdockeropenshift.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findFirstByOrderByIdAsc();

    User findFirstByOrderByIdDesc();

}
