package com.kjh.hojak.RestfulAPI_Server.mapper;

import java.util.List;

import com.kjh.hojak.RestfulAPI_Server.vo.BoardVO;

public interface BoardMapper {
	public void insert(BoardVO vo) throws Exception;
	public BoardVO read(int bno) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(int bno) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public void increaseViewcnt(int bno) throws Exception;
	public String checkPassword(int bno) throws Exception;
}
