package service;

import entity.Todolist;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public void showTodoList() {
        Todolist[] model = todoListRepository.getAll();

        System.out.println("TODOLIST");

        for (var i = 0; i < model.length; i++) {
            var todoList = model[i];

            var no = i + 1;

            if (todoList != null) {
                System.out.println(no + ". " + todoList.getTodo());
            }

        }

    }

    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("Sukses Menambah Todo : " + todo);
    }

    
    @Override
    public void removeTodoList(Integer number) {

        boolean success = todoListRepository.remove(number);

        if(success) {
            System.out.println("SUKSES MENGHAPUS TODO : " + number);
        } else {
            System.out.println("GAGAL MENGHAPUS TODO : " + number);
        }
    }

}
