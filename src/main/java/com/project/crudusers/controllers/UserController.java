package com.project.crudusers.controllers;

import com.project.crudusers.entity.NotesEntity;
import com.project.crudusers.services.NoteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.project.crudusers.models.User;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.net.URI;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Controller
public class UserController {

    @Autowired
    private NoteServices noteServices;

    @GetMapping("/")
    public ModelAndView displayArticle(Map<String, Object> model) {

       List<NotesEntity> notes = this.noteServices.findAll();
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.addObject("notes",notes);
       modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {

        this.noteServices.delete(id);
        List<NotesEntity> notes = this.noteServices.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("notes",notes);
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id) {

        NotesEntity note = this.noteServices.findOne(id);
        List<NotesEntity> notes = this.noteServices.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("notes",notes);
        modelAndView.addObject("note",note);
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @PostMapping("/create")
    private RedirectView create(@ModelAttribute NotesEntity note){
        note.setCreatedAt(Date.valueOf(LocalDate.now()));
        this.noteServices.save(note);
        return new RedirectView("/");
    }

    /*    private ResponseEntity<NotesEntity> create(@RequestBody NotesEntity note){
        try {
            note.setCreatedAt(Date.valueOf(LocalDate.now()));
            NotesEntity notesEntity = this.noteServices.save(note);
            return ResponseEntity.created(new URI("/create/" + notesEntity.getId().toString())).body(notesEntity);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    private User generateUser(String title){
        return new User("Angel","angel@gmail.com",title);
    }

     */
}
