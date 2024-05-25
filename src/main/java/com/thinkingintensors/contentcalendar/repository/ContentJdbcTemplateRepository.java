package com.thinkingintensors.contentcalendar.repository;

import com.thinkingintensors.contentcalendar.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ContentJdbcTemplateRepository {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Content> getAllContent() {
        return jdbcTemplate.query(
                "select * from content",
                new DataClassRowMapper<>(Content.class)
        );
    }

    public Optional<Content> findById(Integer id) {
        try {
            Content content = jdbcTemplate.queryForObject("select * from content where id = ?",
                    new DataClassRowMapper<>(Content.class), id);
            return Optional.ofNullable(content);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public void createContent(Content content) {
        String query = """
                insert into content (title, description, status, content_type, date_created, date_updated, url)
                values (?, ?, ?, ?, ?, ?, ?);
                """;
        jdbcTemplate.update(query,
                content.title(),
                content.description(),
                content.status().toString(),
                content.contentType().toString(),
                content.dateCreated(),
                content.dateUpdated(),
                content.url()
        );
    }

    public void updateContent(Integer id, Content content) {
        String query = """
                insert into content (id, title, description, status, content_type, date_created, date_updated, url)
                values (?, ?, ?, ?, ?, ?, ?, ?)
                on conflict (id) do update set
                    title = excluded.title,
                    description = excluded.description,
                    status = excluded.status,
                    content_type = excluded.content_type,
                    date_created = excluded.date_created,
                    date_updated = excluded.date_updated,
                    url = excluded.url;
                """;
        jdbcTemplate.update(query,
                id,
                content.title(),
                content.description(),
                content.status().toString(),
                content.contentType().toString(),
                content.dateCreated(),
                content.dateUpdated(),
                content.url()
        );
    }
}
