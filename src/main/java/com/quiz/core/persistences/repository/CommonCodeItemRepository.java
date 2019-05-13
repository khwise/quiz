package com.quiz.core.persistences.repository;

import com.quiz.core.entity.CommonCodeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonCodeItemRepository extends JpaRepository<CommonCodeItem, CommonCodeItem.PK> {
}
