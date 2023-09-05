public class UserData {

    public static boolean askParameters(String login, String password, String repeatPassword) {
       boolean askLogin;
       boolean askPassword;
       boolean checkPassword;
        try {
            askLogin = askLogin(login);
            askPassword = askPassword(password);
            checkPassword = checkPassword(password, repeatPassword);
        } catch (WrongLoginException ex) {
            System.out.println("О, боже! Я поймал гадость! Я могу запомнить логины только размером до 20 символов(включительно)!");
            return false;
        } catch (WrongPasswordException ex) {
            System.out.println("Длина пароля должна быть менее 20 символов");
            return false;
        } return askLogin&&askPassword&checkPassword;
    }

    public static boolean askLogin(String login) {
        SymbolsNLengthCheck check = new SymbolsNLengthCheck();
        if (login == null || login == "") {
            throw new NullPointerException("Логин не может быть пустым");
        } else if (check.checkLoginLength(login) == true && check.checkSymbols(login) == true) {
            System.out.println("Ваш логин принят");
            return true;
        } else {
            System.out.println("Ваш логин не принят");
            return false;
        }
    }


    public static boolean askPassword(String password) {
        SymbolsNLengthCheck check = new SymbolsNLengthCheck();
        if (password == null || password == "") {
            throw new NullPointerException("Пароль не может быть пустым");
        } else if (check.checkPasswordLength(password) == true && check.checkSymbols(password) == true) {
            System.out.println("Ваш пароль соответствует правилам");
            return true;
        } else System.out.println("Ваш пароль не соответствует правилам");
        return false;
    }
    public static boolean checkPassword(String password, String repeatPassword) {
        if (repeatPassword == null || repeatPassword == "") {
            throw new NullPointerException("Повторите пароль");

        } else if (password.equals(repeatPassword)) {
            System.out.println("Ваши пароли совпадают, пароль принят");
            return true;
        } else {
            System.out.println("Пароли не совпадают");
            return false;
        }
    }
}


