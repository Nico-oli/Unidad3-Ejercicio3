package com.programacion4.unidad3ej3.feature.producto.controllers.put;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPut;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoPutController {

    private final IProductoPut productoPutService;

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductoResponseDto>> putController(
        @PathVariable long id,
        @Valid @RequestBody ProductoUpdateRequestDto dto
    ){
        return ResponseEntity.status(200).body(
            BaseResponse.ok(
                productoPutService.put(id,dto),
                "Producto actualizado correctamente"
            )
        );
    }
}
