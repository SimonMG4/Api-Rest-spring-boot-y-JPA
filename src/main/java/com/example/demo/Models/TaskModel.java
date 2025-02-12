package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class TaskModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false )
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true) 
    private String descripcion;
    
    private boolean completado = false;

    public void setId(Long id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setCompletado(boolean completado){
        this.completado = completado;
    }
    public Long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public Boolean getCompletado(){
        return completado;
    }
}
