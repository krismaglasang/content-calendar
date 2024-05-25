package com.thinkingintensors.contentcalendar.repository;

import com.thinkingintensors.contentcalendar.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This won't talk to the database.
 * This class will just keep pieces of content in-memory.
 */
@Repository
public class ContentCollectionRepository {

    @Autowired
    private final ContentJdbcTemplateRepository jdbcTemplateRepository;

    public ContentCollectionRepository(ContentJdbcTemplateRepository jdbcTemplateRepository) {
        this.jdbcTemplateRepository = jdbcTemplateRepository;
    }

    public List<Content> findAll() {
        return jdbcTemplateRepository.getAllContent();
    }

    public Optional<Content> findById(Integer id) {
        return jdbcTemplateRepository.findById(id);
    }

    public void save(Content content) {
        jdbcTemplateRepository.createContent(content);
    }

    public void update(Integer id, Content content) {
        jdbcTemplateRepository.updateContent(id, content);
    }

    // Keeping this in here as a reminder that @PostConstruct is an option I could use later.
    /*@PostConstruct
    private void init() {
        Content content = new Content(
                1,
                "My first content",
                "Just my first content",
                Status.IN_PROGRESS,
                Type.CONFERENCE_TALK,
                LocalDateTime.now(),
                null,
                "https://thinkingintensors.co.nz");
        contents.add(content);
    }*/
}
