package com.diary.dailydiary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
    private int boardSeq, userSeq,secret,viewCount;
    private String file,date;

    @NotNull(message = "제목을 입력하세요.")
    @NotBlank(message = "공백은 입력할 수 없습니다.")
    private String title;

    @NotNull(message = "내용을 입력하세요.")
    private String content;


}
