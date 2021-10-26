package com.jogos.api.model;

import javax.persistence.*;

@Entity
@Table(name = "requirements")
public class Requirements {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SO", nullable = false)
    private String so;

    @Column(name = "GPU", nullable = false)
    private String gpu;

    @Column(name = "CPU", nullable = false)
    private String cpu;

    @Column(name = "RAM", nullable = false)
    private String ram;

    @Column(name = "DirectX", nullable = false)
    private String directX;

    @Column(name = "storage", nullable = false)
    private String storage;

    @Column(name = "soundCard")
    private String soundCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String SO) {
        this.so = SO;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String GPU) {
        this.gpu = GPU;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String CPU) {
        this.cpu = CPU;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String RAM) {
        this.ram = RAM;
    }

    public String getDirectX() {
        return directX;
    }

    public void setDirectX(String directX) {
        this.directX = directX;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(String soundCard) {
        this.soundCard = soundCard;
    }
}
