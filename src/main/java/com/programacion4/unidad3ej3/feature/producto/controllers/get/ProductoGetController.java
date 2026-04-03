package com.programacion4.unidad3ej3.feature.producto.controllers.get;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGet;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoGetController {

    private final IProductoGet productoGetService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductoResponseDto>> getForId(@PathVariable long id) {
        ProductoResponseDto dto = productoGetService.getForId(id);

        return ResponseEntity.ok(
                BaseResponse.ok(
                        dto,
                        "Producto obtenido"
                )
        );
    }
}
