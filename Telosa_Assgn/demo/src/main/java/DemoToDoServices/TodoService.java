package DemoToDoServices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Entity.Todo;

@Service
public class TodoService {
    private final List<Todo> todos = new ArrayList<>();

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public void removeTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public void toggleTodoCompletion(int id) {
        todos.stream().filter(todo -> todo.getId() == id)
            .findFirst()
            .ifPresent(todo -> todo.setCompleted(!todo.isCompleted()));
    }
}

