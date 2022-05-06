package com.study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachDTO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean fileType; // 이미지 1, 아니면 0
}
