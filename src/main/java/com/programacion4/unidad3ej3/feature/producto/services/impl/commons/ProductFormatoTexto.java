package com.programacion4.unidad3ej3.feature.producto.services.impl.commons;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.IProductFormatoTextoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductFormatoTexto implements IProductFormatoTextoService{
    @Override
    public String modificarFormatoTexto(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto; // Retorna el texto original si es nulo o vacío
        }
        // Convertir la primera letra a mayúscula y el resto a minúscula
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }
}
