/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package org.uv.TCSWPractica05;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author meli
 */


//tarea hacer el modificar y eliminar
@RestController
@RequestMapping("/empleados")
public class ControllerEmpleados {
    
    @Autowired
    private RepositoryEmpleados repositoryEmpleados;
    
    @GetMapping()
    public List<Empleados> list() {
        return repositoryEmpleados.findAll();
    }
    
    @GetMapping("/{id}")
    public Empleados get(@PathVariable Long id) {
        Optional<Empleados> optionalEmpleado=repositoryEmpleados.findById(id);
        if(!optionalEmpleado.isEmpty())
            return optionalEmpleado.get();
        else
            return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Empleados> put(@PathVariable Long id, @RequestBody Empleados empActualizado) {
        
       Optional<Empleados> optionalEmpleado = repositoryEmpleados.findById(id);

        if (optionalEmpleado.isPresent()) {
            Empleados emp = optionalEmpleado.get();
            emp.setNombre(empActualizado.getNombre());
            emp.setDireccion(empActualizado.getDireccion());
            emp.setTelefono(empActualizado.getTelefono());
            repositoryEmpleados.save(emp);
            return ResponseEntity.ok(emp);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public ResponseEntity<Empleados> post(@RequestBody Empleados emp) {
        Empleados empNew=repositoryEmpleados.save(emp);
        return ResponseEntity.ok(empNew);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Empleados> optionalEmpleado = repositoryEmpleados.findById(id);
        if (optionalEmpleado.isPresent()) {
            repositoryEmpleados.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
         //captura cualquier Exception y envía una respuesta
    }
    
}
