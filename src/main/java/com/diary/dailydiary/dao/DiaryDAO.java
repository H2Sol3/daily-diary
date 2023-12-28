package com.diary.dailydiary.dao;

import com.diary.dailydiary.dto.DiaryDTO;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DiaryDAO {
    int getBoardCount(int userSeq);

    List<DiaryDTO> getBoardList(HashMap<String, Integer> map);

    void insertBoard(DiaryDTO diaryDTO);

    DiaryDTO getDiary(int boardSeq);

    void deleteDiary(int boardSeq);
}
