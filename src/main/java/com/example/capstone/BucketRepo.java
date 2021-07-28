package com.example.capstone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepo extends JpaRepository<Bucket, Long> {

    @Query(value = "SELECT * FROM BUCKET WHERE ACCOUNT_ID= ?1", nativeQuery = true)
    List<Bucket> findByAccountId(Long accountId);
}
