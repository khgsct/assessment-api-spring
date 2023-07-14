package com.gosoft.assessmentapi.user.contract;

import com.gosoft.assessmentapi.user.domain.User;
import com.gosoft.assessmentapi.user.viewmodel.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserLoginMapper {
    UserLoginMapper MAPPER = Mappers.getMapper(UserLoginMapper.class);

    UserResponse toResponse(User user);
}
