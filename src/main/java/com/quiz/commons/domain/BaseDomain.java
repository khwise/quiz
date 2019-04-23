package com.quiz.commons.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class BaseDomain {

    //    @Column(name = "created_at")
//    @CreationTimestamp
    private LocalDateTime createdAt;
    //
//    @Column(name = "updated_at")
//    @UpdateTimestamp
    private LocalDateTime updatedAt;
    //
//    @Column(name = "creator")
    private Integer creator;
    //
//    @Column(name = "updater")
    private Integer updater;
}
