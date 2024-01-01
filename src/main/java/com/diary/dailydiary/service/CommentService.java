package com.diary.dailydiary.service;

import com.diary.dailydiary.dto.CommentDTO;
import java.util.ArrayList;

public interface CommentService {
    CommentDTO getCommentList(int boardSeq);

    void insertComment(CommentDTO commentDTO);

    void deleteComment(int boardSeq);
}

