package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPatch;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductoPatchSrevice implements IProductoPatch{
    
    private final IProductoRepository productoRepository;

    @Override
    public Producto patchProducto(Long id, ProductoResponseDto dto) {
        Producto producto = productoRepository.findById(id).orElse(null);
        if(producto != null){
            if(dto.getNombre() != null){
                producto.setNombre(dto.getNombre());
            }
            if(dto.getCodigo() != null){
                producto.setCodigo(dto.getCodigo());
            }
            if(dto.getDescripcion() != null){
                producto.setDescripcion(dto.getDescripcion());
            }
            if(dto.getPrecio() != null){
                producto.setPrecio(dto.getPrecio());
            }
            if(dto.getStock() != null){
                producto.setStock(dto.getStock());
            }
            
        } 
        productoRepository.save(producto);
        return producto;
    }
}
