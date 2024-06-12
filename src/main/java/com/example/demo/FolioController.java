package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador que maneja las solicitudes HTTP para la generación del digest.
 */
@RestController
public class FolioController {

    /**
     * Endpoint que recibe un parámetro 'folio' y retorna un JSON con el digest.
     *
     * @param folio el parámetro de entrada de tipo String.
     * @return un mapa con el digest generado.
     */
    @GetMapping("/digest")
    public Map<String, String> getDigest(@RequestParam String folio) {
        // Formatear la fecha y hora actual en el formato ddMMyyHHmmss
        String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmmss"));

        // Concatenar el folio con la fecha y hora formateada
        String value = folio + formattedDate;

        // Generar el digest utilizando el método hashCode de la clase String
        String digest = Integer.toString(value.hashCode());

        // Crear la respuesta como un mapa
        Map<String, String> response = new HashMap<>();
        response.put("digest", digest);

        // Retornar la respuesta
        return response;
    }
}