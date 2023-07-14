package com.gosoft.assessmentapi.file;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    private final FileRepository imageRepository;

    public FileService(FileRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public File uploadPicture(MultipartFile multipartFile) throws IOException {
        var compressdFile = FileHelper.compressImage(multipartFile.getBytes());
        var file = imageRepository.save(File.builder()
                .name(multipartFile.getOriginalFilename())
                .type(multipartFile.getContentType())
                .data(compressdFile).build());

        return file;
    }
}
