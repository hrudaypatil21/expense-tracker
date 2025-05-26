package com.hruday.expense_tracker.Repository;

import com.hruday.expense_tracker.Model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);

}
