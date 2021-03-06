package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.service.BoardService;

@Controller
@SessionAttributes("member")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting","hello thymeleaf");
	}
	
	@ModelAttribute("member")
	public Member setMember() {
		System.out.println("*********setMember()*******");
		return new Member();
	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member") Member member,Model model,Board board) {
		System.out.println("getBoardList");
		if(member.getId()==null) {
			return "redirect:login";
		}
		List<Board> boardList =boardService.getBoardList(board);
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView(@ModelAttribute("member") Member member,Board board) {

		if(member.getId()==null) {
			return "redirect:login";
		}
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(@ModelAttribute("member") Member member,Board board) {

		if(member.getId()==null) {
			return "redirect:login";
		}
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member,Board board,Model model) {

		if(member.getId()==null) {
			return "redirect:login";
		}
		model.addAttribute("board",boardService.getBoard(board));
		return "getBoard";
	}
	
	
}
