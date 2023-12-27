package com.diary.dailydiary.serviceimpl;

import com.diary.dailydiary.dao.CommentDAO;
import com.diary.dailydiary.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDAO commentDAO;


}
