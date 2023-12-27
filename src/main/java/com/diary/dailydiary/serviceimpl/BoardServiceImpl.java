package com.diary.dailydiary.serviceimpl;

import com.diary.dailydiary.dao.BoardDAO;
import com.diary.dailydiary.dao.CommentDAO;
import com.diary.dailydiary.dto.BoardDTO;
import com.diary.dailydiary.service.BoardService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDAO boardDAO;

    @Autowired
    CommentDAO commentDAO;


    @Override
    public int getBoardCount(int userSeq) {
        return boardDAO.getBoardCount(userSeq);
    }

    @Override
    public List<BoardDTO> getBoardList(HashMap<String, Integer> map) {
        return boardDAO.getBoardList(map);
    }


}
