package com.diary.dailydiary.service;


import com.diary.dailydiary.dto.BoardDTO;
import java.util.HashMap;
import java.util.List;

public interface BoardService {
    int getBoardCount(int userSeq);

    List<BoardDTO> getBoardList(HashMap<String,Integer> map);
}
