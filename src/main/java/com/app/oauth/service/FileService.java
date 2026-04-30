package com.app.oauth.service;

import com.app.oauth.domain.dto.response.ApiResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    // 파일 1개
    public ApiResponseDTO uploadFile(MultipartFile uploadFile);

    // 파일 여러개
    public ApiResponseDTO uploadFiles(List<MultipartFile> uploadFiles);

    public byte[] getDisplayPath(String fileName);
}
