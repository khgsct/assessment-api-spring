package com.gosoft.assessmentapi.file;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
        )
public interface FileMapper {
    FileMapper MAPPER = Mappers.getMapper(FileMapper.class);

    FileResponse toResponse(File file);
}
