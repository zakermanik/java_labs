class CustomException extends Exception {
    // Класс пользовательского исключения
    
    public CustomException(String message) {
        super(message);
    }
}

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            f();
        } catch (CustomException e) {
            System.out.println("Перехвачено пользовательское исключение: " + e.getMessage());
        }
    }

    public static void f() throws CustomException {
        try {
            g();
        } catch (Exception e) {
            // Перехватываем исключение, выброшенное в методе g(),
            // и выбрасываем другое пользовательское исключение
            throw new CustomException("Поймано исключение в методе f()");
        }
    }

    public static void g() throws Exception {
        // Выбрасываем пользовательское исключение
        throw new Exception("Исключение в методе g()");
    }
}
