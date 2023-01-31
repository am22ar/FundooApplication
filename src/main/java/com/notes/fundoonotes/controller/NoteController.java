package com.notes.fundoonotes.controller;

import com.notes.fundoonotes.dto.NoteDto;
import com.notes.fundoonotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService service;

    @PostMapping("/insertNote")
    public Mono<NoteDto> insertNote(@RequestBody Mono<NoteDto> noteDtoMono){
        return service.insertNote(noteDtoMono);
    }
    @GetMapping("/getById/{noteId}")
    public Mono<NoteDto> getById(@PathVariable String noteId,@RequestParam String userId){
        return service.getById(noteId,userId);
    }
    @GetMapping("/getAllNotes")
    public Flux<NoteDto> getAllNotes(){
        return service.getAllNotes();
    }
    @GetMapping("/getByTitle")
    public Mono<NoteDto> getByTitle(@RequestParam String title,@RequestParam String userId){
        return service.getByTitle(title,userId);
    }
    @GetMapping("/getByTag")
    public Mono<NoteDto> getByTag(@RequestParam String tag,@RequestParam String userId){
        return service.getByTag(tag,userId);
    }
    @PutMapping("/updateById/{noteId}")
    public Mono<NoteDto> updateUserById(@RequestBody Mono<NoteDto> noteDtoMono,@PathVariable String noteId){
        return service.updateUserById(noteDtoMono,noteId);
    }
    @DeleteMapping("/deleteById/{noteId}")
    public Mono<Void> deleteUser(@PathVariable String noteId){
        return service.deleteById(noteId);
    }

}
