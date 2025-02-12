package com.example.demo.Services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.TaskModel;
import com.example.demo.Repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public ArrayList<TaskModel> obtenerTasks(){
        return (ArrayList<TaskModel>) taskRepository.findAll();
    }
    public Optional<TaskModel>  obtenerTask(Long id){
        return taskRepository.findById(id);
    }
    public TaskModel crearTarea(TaskModel Task){
        return taskRepository.save(Task);
    }
    public TaskModel cambiarEstado(Long id){
        Optional<TaskModel> tareaOptional = taskRepository.findById(id);

        if(tareaOptional.isPresent()){
            TaskModel task = tareaOptional.get();
            task.setCompletado(!task.getCompletado());
            return taskRepository.save(task);
        }else{
            return null;
        }
    }
    public boolean eliminarTask(Long id){
        try{
            taskRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
    
}
