package com.Coherent.CDK.repository;

import com.Coherent.CDK.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Short> {
    Optional<Users> findByEmail(String email);
}
