package com.example.quoteapp01.repositories;

import com.example.quoteapp01.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
