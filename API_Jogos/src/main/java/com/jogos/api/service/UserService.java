    package com.jogos.api.service;

    import com.jogos.api.dto.UserDTO;
    import com.jogos.api.model.UserEntity;
    import com.jogos.api.repository.UserInterfaceRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    @Service

    public class UserService {

        @Autowired
        private UserInterfaceRepository userInterfaceRepo;

        public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


        public int signup(UserDTO user){

            UserEntity entity = new UserEntity();

            if(validateName(user.getName())==false){
                return 1;
            }
            if(validateEmail(user.getEmail()) == 1){
                return 2;
            }
            if(validatePassword(user.getPassword())==false){
                return 3;
            }

            entity.setId(user.getId());
            entity.setName(user.getName());
            entity.setEmail(user.getEmail());
            entity.setPassword(user.getPassword());

            userInterfaceRepo.save(entity);

            return 0;
        }

        public UserEntity converter(UserDTO dto){
            UserEntity entity = new UserEntity();

            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());
            entity.setPassword(dto.getPassword());

            return entity;
        }

        private boolean validatePassword(String senha){//executar um método passando por cima da classe pai = polimorfismo
           if(senha.length() < 4){
               return false;
               //pelo menos 2 numeros e 1 caracter maiusculo e minusculo
           }else{
               return true;
           }
        }

        private int validateEmail(String email){

            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

            if(!matcher.find()){
                return 1;
            }

            return 0;
        }

        private boolean validateName(String name){

            if(name.trim().equals("") || name.trim().split(" ").length < 2){
                return false;
            }else{
                return true;
            }
        }

        /*public List<UserDTO> getUsers(String name) {
            String filter = name != null ? name : "";
            Optional<List<UserEntity>> result = userInterfaceRepo.findByNameContaining(filter);

            List<UserDTO> lst = new ArrayList<>();

            if (result.isPresent()) {
                List<UserEntity> users = result.get();
                for (UserEntity u : users) {
                    UserDTO dto = new UserDTO(u.getId(), u.getName(), u.getEmail(), u.getPassword());
                    lst.add(dto);
                }
            }

            return lst;
        }*/

        //professor usou isso no fim da aula

    }
