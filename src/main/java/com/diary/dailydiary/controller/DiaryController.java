package com.diary.dailydiary.controller;

import com.diary.dailydiary.dto.DiaryDTO;
import com.diary.dailydiary.service.DiaryService;
import com.diary.dailydiary.service.CommentService;
import com.diary.dailydiary.service.UserService;
import jakarta.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/daily-list")
public class DiaryController {

    @Autowired
    @Qualifier("diaryService")
    DiaryService diaryService;

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @Autowired
    @Qualifier("commentService")
    CommentService commentService;

    //글 목록
    @GetMapping(path = "/{page}")
    public ModelAndView diary(@PathVariable("page") int page) {
        ModelAndView mv = new ModelAndView();
        int userSeq = 1;//임시 번호
        int boardCnt = diaryService.getBoardCount(userSeq);
        int limit = (page - 1) * 10; //페이징

        HashMap<String, Integer> map = new HashMap<>();
        map.put("userSeq", userSeq);
        map.put("limit", limit);

        List<DiaryDTO> boardList = diaryService.getBoardList(map);

        mv.addObject("boardList", boardList);
        mv.setViewName("diary/list");

        return mv;
    }

    //다이어리 작성 폼
    @GetMapping(path = "/diaryForm")
    public String form() {
        return "diary/form";
    }

    //다이어리 작성
    @PostMapping(path = "/diary")
    public String insertDiary(@RequestParam(value = "file", required = false) MultipartFile file,
                              RedirectAttributes redirectAttributes, @Valid DiaryDTO diaryDTO, BindingResult result) {
        //세션값으로 변경 필요
        diaryDTO.setUserSeq(1);

        //유효성 검사 수정 필요
        if (result.hasErrors()) {
            System.out.print(result);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.diaryDTO", result);
//            redirectAttributes.addFlashAttribute("diaryDTO", diaryDTO);
            return "redirect:/daily-list/diaryForm";
            // 유효성 검사 실패 시 처리
//            result.reject("overMaxTotalPrice",
//                    "글로벌 에러 발생 : 가격 * 수량이 5억이 넘을 수 없습니다. 입력값 : ");
//        }
//            redirectAttributes.addFlashAttribute("message", "게시글 등록에 실패하였습니다.");

        }

        try {
            // 업로드된 파일을 저장할 디렉토리 생성
            if (file != null && !file.isEmpty()) {
                // 업로드된 파일을 저장할 디렉토리 생성
                File uploadDir = new File("src/main/resources/static/uploads");
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                // 업로드된 파일을 실제 디렉토리에 저장
                File uploadedFile = new File(uploadDir.getAbsolutePath(), file.getOriginalFilename());
                file.transferTo(uploadedFile);

                // 파일 업로드 성공 시 메시지 전달
                diaryDTO.setFileName(uploadedFile.getName());
                diaryDTO.setFilePath(uploadedFile.getPath());
            }

            //일기 작성
            diaryService.insertBoard(diaryDTO);

            //redirectAttributes.addFlashAttribute("message", "파일과 게시글이 성공적으로 업로드 되었습니다!");

            return "redirect:/daily-list/1";

        } catch (IOException e) {
            // 파일 업로드 실패 시 에러 메시지 전달
            //redirectAttributes.addFlashAttribute("message", "파일 업로드에 실패하였습니다.: " + e.getMessage());
            return "redirect:/daily-list/diaryForm";
        }

        //   return "redirect:/daily-list/1";
    }

    //다이어리 상세보기
    @GetMapping(path = "/diary/{boardSeq}")
    public ModelAndView detailDiary(@PathVariable("boardSeq") int boardSeq) {
        ModelAndView mv = new ModelAndView();
        DiaryDTO diaryDTO = diaryService.getDiary(boardSeq);
        mv.addObject("diaryDTO", diaryDTO);
        mv.setViewName("diary/detail");
        return mv;
    }

    //   다이어리 수정폼
    @GetMapping(path = "/diaryForm/{boardSeq}")
    public ModelAndView updateForm(@PathVariable("boardSeq") int boardSeq) {
        ModelAndView mv = new ModelAndView();
        DiaryDTO diaryDTO = diaryService.getDiary(boardSeq);
        mv.addObject("diaryDTO", diaryDTO);
        mv.setViewName("diary/updateForm");
        return mv;
    }

    //다이어리 수정
    @ResponseBody
    @PutMapping(path = "/diary")
    public String updateDiary(@RequestParam(value = "file", required = false) MultipartFile file, DiaryDTO diaryDTO)
            throws IOException {

        System.out.println(diaryDTO.getTitle());
        System.out.println(diaryDTO.getContent());
        System.out.println(diaryDTO.getFileName());

        DiaryDTO originDTO = diaryService.getDiary(diaryDTO.getBoardSeq());

        if (file == null) {
            //새 파일이 없을 때
            diaryDTO.setFileName(originDTO.getFileName());
            diaryDTO.setFilePath(originDTO.getFilePath());
        } else {
            //새 파일이 있을 때
//            if (originDTO.getFilePath() != null) {
//                File newFile = new File(originDTO.getFilePath());
//
//                if (newFile.exists()) { // 파일이 존재하면
//                    newFile.delete(); // 파일 삭제
//                }
//            }
            File uploadDir = new File("src/main/resources/static/uploads");
            File saveFile = new File(uploadDir.getAbsolutePath(), file.getOriginalFilename());
            file.transferTo(saveFile);
            diaryDTO.setFileName(saveFile.getName());
            diaryDTO.setFilePath(saveFile.getPath());
        }

//            System.out.println(diaryDTO.getFileName());
            diaryService.updateDiary(diaryDTO);
        // JSON 응답을 위한 Map 생성
//        Map<String, String> response = new HashMap<>();
//        response.put("status", "success");
//
//        // 리다이렉트할 URL을 설정 (원하는 URL로 수정)
//        response.put("redirectUrl", "/daily-list/diaryForm/" + diaryDTO.getBoardSeq());

        return "success";

            // JSON 응답을 위한 Map 생성
//            Map<String, String> response = new HashMap<>();
//            response.put("status", "success");
//
//            // 리다이렉트할 URL을 설정 (원하는 URL로 수정)
//            response.put("redirectUrl", "/daily-list/1");

//            return response;
        }

        //다이어리 삭제
        @ResponseBody
        @DeleteMapping(path = "/diary/{boardSeq}")
        public String deleteDiary ( @PathVariable("boardSeq") int boardSeq){
            diaryService.deleteDiary(boardSeq);
            return "success";
        }

}

