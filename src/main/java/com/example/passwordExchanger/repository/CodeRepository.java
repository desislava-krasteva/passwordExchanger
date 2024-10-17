package com.example.passwordExchanger.repository;

import com.example.passwordExchanger.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CodeRepository extends JpaRepository<Code,Long> {

    @Modifying
    @Transactional
    @Query(
            nativeQuery = true,
            value
                    = "insert into codes(user_id) values (?1)")
    void insertCode(int user_id);


    @Query(
            nativeQuery = true,
            value
                    = "SELECT MAX(code_id) From codes")
    int getLastID();
}
