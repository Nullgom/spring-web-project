package com.codingbear.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.codingbear.domain.SampleDTO;
import com.codingbear.domain.SampleDTOList;
import com.codingbear.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	@RequestMapping("")
	public void basic() {
		log.info("basic........................");
	}
	
	@RequestMapping(value="/basic",  method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get ....................");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() { // /sample/basicOnlyGet
		log.info("basic get only get.............");
	}
	
	@GetMapping("/ex01") // /sample/ex01?name=AAA&age=10
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		return "ex01";
	}
	
	@GetMapping("/ex02") // /sample/ex02?name=AAA&age=10
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name: " + name);
		log.info("age: " + age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List") //  /sample/ex02List?ids=111&ids=222&ids=333
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		log.info("ids: " + ids);
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean") // /sample/et02Bean?list%5B0%5D.name=aaa&lis%5B0%5D.name=bbb
	public String ex02Bean(SampleDTOList list) { 
		log.info("list dtos: " + list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) { // /sample/ex03?title=test&dueDate=2021/06/05
		log.info("todo: " + todo);
		return "ex03";
	}
	
	@GetMapping("/ex04") // /sample/ex04?name=aaa&age=10&page=9
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: " + dto);
		log.info("page: " + page);
		return "/sample/ex04";
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05...............");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06................");
		SampleDTO dto = new SampleDTO();
		dto.setAge(20);
		dto.setName("홍길동");
		
		return dto;		
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07................");
		// {"name" : "홍길동"}
		String msg = "{\"name\" : \"홍길동\", \"age\" : 23}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type",  "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("/exUpload...........");
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file->{
			log.info("------------------------------");
			log.info("name: " + file.getOriginalFilename());
			log.info("size: " + file.getSize());
		});
	}
}
