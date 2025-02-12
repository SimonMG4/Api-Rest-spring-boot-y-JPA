package com.example.demo.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Models.TaskModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public ArrayList<TaskModel> obtenerTasks(){
        return taskService.obtenerTasks();
    }
    @GetMapping(path = "/{id}")
    public Optional<TaskModel> obtenerTask(@PathVariable("id") Long id){
        return this.taskService.obtenerTask(id);
    }
    @PostMapping
    public TaskModel crearTarea(@RequestBody TaskModel Task){
        return this.taskService.crearTarea(Task);
    }
    @PutMapping("/{id}")
    public TaskModel cambiarEstado(@PathVariable Long id) {
       return taskService.cambiarEstado(id);
    }
    @DeleteMapping(path = "/{id}")
    public String eliminarTask(@PathVariable("id") Long id){
        boolean ok = this.taskService.eliminarTask(id);
        if (ok){
            return "Se elimino la tarea con id " + id;
        }else{
            return "No se pudo eliminar el usuario con id " + id;
        }
    }

    
    
    
}
