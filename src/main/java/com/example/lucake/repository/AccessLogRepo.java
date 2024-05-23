package com.example.lucake.repository;

import com.example.lucake.entity.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLogRepo extends JpaRepository<AccessLog, String> {
}
