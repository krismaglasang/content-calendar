package com.thinkingintensors.contentcalendar.repository;

import com.thinkingintensors.contentcalendar.model.Content;
import com.thinkingintensors.contentcalendar.model.Status;
import com.thinkingintensors.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This won't talk to the database.
 * This class will just keep pieces of content in-memory.
 */
@Repository
public class ContentCollectionRepository {

    private final List<Content> contents = new ArrayList<>();

    public ContentCollectionRepository() {}

    public List<Content> findAll() {
        return contents;
    }

    public Optional<Content> findById(Integer id) {
        return contents.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contents.add(content);
    }

    @PostConstruct
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
    }

    public void update(Content content) {
        contents.removeIf(c -> c.id().equals(content.id()));
        contents.add(content);
    }
}
