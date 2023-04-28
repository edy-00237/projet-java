package com.example.quoteapp01.contoller;

import com.example.quoteapp01.entities.Citation;
import com.example.quoteapp01.entities.Comment;
import com.example.quoteapp01.repositories.CitationRepository;
import com.example.quoteapp01.repositories.CommentRepository;
import com.example.quoteapp01.services.CitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/citations")
public class QuoteController {
   /* @Autowired
    private CitationService citationService;*/
   @Autowired
    private CitationRepository citationRepository;
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping({"/","","index"})
    public String index(Model model){
        model.addAttribute("citations",citationRepository.findAll());
       // model.addAttribute("citations",citationService.getCitations());
        return "index";
    }
    @GetMapping({"/admin"})
    public String indexAdmin(Model model){
        model.addAttribute("citations",citationRepository.findAll());
        return "admin_list";
    }
    @GetMapping("/create")
    public String createForm(@ModelAttribute Citation citation){
        return "create";
    }
    @PostMapping("/save")
    public String saveQuote(@ModelAttribute Citation citation){
        citationRepository.save(citation);
        return "redirect:/citations/index";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        /*Optional<Citation> citation=citationRepository.findById(id);
        Citation toUpdate=null;
        if (citation.isPresent()){
            toUpdate=citation.get();
        }
        else {
            throw new RuntimeException("Citation not found");
        }*/
        model.addAttribute("citation",citationRepository.findById(id).orElseThrow(()->new RuntimeException("Citation not found")));
        return "edit_form";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model, @ModelAttribute Comment comment){
        /*Optional<Citation> citation=citationRepository.findById(id);
        Citation toUpdate=null;
        if (citation.isPresent()){
            toUpdate=citation.get();
        }
        else {
            throw new RuntimeException("Citation not found");
        }*/
        model.addAttribute("citation",citationRepository.findById(id).orElseThrow(()->new RuntimeException("Citation not found")));
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String detete(@PathVariable("id") Long id){
        citationRepository.deleteById(id);
        return "redirect:/citations/index";
    }

    @PostMapping("/{id}/comments")
    public String createComments(@ModelAttribute Comment comment,@PathVariable Long id){
        Citation citation=citationRepository.findById(id).orElseThrow(()->new RuntimeException("Citation not found"));
        //comment.setCitation(citation);
        Comment savedComment= commentRepository.save(comment);
        citation.getComments().add(savedComment);
        citationRepository.save(citation);
        return "redirect:/citations/show/"+id;
    }



}
