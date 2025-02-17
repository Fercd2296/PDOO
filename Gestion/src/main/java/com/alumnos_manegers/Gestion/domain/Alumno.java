package com.alumnos_manegers.Gestion.domain;

public class Alumno {
    //Creacion de atributos de alumno.
    private int id;
    private String name;
    private String email;
    private int edad;
    private String  course;

    //Contructor
    public Alumno(int id, String name, String email, int edad, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.edad = edad;
        this.course = course;
    }

    //Metodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
