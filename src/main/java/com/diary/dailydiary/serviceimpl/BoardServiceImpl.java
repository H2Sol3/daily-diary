package com.diary.dailydiary.serviceimpl;

import com.diary.dailydiary.dao.BoardDAO;
import com.diary.dailydiary.dao.CommentDAO;
import com.diary.dailydiary.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDAO boardDAO;

    @Autowired
    CommentDAO commentDAO;



}
