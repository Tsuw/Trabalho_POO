package com.jogos.api.service;

import com.jogos.api.dto.UserDTO;
import com.jogos.api.model.UserEntity;
import com.jogos.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service

public class UserService {

    @Autowired
    private UserRepository userInterfaceRepo;

    private UserEntity login = new UserEntity();

    private static final String PASSWORD_PATTERN = "^.*(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%]).{6,}.*$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    public int signup(UserDTO user) {

        UserEntity entity = new UserEntity();

        if (!validateName(user.getName())) {
            return 1;
        }
        if (validateEmail(user.getEmail()) == 1) {
            return 2;
        }
        if (validatePassword(user.getPassword()) == false) {
            return 3;
        }

        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());

        userInterfaceRepo.save(entity);

        return 0;
    }

    public int login(UserDTO user) {

        String filter = user.getEmail() != null ? user.getEmail() : "";
        Optional<UserEntity> entity = userInterfaceRepo.findByEmailIgnoreCase(filter);

        if (entity.isPresent()) {
            UserEntity enty = entity.get();

            if (!enty.getPassword().equals(user.getPassword())) {
                return 1;
            }

            login.setId(enty.getId());
            login.setName(enty.getName());
            login.setEmail(enty.getEmail());
            login.setPassword(enty.getPassword());

            return 2;
        } else {
            return 3;
        }

    }

    public int loginConferer() {

        int retorno;
        retorno = ADMConferer();

        if (this.login.getEmail() == null) {
            return 1;
        } else if (retorno == 1) {
            return 2;
        } else {
            return 0;
        }
    }

    public UserEntity converter(UserDTO dto) {
        UserEntity entity = new UserEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());

        return entity;
    }

    private boolean validatePassword(String senha) {
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }

    private int validateEmail(String email) {

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

        if (!matcher.find()) {
            return 1;
        }

        return 0;
    }

    private boolean validateName(String name) {

        if (name.trim().equals("") || name.trim().split(" ").length < 2) {
            return false;
        } else {
            return true;
        }
    }

    private int ADMConferer() {

        if (this.login.getEmail().equals("adm@gmail.com") && this.login.getPassword().equals("@Bbr1rr")) {
            return 1;
        } else {
            return 0;
        }
    }
}
