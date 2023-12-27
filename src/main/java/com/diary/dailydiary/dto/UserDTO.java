package com.diary.dailydiary.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int userSeq;
    private String nickName, password, email;
}
