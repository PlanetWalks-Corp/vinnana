package com.jsondemo.jsondemo.Repository;
import com.jsondemo.jsondemo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {



}