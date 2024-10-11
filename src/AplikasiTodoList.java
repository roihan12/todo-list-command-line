public class AplikasiTodoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

//        testShowTodoList();
//        testAddTodoList();
//        testRemoveTodoList();
//        testInput();
//        testViewAddTodoList();
//        testViewShowTodoList();

//        testViewRemoveTodoList();

        viewShowTodoList();
    }

    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];

            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }

        }

    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi kasus java dasar aplikasi todo list";

        showTodoList();
    }


    public static void addTodoList(String todo) {


        //   cek apakah model penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        //Jika penuh kita resize ukuran array 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }

        }


        // tambahkan ke posisi yang data arraynya null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Todo ke " + i);
        }

        showTodoList();
    }

    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        }

        if (model[number - 1] == null) {
            return false;
        } else {
            model[number - 1] = null;

            for (int i = (number - 1); i < model.length; i++) {
                if (i == model.length - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }

            }
            return true;
        }

    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var userInput = input("Nama");
        System.out.println("Hi " + userInput);

        var userInput2 = input("Jurusan");
        System.out.println("Jurusan " + userInput2);
    }

    public static void updateTodoList() {

    }

    public static void viewShowTodoList() {
        showTodoList();
        while (true) {
            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilhan tidak tersedia");
            }
        }
    }


    public  static  void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("dua");
        addTodoList("tiga");

        viewShowTodoList();
    }
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODO LIST");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {

        } else  {
            addTodoList(todo);
            showTodoList();
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("dua");
        addTodoList("tiga");
        viewAddTodoList();

        showTodoList();
    }

    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODO LIST");

        var number = input("Nomor yang Dihapus (x Jika Batal)");

        if(number.equals("x")) {

        } else  {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist : " + number);
            }
            showTodoList();
        }
    }

    public  static  void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();
        viewRemoveTodoList();

        showTodoList();
    }


}
