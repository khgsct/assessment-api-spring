package com.gosoft.assessmentapi.file;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Base64;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "FILES")
public class File {
    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private String type;
    @Lob
    @JsonSerialize(using = SqlBlobSerializer.class)
    @Column(length = 10000000)
    private byte[] data;
    private String base64;

    public String getBase64() {
        byte[] buffer = this.getData();
        return Base64.getEncoder().encodeToString(buffer);
    }
}
