package com.study.boy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.study.boy.domain.Boy;

public interface IBoyRepository extends JpaRepository<Boy, Integer> {

}
