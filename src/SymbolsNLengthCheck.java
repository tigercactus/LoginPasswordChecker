
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolsNLengthCheck {
    public boolean checkSymbols(String login) {
        Pattern pattern = Pattern.compile("[a-zA-Z\\d_]*");
        Matcher matcher = pattern.matcher(login);
        if (matcher.matches() == true) {
            return true;
        } else {
            System.out.println("Можно использовать только английские буквы, цифры и символ подчёркивания");
            return false;
        }
    }

    public boolean checkLoginLength(String login){
        if(login.length() <=20){
            return true;
        } else {throw new WrongLoginException();
       }

    }
    public boolean checkPasswordLength(String password){
        if(password.length() <20){
            return true;
        } else throw new WrongPasswordException();
    }



}
