package com.example.quoteapp01.services;

import com.example.quoteapp01.entities.Citation;
import com.example.quoteapp01.repositories.CitationRepository;
import com.example.quoteapp01.repositories.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class CitationService {
    private CitationRepository citationRepository;
    private CommentRepository commentRepository;

    public CitationService(CitationRepository citationRepository, CommentRepository commentRepository) {
        this.citationRepository = citationRepository;
        this.commentRepository = commentRepository;
    }
    public List<Citation> getCitations(){
      //log.debug(String.valueOf(citationRepository.findAll()));
        return citationRepository.findAll();
    }

    public Citation create(Citation citation) {
        return citationRepository.save(citation);
    }

    public Citation getCitation(Long id) {
        return citationRepository.findById(id).orElseThrow(()->new RuntimeException("Citation not found"));
    }
    public Citation update(Citation citation,Long id) {
        citationRepository.findById(id).orElseThrow(()->new RuntimeException("Citation not found"));
        return citationRepository.save(citation);
    }
    public void delete(Long id){
        citationRepository.findById(id).orElseThrow(()->new RuntimeException("Citation not found"));
        citationRepository.deleteById(id);
    }
}
