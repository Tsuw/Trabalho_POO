/*Quando executa o programa, ele procura este db.sql e executa ele dentro do banco de dados*/
/*não precisa criar database pois ela já cria sozinho*/

/*CREATE TABLE IF NOT EXISTS Users(
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Name VARCHAR (255) NOT NULL,
    Email VARCHAR (255) NOT NULL,
    Password VARCHAR (255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Games(
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR (255) NOT NULL,
    releaseDate DATE NOT NULL,
    description VARCHAR (255) NOT NULL,
    developer VARCHAR (255) NOT NULL,
    score INT NOT NULL,
    price INT NOT NULL,
    genre VARCHAR (255) NOT NULL,
    rating INT NOT NULL,
    soldCopies INT NOT NULL,
    distributor VARCHAR (255) NOT NULL,
    peopleInvolved INT NOT NULL
);*/

/*Para ver como ficou a tabela no banco de dados é só ir em View->Tool Windows->Database (no IntelliJ)*/
/*Fazer download dos drives quando for adicionar a db quando for ver a db no View->Tool Windows->Database */