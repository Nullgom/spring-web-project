package com.codingbear.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codingbear.config.RootConfig;
import com.codingbear.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("테스트 글제목 입력1");
		board.setContent("테스트 글내용 입력1");
		board.setWriter("tester1");
		
		mapper.insert(board);
		
		log.info("새 글 저장1 : " + board);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("테스트 글제목 입력2");
		board.setContent("테스트 글내용 입력2");
		board.setWriter("tester2");
		
		mapper.insertSelectKy(board);
		
		log.info("새 글 저장2 : " + board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(5L);
		log.info("글 보기: " + board);
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(14L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		// 실행전 존재하는 번호인지 확인할 것
		board.setBno(11L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);		
	}
}
