package com.notes.fundoonotes.model;

import com.notes.fundoonotes.dto.NoteDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "NotesDetails")
public class NoteModel {
    @Id
    private String noteId;
    private String userId;
    private String title;
    private String message;
    private String tag;

    public NoteModel(String noteId, NoteDto noteDto) {
        this.noteId = noteId;
        this.userId = noteDto.getUserId();
        this.title = noteDto.getTitle();
        this.message = noteDto.getMessage();
        this.tag = noteDto.getTag();
    }

    public NoteModel(NoteDto noteDto) {
        this.userId = noteDto.getUserId();
        this.title = noteDto.getTitle();
        this.message = noteDto.getMessage();
        this.tag = noteDto.getTag();
    }
}
