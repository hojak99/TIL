package com.kjh.hojak.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kjh.hojak.service.BoardService;
import com.kjh.hojak.vo.BoardVO;

// 현재 클래스를 컨트롤러 bean 으로 등록
@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService boardService;
	
	// 01. 게시글 목록
	@RequestMapping("list.do")
	public ModelAndView list() throws Exception {
		List<BoardVO> list = boardService.listAll();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");			// 뷰를 list.jsp 로 설정
		mav.addObject("list", list);			// 데이터 저장
		return mav;				// list.jsp 로 list 전달
	}
	
	// 02_01. 게시글 작성화면
	// @RequestMapping("board/writer.do")
	// value="", method="전송방식"
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write(){
		return "board/wrter";	// writer.jsp 로 이동
	}
	
	// 02_02. 게시글 작성처리
	@RequestMapping (value="insert.do", method=RequestMethod.POST)
	public String insert(@ModelAttribute BoardVO vo) throws Exception{
		boardService.create(vo);
		return "redirect:list.do";
	}
	
	// 03. 게시글 상세내용 조회, 게시글 조회수 증가처리
	// @RequestParam : get/post 방식으로 전달된 변수 1개
	// HttpSession 세션 객체
	@RequestMapping(value="view.do", method=RequestMethod.GET)
	public ModelAndView view(@RequestParam int bno, HttpSession session) throws Exception {
		// 조회수 증가 처리
		boardService.increaseViewCount(bno, session);
		
		// 모델(데이터) + 뷰(화면)을 함께 전달하는 객체
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/view");
		mav.addObject("dto", boardService.read(bno));
		return mav;
	}
	
	// 04. 게시글 수정
	// 폼에서 입력한 내용들은 @ModelAttribute BoardVO vo 로 전달
	@RequestMapping(value="update.do", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardVO vo) throws Exception {
		boardService.update(vo);
		return "redirect:list.do";
	}
	
	// 05. 게시글 삭제
	@RequestMapping("delete.do")
	public String delete(@RequestParam int bno) throws Exception {
		boardService.delete(bno);
		return "redirect:list.do";
	}
}
