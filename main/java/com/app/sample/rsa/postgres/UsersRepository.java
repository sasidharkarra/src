package com.app.sample.rsa.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.sample.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {


}
