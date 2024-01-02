package com.diary.dailydiary.dao;

import com.diary.dailydiary.dto.CommentDTO;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommentDAO {
    CommentDTO getCommentList(int boardSeq);

    void insertComment(CommentDTO commentDTO);

    void deleteComment(int boardSeq);
}
