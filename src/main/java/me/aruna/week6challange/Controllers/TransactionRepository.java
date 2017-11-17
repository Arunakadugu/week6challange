package me.aruna.week6challange.Controllers;

import me.aruna.week6challange.UserData;
import me.aruna.week6challange.UserTransaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<UserTransaction,Long> {
    UserTransaction findAllByAccount(String account);
    UserTransaction findByUsername(String username);
    UserTransaction findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);
}
