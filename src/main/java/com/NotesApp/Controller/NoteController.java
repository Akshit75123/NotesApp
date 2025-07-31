package com.NotesApp.Controller;

import com.NotesApp.Model.Note;
import com.NotesApp.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listNotes", noteService.getAllNotes());
        return "index";
    }


    @GetMapping("/showNewNoteForm")
    public String showNewNoteForm(Model model) {
        Note note = new Note();
        model.addAttribute("note", note);
        return "new_note";
    }


    @PostMapping("/saveNote")
    public String saveNote(@ModelAttribute("note") Note note) {
        noteService.saveNote(note);
        return "redirect:/";
    }


    @GetMapping("/updateNote/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        Note note = noteService.getNoteById(id);
        model.addAttribute("note", note);
        return "update_note";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable(value = "id") Long id) {
        noteService.deleteNoteById(id);
        return "redirect:/";
    }
}
