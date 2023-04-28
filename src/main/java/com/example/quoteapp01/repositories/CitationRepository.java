package com.example.quoteapp01.repositories;

import com.example.quoteapp01.entities.Citation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitationRepository extends JpaRepository<Citation,Long> {
}
