package com.kjh.hojak.RestfulAPI_Server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kjh.hojak.RestfulAPI_Server.mapper.BoardMapper;
import com.kjh.hojak.RestfulAPI_Server.vo.BoardVO;

@RestController
public class BoardController {

	@Autowired
	private BoardMapper mapper;

	// 글 목록
	@RequestMapping(value = "/boards.do")
	public ModelAndView boardList(ModelAndView mav) throws Exception {
		List<BoardVO> boardList = mapper.listAll();

		mav.setViewName("list");
		mav.addObject("list", boardList);
		return mav;
	}

	// 글 작성
	@RequestMapping(value = "/boards", method = RequestMethod.POST)
	public void createBoard(BoardVO vo) throws Exception {
		mapper.insert(vo);
	}

	// 글 불러오기
	@RequestMapping(value = "/boards/{bno}", method = RequestMethod.GET)
	public BoardVO getBoardInfo(@PathVariable int bno) throws Exception {
		BoardVO vo = mapper.read(bno);
		return vo;
	}

	// 글 수정
	@RequestMapping(value = "/boards/{vo.bno}", method = RequestMethod.PUT)
	public BoardVO updateBoardInfo(@ModelAttribute BoardVO vo) throws Exception {
		mapper.update(vo);
		return vo;
	}

	// 글 삭제
	@RequestMapping(value = "/boards/{bno}")
	public void deleteBoard(@PathVariable int bno) throws Exception {
		mapper.delete(bno);
	}
}
