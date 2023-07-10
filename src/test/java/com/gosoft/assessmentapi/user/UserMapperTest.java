package com.gosoft.assessmentapi.user;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

    @Test
    public void mapToRecords() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail("kuankeehan@gosoft.co.th");
        user.setPassword("1234");

        UserLoginResponse userLoginResponse = UserLoginMapper.MAPPER.toResponse(user);

        assertThat(userLoginResponse).isNotNull();
        assertThat(userLoginResponse.email()).isEqualTo("kuankeehan@gosoft.co.th");
    }
}
