package com.rubypaper.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

@RestController
public class BoardController {
	public BoardController() {
		System.out.println("==> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "hello:"+name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목");
		board.setWriter("테스터");
		board.setContent("테스트 내용");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}
}
