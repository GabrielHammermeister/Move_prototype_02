package com.example.move_prototype_02.Model;

public class ProfileModel {

    private String name;
    private String idade;
    private Boolean sex;

    public ProfileModel() {    }

    public ProfileModel(String name, String idade, Boolean sex) {
        this.name = name;
        this.idade = idade;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
