package com.example.rv.impl.editor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EditorMapperImpl implements EditorMapper {
    @Override
    public EditorRequestTo editorToRequestTo(Editor editor) {
        return new EditorRequestTo(editor.getId(),
                editor.getLogin(),
                editor.getPassword(),
                editor.getFirstname(),
                editor.getLastname());
    }

    @Override
    public List<EditorRequestTo> editorToRequestTo(Iterable<Editor> editors) {
        return StreamSupport.stream(editors.spliterator(), false)
                .map(this::editorToRequestTo)
                .collect(Collectors.toList());
    }

    @Override
    public Editor dtoToEntity(EditorRequestTo editorRequestTo) {
        return new Editor(editorRequestTo.id(),
                editorRequestTo.login(),
                editorRequestTo.password(),
                editorRequestTo.firstname(),
                editorRequestTo.lastname());
    }

    @Override
    public List<Editor> dtoToEntity(Iterable<EditorRequestTo> editorRequestTos) {
        return StreamSupport.stream(editorRequestTos.spliterator(), false)
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public EditorResponseTo editorToResponseTo(Editor editor) {
        return new EditorResponseTo(editor.getId(),
                editor.getLogin(),
                editor.getFirstname(),
                editor.getLastname());
    }

    @Override
    public List<EditorResponseTo> editorToResponseTo(Iterable<Editor> editors) {
        return StreamSupport.stream(editors.spliterator(), false)
                .map(this::editorToResponseTo)
                .collect(Collectors.toList());
    }
}
