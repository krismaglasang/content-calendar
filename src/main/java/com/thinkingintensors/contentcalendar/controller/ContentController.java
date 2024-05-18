package com.thinkingintensors.contentcalendar.controller;

import com.thinkingintensors.contentcalendar.model.Content;
import com.thinkingintensors.contentcalendar.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository contentCollectionRepository;

    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.contentCollectionRepository = contentCollectionRepository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return contentCollectionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@Valid @PathVariable Integer id) {
        return contentCollectionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Content not found"
                ));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        contentCollectionRepository.save(content);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Content content, @Valid @PathVariable Integer id) {
        if (contentCollectionRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Content not found"
            );
        }
        contentCollectionRepository.update(content);
    }
}
