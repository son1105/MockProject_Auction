package com.company.viettridao.repositories;

import com.company.viettridao.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserNameAndPassword(String userName, String password);
    User findByUserName(String userName);
    User findByEmail(String email);
}