public class AplikasiTodoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

//        testShowTodoList();
//        testAddTodoList();
//        testRemoveTodoList();

        testInput();
    }

    public static void showTodoList() {
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
        System.out.println(info + " : ");
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
            System.out.println("3. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Pilhan tidak tersedia");
            }
        }
    }

    public static void viewAddTodoList() {

    }

    public static void viewRemoveTodoList() {

    }


}
