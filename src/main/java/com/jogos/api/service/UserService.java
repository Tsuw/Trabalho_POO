package com.jogos.api.service;

import com.jogos.api.dto.UserDTO;
import com.jogos.api.model.UserEntity;
import com.jogos.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service

public class UserService {

    private final UserRepository userInterfaceRepo;

    private final UserEntity login = new UserEntity();

    private static final String PASSWORD_PATTERN = "^.*(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%]).{6,}.*$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public UserService(UserRepository userInterfaceRepo) {
        this.userInterfaceRepo = userInterfaceRepo;
    }


    public String signup(UserDTO user) {

        UserEntity entity = new UserEntity();

        if (!validateName(user.getName())) {
            return "Nome invalido";
        }
        if (!validateEmail(user.getEmail())) {
            return "email invalido";
        }
        if (!validatePassword(user.getPassword())) {
            return "senha muito curta";
        }

        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());

        userInterfaceRepo.save(entity);

        return null;
    }

    public String login(UserDTO user) {

        String filter = user.getEmail() != null ? user.getEmail() : "";
        Optional<UserEntity> entity = userInterfaceRepo.findByEmailIgnoreCase(filter);

        if (entity.isPresent()) {
            UserEntity enty = entity.get();

            if (!enty.getPassword().equals(user.getPassword())) {
                return "Login incorreto usuario não encontrado";
            }

            login.setId(enty.getId());
            login.setName(enty.getName());
            login.setEmail(enty.getEmail());
            login.setPassword(enty.getPassword());

            return null;
        } else {
            return "Login incorreto usuario não encontrado";
        }

    }

    public int alternativeLoginConferer(){
        if(this.login.getEmail() == null){
            return 1;
        }else{
            return 0;
        }
    }

    public String loginConferer(){

        int retorno;

        if(this.login.getEmail() == null){
            return "Login necessário";
        }

        retorno = ADMConferer();

        if(retorno == 1){
            return null;
        }else{
            return "Esse usuário não tem permissão para esse comando";
        }
    }

    private boolean validatePassword(String senha) {
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }

    private boolean validateEmail(String email) {

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.matches();
    }

    private boolean validateName(String name) {

        return !name.trim().equals("") && name.trim().split(" ").length >= 2;
    }

    private int ADMConferer() {

        if (this.login.getEmail().equals("adm@gmail.com") && this.login.getPassword().equals("@Bbr1rr")) {
            return 1;
        } else {
            return 0;
        }
    }
}
