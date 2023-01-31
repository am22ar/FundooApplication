package com.notes.fundoonotes.service;

import com.notes.fundoonotes.dto.NoteDto;
import com.notes.fundoonotes.repository.NoteRepository;
import com.notes.fundoonotes.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NoteService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Mapper modelMapper;
    @Autowired
    private NoteRepository repository;
    public Mono<NoteDto> insertNote(Mono<NoteDto> noteDtoMono){
            return noteDtoMono.map(modelMapper::DtoToModel)
                    .flatMap(repository::insert)
                    .map(modelMapper::ModelToDto);
    }
    public Mono<NoteDto> getById(String noteId,String userId){
         Object userData = restTemplate.getForObject("http://localhost:8101/users/getById/"+userId,Object.class);
        if(userData!=null) {
            return repository.findById(noteId).map(modelMapper::ModelToDto);
        }else {
            return null;
        }
    }
    public Flux<NoteDto> getAllNotes(){
        return repository.findAll().map(modelMapper::ModelToDto);
    }
    public Mono<NoteDto> getByTitle(String title,String userId){
        Object userData = restTemplate.getForObject("http://localhost:8101/users/getById/"+userId,Object.class);
        if(userData!=null)
            return repository.findByTitle(title);
        else
            return null;
    }
    public Mono<NoteDto> getByTag(String tag,String userId){
        Object userData = restTemplate.getForObject("http://localhost:8101/users/getById/"+userId,Object.class);
        if(userData!=null)
            return repository.findByTag(tag);
        else
            return null;
    }
    public Mono<NoteDto> updateUserById(Mono<NoteDto> noteDtoMono, String noteId){
        return repository.findById(noteId)
                .flatMap(note->noteDtoMono.map(modelMapper::DtoToModel))
                .doOnNext(id->id.setNoteId(noteId))
                .flatMap(repository::save)
                .map(modelMapper::ModelToDto);
    }
    public Mono<Void> deleteById(String noteId){
        return repository.deleteById(noteId);
    }
}
