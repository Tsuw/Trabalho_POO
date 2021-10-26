package com.jogos.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "GameConsole1")
public class GameConsole1 extends Neutra1Game{

    @Column(name = "storage", nullable = false)
    private String storage;

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
