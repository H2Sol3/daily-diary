package com.diary.dailydiary.controller;

import com.diary.dailydiary.dto.BoardDTO;
import com.diary.dailydiary.service.BoardService;
import com.diary.dailydiary.service.CommentService;
import com.diary.dailydiary.service.UserService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/daily-list")
public class BoardController {

    @Autowired
    @Qualifier("boardService")
    BoardService boardService;

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Autowired
    @Qualifier("commentService")
    CommentService commentService;

    //글 목록
    @GetMapping(path = "/{page}")
    public ModelAndView diary(@PathVariable("page") int page){
        ModelAndView mv = new ModelAndView();
        int userSeq= 1;//임시 번호
        int boardCnt = boardService.getBoardCount(userSeq);
        int limit = (page - 1)*10; //페이징

        HashMap<String, Integer> map = new HashMap<>();
        map.put("userSeq", userSeq);
        map.put("limit", limit);

        List<BoardDTO> boardList = boardService.getBoardList(map);

        mv.addObject("boardList", boardList);
        mv.setViewName("board/list");

        return mv;
    }

    //다이어리 작성 폼
    @GetMapping("/diary")
    public String form(){
        return "board/form";
    }

    //다이어리 작성
    @PostMapping("/diary")
    public String inserDiary(BoardDTO boardDTO){
        //세션값으로 변경 필요
        boardDTO.setUserSeq(1);
        //일기 작성
        boardService.insertBoard(boardDTO);
        return "redirect:/daily-list/1";
    }



}
