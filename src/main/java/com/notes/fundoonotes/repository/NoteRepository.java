package com.notes.fundoonotes.repository;

import com.notes.fundoonotes.dto.NoteDto;
import com.notes.fundoonotes.model.NoteModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface NoteRepository extends ReactiveMongoRepository<NoteModel,String> {

    Mono<NoteDto> findByTitle(String title);

    Mono<NoteDto> findByTag(String tag);
}
