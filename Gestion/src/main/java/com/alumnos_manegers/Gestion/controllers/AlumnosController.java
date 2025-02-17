package com.alumnos_manegers.Gestion.controllers;

import com.alumnos_manegers.Gestion.domain.Alumno;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/alumnos")
public class AlumnosController {
    //Creacion de lista de alumnos.
    private List<Alumno> alumnos = new ArrayList<>(Arrays.asList(
            new Alumno(1, "Juan Pérez", "juan.perez@example.com", 20, "Matemáticas"),
            new Alumno(2, "María López", "maria.lopez@example.com", 22, "Física"),
            new Alumno(3, "Carlos Gómez", "carlos.gomez@example.com", 21, "Programación"),
            new Alumno(4, "Ana Martínez", "ana.martinez@example.com", 23, "Química"),
            new Alumno(5, "Luis Fernández", "luis.fernandez@example.com", 19, "Biología"),
            new Alumno(6, "Sofía Ramírez", "sofia.ramirez@example.com", 24, "Historia"),
            new Alumno(7, "Diego Torres", "diego.torres@example.com", 20, "Ingeniería"),
            new Alumno(8, "Elena Sánchez", "elena.sanchez@example.com", 22, "Literatura"),
            new Alumno(9, "Pedro Jiménez", "pedro.jimenez@example.com", 21, "Economía"),
            new Alumno(10, "Lucía Herrera", "lucia.herrera@example.com", 23, "Psicología")
    ));

    //Creacion de Endponist.
    //Mostrar todos los alumnos.
    @GetMapping
    public List<Alumno> getAlumnos(){
        return alumnos;
    }

    //Consultar por email.
    @GetMapping("/{email}")
    public Alumno getAlumno(@PathVariable String email){
        for (Alumno a : alumnos){
            if (a.getEmail().equalsIgnoreCase(email)){
                return a;
            }
        }
        return null;
    }

    //Crear nuevo alumno.
    @PostMapping
    public Alumno postAlumno(@RequestBody Alumno alumno){
        alumnos.add(alumno);
        return alumno;
    }

    //Modificacion de información de un alumno
    @PutMapping
    public Alumno putAlumno(@RequestBody Alumno alumno){
        for (Alumno a : alumnos){
            if (a.getId() == alumno.getId()) {
                a.setName(alumno.getName());
                a.setEmail(alumno.getEmail());
                a.setEdad(alumno.getEdad());
                a.setCourse(alumno.getCourse());

                return a;
            }
        }
        return null;
    }

    //Modificacion parcial de un alumno
    @PatchMapping
    public Alumno patchAlumno(@RequestBody Alumno alumno){
        for (Alumno a : alumnos){
            if (a.getId() == alumno.getId()){
                if (alumno.getName() != null){
                    a.setName(alumno.getName());
                }
                if (alumno.getEmail() != null){
                    a.setEmail(alumno.getEmail());
                }
                if (alumno.getEdad() != 0){
                    a.setEdad(alumno.getEdad());
                }
                if (alumno.getCourse() != null){
                    a.setCourse(alumno.getCourse());
                }

                return a;
            }
        }
        return null;
    }

    //Metodo para eliminar alumno.
    @DeleteMapping("/{id}")
    public Alumno deleteAlumno(@PathVariable int id){
        for (Alumno a : alumnos){
            if (a.getId() == id){
                alumnos.remove(a);

                return a;
            }
        }
        return null;
    }


}


