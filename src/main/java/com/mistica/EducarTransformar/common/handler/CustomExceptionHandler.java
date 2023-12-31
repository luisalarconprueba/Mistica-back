package com.mistica.EducarTransformar.common.handler;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex) {
        // Crear un objeto de respuesta personalizado con el mensaje de error
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.FORBIDDEN, "Access Denegado: No tienes permiso para acceder a este recurso.");

        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(Exception ex) {
        // Crear un objeto de respuesta personalizado con el mensaje de error
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.NOT_FOUND, "Recurso no encontrado: La materia solicitada no existe.");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ElementAlreadyInException.class)
    public ResponseEntity<Object> handleAlumnoAlreadyInMateriaException(Exception ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.CONFLICT, "El elemento ya existe");
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(EmptyField.class)
    public ResponseEntity<Object> handleEmptyField(Exception ex){
        CustomErrorResponse errorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST, "Campos vacios");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}

