package com.jogos.api.dto;

import com.jogos.api.model.Requirements;

public class RequirementsDTO {

    private String so;
    private String gpu;
    private String cpu;
    private String ram;
    private String directX;
    private String storage;
    private String soundCard;

    public RequirementsDTO(Requirements enty) {
        this.so = enty.getSo();
        this.gpu = enty.getGpu();
        this.cpu = enty.getCpu();
        this.ram = enty.getRam();
        this.directX = enty.getRam();
        this.storage = enty.getRam();
        this.soundCard = enty.getSoundCard();
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
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
