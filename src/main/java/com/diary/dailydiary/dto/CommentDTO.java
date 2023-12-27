package com.diary.dailydiary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    int commentSeq, boardSeq, userSeq, secret, recomment, recommentSeq;
    String content, date;
}
