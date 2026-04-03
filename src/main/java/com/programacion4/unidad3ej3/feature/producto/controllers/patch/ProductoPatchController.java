package com.programacion4.unidad3ej3.feature.producto.controllers.patch;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPatch;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoPatchController {
    
    private final IProductoPatch productoPatchService;

    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductoResponseDto>> patch(@PathVariable long id, @RequestBody ProductoResponseDto dto){
        
        return ResponseEntity.status(200).body(
            BaseResponse.ok(
                ProductoMapper.toResponseDto(productoPatchService.patchProducto(id, dto)),
                "Producto actualizado correctamente"
            )
        );
    }
}
