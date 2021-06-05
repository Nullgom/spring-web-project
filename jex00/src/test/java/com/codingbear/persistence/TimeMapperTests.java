package com.codingbear.persistence;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.codingbear.config.RootConfig;
import com.codingbear.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
@Log4j
public class TimeMapperTests {
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapper;	
	
	@Test
	public void testGetTime() {
		log.info("------------------------------");
		log.info(timeMapper.getClass().getName());
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2() {
		log.info("------------------------------");
		log.info(timeMapper.getTime2());
	}

}