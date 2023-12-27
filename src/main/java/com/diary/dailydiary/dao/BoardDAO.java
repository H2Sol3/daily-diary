package com.diary.dailydiary.dao;

import com.diary.dailydiary.dto.BoardDTO;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {
    int getBoardCount(int userSeq);

    List<BoardDTO> getBoardList(HashMap<String, Integer> map);
}
