package com.example.quoteapp01;

import com.example.quoteapp01.entities.Citation;
import com.example.quoteapp01.entities.Comment;
import com.example.quoteapp01.repositories.CitationRepository;
import com.example.quoteapp01.repositories.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Quoteapp01Application {

    public static void main(String[] args) {
        SpringApplication.run(Quoteapp01Application.class, args);
    }
    // @Bean
    /*CommandLineRunner start(CommentRepository commentRepository, CitationRepository citationRepository){
        return args -> {
            Citation citation1=citationRepository.findById(1L).orElseThrow(()->new RuntimeException("data not found"));
            Comment comment=new Comment();
            comment.setBody("comment one");
            comment.setCitation(citation1);
            commentRepository.save(comment);
            Comment comment2=new Comment(null,"commment 2",null);
            commentRepository.save(comment2);
            Citation citation2=new Citation();
            List<Comment> comments= new ArrayList<>();
            comments.add(comment2);
            comments.add(comment);
            citation2.setComments(comments);
            citation2.setContent("citation 2 content");
            citationRepository.save(citation2);
        };
    }*/

}
