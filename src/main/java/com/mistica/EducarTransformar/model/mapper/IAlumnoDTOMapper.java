package com.mistica.EducarTransformar.model.mapper;

import com.mistica.EducarTransformar.model.DTO.AlumnoDTO;
import com.mistica.EducarTransformar.model.DTO.CalificacionDTO;
import com.mistica.EducarTransformar.model.DTO.ListaAlumnosDTO;
import com.mistica.EducarTransformar.model.DTO.request.AlumnoCreationRequestDTO;
import com.mistica.EducarTransformar.model.entity.Alumno;
import com.mistica.EducarTransformar.model.entity.Calificacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAlumnoDTOMapper {
    ListaAlumnosDTO toDTO(Alumno alumno);

    List<AlumnoDTO> toDTOsingular(List<Alumno> alumnos);
    List<ListaAlumnosDTO> toDTOs(List<Alumno> alumnos);

    @InheritInverseConfiguration
    Alumno toDomain(ListaAlumnosDTO listaAlumnosDTO);

    List<CalificacionDTO> toCalificacionDTOList(List<Calificacion> calificaciones);
}
