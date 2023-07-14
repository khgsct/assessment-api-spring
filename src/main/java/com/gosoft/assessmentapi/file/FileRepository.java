package com.gosoft.assessmentapi.file;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FileRepository extends CrudRepository<File, UUID> {
}
