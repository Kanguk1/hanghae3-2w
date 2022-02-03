package com.sparta.week33.week33.controller;

import com.sparta.week33.week33.domain.Memo;
import com.sparta.week33.week33.repository.MemoRepository;
import com.sparta.week33.week33.dto.MemoRequestDto;
import com.sparta.week33.week33.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    //생성
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {  //@RequestBody 완전중요★★
        System.out.println("pla4y");
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    //조회
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    //수정
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        System.out.println("play3");
        memoService.update(id, requestDto);
        return id;
    }

    //삭제
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        System.out.println("play2");
        memoRepository.deleteById(id);
        return id;
    }

    //새 글 작성페이지 이동
    @RequestMapping("/newpost")
    public ModelAndView newpost() {
        System.out.println("play1");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newpost.html");
        return modelAndView;
    }

    //update페이지 기존 정보 끌어오기
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") Long Id) {
        System.out.println("play");
        Optional<Memo> memo = memoRepository.findById(Id);

        ModelAndView modelAndView = new ModelAndView("update.html");
        modelAndView.addObject("memoId", memo.get().getId());
        modelAndView.addObject("memoUsername", memo.get().getUsername());
        modelAndView.addObject("title", memo.get().getTitle());
        modelAndView.addObject("contents", memo.get().getContents());
        modelAndView.addObject("memoCreatedAt", memo.get().getCreatedAt());
        modelAndView.addObject("memoModifiedAt", memo.get().getModifiedAt());

        return modelAndView;
    }


}
