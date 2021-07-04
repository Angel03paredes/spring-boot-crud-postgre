package com.project.crudusers.repository;

import com.project.crudusers.entity.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<NotesEntity,Long> {
}
