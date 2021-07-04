package com.project.crudusers.services;

import com.project.crudusers.entity.NotesEntity;
import com.project.crudusers.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServices {
    @Autowired
    private NoteRepository noteRepository;

    public NotesEntity save (NotesEntity note){
        return this.noteRepository.save(note);
    }

    public List<NotesEntity> findAll(){
        return this.noteRepository.findAll();
    }

    public NotesEntity findOne(Long id){
        return this.noteRepository.getById(id);
    }

    public NotesEntity update(NotesEntity notes){
        //TODO:Update

        return null;
    }

    public void delete(long id){
        this.noteRepository.deleteById(id);
    }

}
