package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGet;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoGetService implements IProductoGet {

    private final IProductoRepository productoRepository;

    @Override
    public List<ProductoResponseDto> getAll(){
        List<Producto> productos = new ArrayList<>();
        productoRepository.findAll().forEach(productos::add);

        List<ProductoResponseDto> response = ProductoMapper.toResponseDtoList(productos);

        return response;
    }

    @Override
    public ProductoResponseDto getForId(long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con id " + id + " no encontrado"));
        return ProductoMapper.toResponseDto(producto);
    }
}
