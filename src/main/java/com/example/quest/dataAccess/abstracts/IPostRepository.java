package com.example.quest.dataAccess.abstracts;

import com.example.quest.entities.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Integer> {
}
