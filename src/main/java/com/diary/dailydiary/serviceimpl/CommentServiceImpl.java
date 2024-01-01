package com.diary.dailydiary.serviceimpl;

import com.diary.dailydiary.dao.CommentDAO;
import com.diary.dailydiary.dto.CommentDTO;
import com.diary.dailydiary.service.CommentService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDAO commentDAO;


    @Override
    public CommentDTO getCommentList(int boardSeq) {
        return commentDAO.getCommentList(boardSeq);
    }

    @Override
    public void insertComment(CommentDTO commentDTO) {
        commentDAO.insertComment(commentDTO);
    }
}
