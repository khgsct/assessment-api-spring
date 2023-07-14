package com.gosoft.assessmentapi.file;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

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
    @Column(length = 10000000)
    private byte[] data;
}
