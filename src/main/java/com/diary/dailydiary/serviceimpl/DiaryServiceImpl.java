package com.diary.dailydiary.serviceimpl;

import com.diary.dailydiary.dao.DiaryDAO;
import com.diary.dailydiary.dao.CommentDAO;
import com.diary.dailydiary.dto.DiaryDTO;
import com.diary.dailydiary.service.DiaryService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    DiaryDAO diaryDAO;

    @Autowired
    CommentDAO commentDAO;


    @Override
    public int getBoardCount(int userSeq) {
        return diaryDAO.getBoardCount(userSeq);
    }

    @Override
    public List<DiaryDTO> getBoardList(HashMap<String, Integer> map) {
        return diaryDAO.getBoardList(map);
    }

    @Override
    public void insertBoard(DiaryDTO diaryDTO) {
        diaryDAO.insertBoard(diaryDTO);
    }

    @Override
    public DiaryDTO getDiary(int boardSeq) {
        return diaryDAO.getDiary(boardSeq);
    }

    @Override
    public void deleteDiary(int boardSeq) {
        diaryDAO.deleteDiary(boardSeq);
    }

    @Override
    public void updateDiary(DiaryDTO diaryDTO) {
        diaryDAO.updateDiary(diaryDTO);
    }

    @Override
    public ArrayList<DiaryDTO> getDiaryListByText(String text) {
        return diaryDAO.getDiaryListByText(text);
    }


}
