package com.example.quest.dataAccess.abstracts;

import com.example.quest.entities.concretes.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILikeRepository extends JpaRepository<Like, Integer> {
}
