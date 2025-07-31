package com.NotesApp.Service;

import com.NotesApp.Model.Note;

import java.util.List;

public interface NoteService {
    List<Note> getAllNotes();
    Note saveNote(Note note);
    Note getNoteById(Long id);
    void deleteNoteById(Long id);
}
