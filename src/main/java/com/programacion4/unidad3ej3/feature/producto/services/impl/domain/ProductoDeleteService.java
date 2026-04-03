package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.NotFoundException;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoDeleteService implements IProductoDeleteService{

    private final IProductoRepository repository;

    @Override
    public void delete(long id){
        Producto producto = repository.findById(id).orElseThrow(() -> new NotFoundException("Producto no encontrado"));
        
        producto.setEstaEliminado(true);
        repository.save(producto);
    }

}
