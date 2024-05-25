package com.thinkingintensors.contentcalendar.controller;

import com.thinkingintensors.contentcalendar.model.Content;
import com.thinkingintensors.contentcalendar.repository.ContentCollectionRepository;
import com.thinkingintensors.contentcalendar.repository.ContentJdbcTemplateRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private final ContentJdbcTemplateRepository repository;

    public ContentController(ContentJdbcTemplateRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repository.getAllContent();
    }

    @GetMapping("/{id}")
    public Content findById(@Valid @PathVariable Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Content not found"
                ));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repository.createContent(content);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Content content, @Valid @PathVariable Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Content not found"
            );
        }
        repository.updateContent(id, content);
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable Integer id) {
        repository.deleteContent(id);
    }
}
