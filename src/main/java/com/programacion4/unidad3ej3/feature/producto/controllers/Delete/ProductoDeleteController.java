package com.programacion4.unidad3ej3.feature.producto.controllers.Delete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("productos")
@AllArgsConstructor
public class ProductoDeleteController {

    private final IProductoDeleteService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
