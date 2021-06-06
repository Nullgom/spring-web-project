package com.codingbear.mapper;

import java.util.List;

import com.codingbear.domain.BoardVO;

public interface BoardMapper {
	
	// 목록 보기
	public List<BoardVO> getList();
	
	// 새글 저장
	public void insert(BoardVO board);	
	public void insertSelectKy(BoardVO board);
	
	// 글내용 보기
	public BoardVO read(Long bno);
	
	// 글 삭제
	public int delete(Long bno);
	
	// 글 수정
	public int update(BoardVO board);
	
}
