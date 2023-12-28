package com.diary.dailydiary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DiaryDTO {
    private int boardSeq, userSeq,secret,viewCount;
    private String file,filePath,date;

    @NotEmpty(message = "제목을 입력하세요.")
    @NotBlank(message = "공백은 입력할 수 없습니다.")
    private String title;

    @NotEmpty(message = "내용을 입력하세요.")
    private String content;


}
