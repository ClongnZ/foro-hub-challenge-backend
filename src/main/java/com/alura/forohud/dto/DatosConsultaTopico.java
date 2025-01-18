package com.alura.forohud.dto;

import java.time.LocalDateTime;

public record DatosConsultaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha_Creacion,
        boolean status,
        String autor,
        String curso
) {
}
