package com.example.capstone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    // @Query(value = "SELECT * FROM BUCKET WHERE ACCOUNT_ID= ?1", nativeQuery = true)
    // List<Bucket> findByAccountId(Long accountId);
}
