package com.example.quoteapp01.contoller;
import com.example.quoteapp01.entities.Citation;
import com.example.quoteapp01.services.CitationService;
import com.example.quoteapp01.services.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/citations")
@CrossOrigin(origins = "http://localhost:8001")
public class CitationRestController {
    @Autowired
    private MyService myService;
    @Autowired
    private CitationService citationService;

    @GetMapping({"","/"})
    public List<Citation> citations(){
        return citationService.getCitations();
    }
    @PostMapping("/save")
    public Citation save(@RequestBody Citation citation){
        log.debug("saving data");
        log.debug(citation.toString());
        log.debug("saving data");
        return citationService.create(citation);
    }
    @GetMapping("/{id}")
    public Citation getCitation(@PathVariable Long id){
        return citationService.getCitation(id);
    }
    @PutMapping("/{id}")
    public Citation updateCitation(@PathVariable Long id,@ModelAttribute Citation citation){
        return citationService.update(citation ,id);
    }
    @GetMapping("/test")
    public  Citation hello(){
        return new Citation(1L,"content",null);
    }
}
