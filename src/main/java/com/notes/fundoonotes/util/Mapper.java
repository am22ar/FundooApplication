package com.notes.fundoonotes.util;

import com.notes.fundoonotes.dto.NoteDto;
import com.notes.fundoonotes.model.NoteModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public NoteModel DtoToModel(NoteDto noteDto){
        NoteModel noteDtoToModel = new NoteModel();
        BeanUtils.copyProperties(noteDto,noteDtoToModel);
        return noteDtoToModel;
    }

    public NoteDto ModelToDto(NoteModel noteModel){
        NoteDto noteModelToDto = new NoteDto();
        BeanUtils.copyProperties(noteModel,noteModelToDto);
        return noteModelToDto;
    }
}
