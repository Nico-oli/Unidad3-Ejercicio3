package com.programacion4.unidad3ej3.feature.producto.controllers.get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGet;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoListController {

    private final IProductoGet productoGetService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ProductoResponseDto>>> getAll() {
        return ResponseEntity.status(200).body(
            BaseResponse.ok(
                productoGetService.getAll(),
                "Todos los elementos se tomaron de forma correcta."
            )
        );
    }
}