package com.diary.dailydiary.service;


import com.diary.dailydiary.dto.DiaryDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface DiaryService {
    int getBoardCount(int userSeq);

    List<DiaryDTO> getBoardList(HashMap<String,Integer> map);

    void insertBoard(DiaryDTO diaryDTO);

    DiaryDTO getDiary(int boardSeq);

    void deleteDiary(int boardSeq);

    void updateDiary(DiaryDTO diaryDTO);

    ArrayList<DiaryDTO> getDiaryListByText(String text);
}
