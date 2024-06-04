package com.example.lucake.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "access_log")
public class AccessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "direction", nullable = false)
    private String direction;

    @Column(name = "requestUri", nullable = false)
    private String requestUri;

    @Column(name = "customerId")
    private String customerId;

    @Column(name = "statusCode")
    private String statusCode;

    @Column(name = "detail", length = 4096)
    private String detail;

    @Column(name = "clientIp")
    private String clientIp;

    @CreationTimestamp
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

}
