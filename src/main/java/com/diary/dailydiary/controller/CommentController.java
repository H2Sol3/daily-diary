package com.diary.dailydiary.controller;

import com.diary.dailydiary.dto.CommentDTO;
import com.diary.dailydiary.service.CommentService;
import com.diary.dailydiary.service.DiaryService;
import com.diary.dailydiary.service.UserService;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/daily-list/comment")
public class CommentController {
    @Autowired
    @Qualifier("diaryService")
    DiaryService diaryService;

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Autowired
    @Qualifier("commentService")
    CommentService commentService;

//    댓글 등록
    @ResponseBody
    @PostMapping(path = "/commentDiary")
    public String commentDiary(CommentDTO commentDTO){
        System.out.println(commentDTO.getContent());
        commentService.insertComment(commentDTO);

//        map.put("status", "success");//댓글 내용 보내기
//
        return "success";
    }

//    댓글삭제
    @ResponseBody
    @DeleteMapping(path = "/{boardSeq}")
    public String deleteComment(@PathVariable("boardSeq") int boardSeq){
        commentService.deleteComment(boardSeq);
        return "success";
    }

    //댓글 수정
    @ResponseBody
    @PutMapping(path = "/{boardSeq}")
    public String updateComment(@PathVariable("boardSeq") int boardSeq, CommentDTO commentDTO){
        commentService.updateComment(commentDTO);
        return "success";
    }

}
