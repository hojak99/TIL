package com.kjh.hojak.dao;

import java.util.List;

import com.kjh.hojak.vo.BoardVO;

public interface BoardDAO {
	
	// 01. �Խñ� �ۼ�
	public void create(BoardVO vo) throws Exception;
	
	// 02. �Խñ� �󼼺��� 
	public BoardVO read(int bno) throws Exception;
	
	// 03. �Խñ� ����
	public void update(BoardVO vo) throws Exception;
	
	// 04. �Խñ� ����
	public void delete(int bno) throws Exception;
	
	// 05. �Խñ� ��ü ���
	public List<BoardVO> listAll() throws Exception;
	
	// 06. �Խñ� ��ȸ ����
	public void increaseViewcnt(int bno) throws Exception;
}
