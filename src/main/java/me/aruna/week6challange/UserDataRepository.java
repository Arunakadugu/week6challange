package me.aruna.week6challange;

import org.springframework.data.repository.CrudRepository;

public interface UserDataRepository extends CrudRepository<UserData,Long> {
    UserData findAllByAccount(String account);
    UserData findByUsername(String username);
    UserData findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);
}

