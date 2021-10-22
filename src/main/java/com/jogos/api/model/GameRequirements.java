    package com.jogos.api.model;

    import javax.persistence.*;

    @Entity
    @Table(name = "requirements")
    public class GameRequirements {

        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "SO", nullable = false)
        private String SO;

        @Column(name = "GPU", nullable = false)
        private String GPU;

        @Column(name = "CPU", nullable = false)
        private String CPU;

        @Column(name = "RAM", nullable = false)
        private String RAM;

        @Column(name = "DirectX", nullable = false)
        private String DirectX;

        @Column(name = "storage", nullable = false)
        private String storage;

        @Column(name = "soundCard", nullable = false)
        private String soundCard;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getSO() {
            return SO;
        }

        public void setSO(String SO) {
            this.SO = SO;
        }

        public String getGPU() {
            return GPU;
        }

        public void setGPU(String GPU) {
            this.GPU = GPU;
        }

        public String getCPU() {
            return CPU;
        }

        public void setCPU(String CPU) {
            this.CPU = CPU;
        }

        public String getRAM() {
            return RAM;
        }

        public void setRAM(String RAM) {
            this.RAM = RAM;
        }

        public String getDirectX() {
            return DirectX;
        }

        public void setDirectX(String directX) {
            DirectX = directX;
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
