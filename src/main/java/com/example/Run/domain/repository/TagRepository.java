package com.example.Run.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Run.domain.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

}
