package com.project.emazon.emazon.domain.exception;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidCategoryExceptionTest {
    @Test
    void testGetErrors() {
        // Crea los errores de validación
        ValidationError error1 = new ValidationError("name", "Invalid name");
        ValidationError error2 = new ValidationError("description", "Invalid description");

        // Crea la excepción pasando un mensaje y la lista de errores
        InvalidCategoryException exception = new InvalidCategoryException("Validation failed", Arrays.asList(error1, error2));

        // Verifica que la excepción contenga los errores esperados
        assertEquals(2, exception.getErrors().size());
        assertEquals("Invalid name", exception.getErrors().get(0).getMessage());
        assertEquals("Invalid description", exception.getErrors().get(1).getMessage());
    }
}
