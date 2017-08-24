package com.kjh.hojak.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kjh.hojak.vo.BoardVO;

// ���� Ŭ������ dao bean ���� ���
@Repository		
public class BoardDAOImpl implements BoardDAO{

	@Inject
	SqlSession sqlSession;
	
	@Override
	public void create(BoardVO vo) throws Exception {
		sqlSession.insert("board.insert", vo);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return sqlSession.selectOne("board.view", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		sqlSession.update("board.updateArticle", vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.deleteArticle", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return sqlSession.selectList("board.listAll");
	}

	@Override
	public void increaseViewcnt(int bno) throws Exception {
		sqlSession.update("board.increaseViewcnt", bno);
	}
  
}
