package com.codingbear.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingbear.domain.BoardVO;
import com.codingbear.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service  // 계층 구조상 주로 비즈닌스 영역을 담당하는 객체임을 표시하기 위해 사용
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	// spring 4.3 이상에서 자동 처리
	private BoardMapper mapper;
	
	@Override  // 등록 작업 구현
	public void register(BoardVO board) {
		log.info("register....." + board);
		mapper.insertSelectKey(board);
	}

	@Override // 조회 작업 구현
	public BoardVO get(Long bno) {
		log.info("get .... " + bno);
	
		return mapper.read(bno);
	}

	@Override // 수정 작업 구현
	public boolean modify(BoardVO board) {
		log.info("modify....." + board);
		
		return mapper.update(board) == 1;
	}

	@Override // 삭제 작업 구현
	public boolean remove(Long bno) {
		log.info("remove....." + bno);
		
		return mapper.delete(bno) == 1;
	}

	@Override // 목록 작업 구현
	public List<BoardVO> getList() {
		log.info("getLsit........");
		
		return mapper.getList();
	}

}
