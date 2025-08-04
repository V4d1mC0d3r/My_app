package com.example.userservice.repository;

import com.example.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    //Эти типы Optional нужны для того чтобы не выбрасывалось исключение NullPointerExceptions(из-за внешних запросов или непредсказуемости).
    Optional<User> findByEmail(String email);
    Optional<User> findByPhoneNumber(String phoneNumber);

    //Эти булевые переменные нужны для проверки уникальности email-а, или номера телефона, чтобы не было дубликатов.
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);


}
