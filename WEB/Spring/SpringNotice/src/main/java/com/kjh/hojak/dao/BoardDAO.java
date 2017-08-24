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
	
	// 삭제 및 수정할 시에 패스워드 조회
	public String checkPassword(int bno) throws Exception;
}
