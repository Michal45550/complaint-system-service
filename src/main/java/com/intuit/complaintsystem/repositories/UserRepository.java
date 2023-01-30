package com.intuit.complaintsystem.repositories;

import com.intuit.complaintsystem.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
