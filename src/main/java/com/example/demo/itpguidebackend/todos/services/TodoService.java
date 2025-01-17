package com.example.demo.itpguidebackend.todos.services;

import com.example.demo.itpguidebackend.todos.models.Todo;
import com.example.demo.itpguidebackend.todos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public String addTodo(Todo todo) {
        todoRepository.save(todo);
        return "Todo with id " + todo.getId() + " successfully saved.";
    }

    public String deleteTodo(int id) {
        todoRepository.deleteById(id);
        return "Todo with id " + id + " successfully deleted.";
    }

    public String updateTodo(Todo todo, int id) {
        Todo existingTodo = todoRepository.findById(id).orElse(null);
        existingTodo.setDescription(todo.getDescription());
        existingTodo.setStatus(todo.getStatus());
        todoRepository.save(existingTodo);

        return "Todo with id " + todo.getId() + " successfully updated.";
    }

}
