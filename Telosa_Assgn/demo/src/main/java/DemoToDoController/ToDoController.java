package DemoToDoController;

import org.springframework.stereotype.Controller;

import DemoToDoServices.TodoService;

@Controller
public class ToDoController {
    private final TodoService todoService;

    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public String getTodos(Model model) {
        model.addAttribute("todos", todoService.getTodos());
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String description) {
        Todo todo = new Todo();
        todo.setDescription(description);
        todoService.addTodo(todo);
        return "redirect:/";
    }

    @PostMapping("/toggle")
    public String toggleTodo(@RequestParam int id) {
        todoService.toggleTodoCompletion(id);
        return "redirect:/";
    }
}

