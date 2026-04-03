package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPut;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoPutService implements IProductoPut{
    
    private final IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto put(Long id, ProductoUpdateRequestDto dto){

        Producto producto = productoRepository.findById(id).orElse(null);

        if(producto != null){
            producto.setNombre(dto.getNombre());
            producto.setCodigo(dto.getCodigo());
            producto.setDescripcion(dto.getDescripcion());
            producto.setPrecio(dto.getPrecio());
            producto.setStock(dto.getStock());
            productoRepository.save(producto);
            
        }
        return ProductoMapper.toResponseDto(producto);
    }
}
