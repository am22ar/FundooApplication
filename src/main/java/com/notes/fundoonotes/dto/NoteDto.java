package com.notes.fundoonotes.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@Component
public class NoteDto {
    private String noteId;
    private String userId;
    private String title;
    private String message;
    private String tag;
}
