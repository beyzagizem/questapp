package com.example.quest.dataAccess.abstracts;

import com.example.quest.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {
}
