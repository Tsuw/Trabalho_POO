    package com.jogos.api.model;

    import javax.persistence.*;

    //banco de dados H2
    //ir no resources->application.properties

    //representa uma tabela
    @Entity
    @Table(name = "Users")
    public class UserEntity{

        @Column(name = "NAME", nullable = false)
        private String name;

        @Column(name = "EMAIL", nullable = false)
        private String email;

        @Column(name = "PASSWORD", nullable = false)//not null no MySQL
        private String password;

        @Id
        @Column(name= "ID", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto increment
        private Long id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
