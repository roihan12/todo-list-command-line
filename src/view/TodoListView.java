package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true) {
            todoListService.showTodoList();

            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");
            if (input.equals("1")) {
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilhan tidak tersedia");
            }
        }
    }


    public void addTodoList() {
        System.out.println("MENAMBAH TODO LIST");

        var todo = InputUtil.input("Todo (x Jika Batal)");

        if (todo.equals("x")) {

        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("MENGHAPUS TODO LIST");

        var number = InputUtil.input("Nomor yang Dihapus (x Jika Batal)");

        if (number.equals("x")) {

        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }

}
