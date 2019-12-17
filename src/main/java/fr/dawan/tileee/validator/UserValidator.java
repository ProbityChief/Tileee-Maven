package fr.dawan.tileee.validator;

import java.sql.Connection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.dawan.tileee.dao.ConnectionDB;
import fr.dawan.tileee.dao.UserDao;
import fr.dawan.tileee.bean.User;

public class UserValidator {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean eMailValidate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }


    public static String userValidator(String email, String password, boolean validation){
        String message = "";
        if(password.equals("")) {
            message += "password|";
        }
        if(email.equals("")) {
            message += "emailNotNull|";
        }
        if(!eMailValidate(email)) {
            message += "invalidEmail|";
        }
        
         
        if(!validation) { 
        	message += "noValidationForThisUser";
        }
        

        
        
        
        try {
            Connection cnx = ConnectionDB.getConnection();
            Boolean isMatches = UserDao.pswAndLoginMatche(email, password, cnx, false);
            if(!isMatches)
                message += "EmailAndPasswordNotCorrespondant";
        }catch(Exception e){

        }
        //System.out.println("je retourne message = " + message);
        return message;
    }

    public static String userValidator(User user, String passwordConfirmation){
        String message = "";
        if(user.getName().isEmpty())
            message += "forename";
        if(user.getPassword().isEmpty())
            message += "password";
        if(user.getMail().isEmpty())
            message += "emailNotNull";
        if(!eMailValidate(user.getMail())) {
            message += "invalidEmail";
        } else {
            try {
                Connection cnx = ConnectionDB.getConnection();
                Boolean isExist = UserDao.doesEmailExist(user.getMail(), cnx, false);
                if(isExist) {
                    message += "alreadyExistMail";
                }
            } catch(Exception e){
                System.out.println("IMPOSSIBLE D'ETABLIR LA CONNEXION");
            }
        }
        if(!user.getPassword().equals(passwordConfirmation))
            message += "errorPasswordConfirmation";
        return message;
    }
}

