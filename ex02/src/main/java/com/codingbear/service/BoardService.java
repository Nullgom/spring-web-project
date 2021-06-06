package com.codingbear.service;

import java.util.List;

import com.codingbear.domain.BoardVO;

public interface BoardService {
	// 등록 작업
	public void register(BoardVO board); 
	
	// 조회 작업
	public BoardVO get(Long bno);
	
	// 수정 작업
	public boolean modify(BoardVO board);
	
	// 삭제 작업
	public boolean remove(Long bno); 
	
	// 목록(리스트) 작업
	public List<BoardVO> getList();
}
