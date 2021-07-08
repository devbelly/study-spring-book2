package com.rubypaper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepo;
	
//	@Test
//	public void testInsertBoard() {
//		Board board = new Board();
//		board.setCnt(0L);
//		board.setContent("잘 등록되나요?");
//		board.setCreateDate(new Date());
//		board.setWriter("테스터");
//		board.setTitle("첫 번째 게시글");
//		
//		boardRepo.save(board);
//	}
	
//	@Test
//	public void testGetBoard() {
//		Board board = boardRepo.findById(1L).get();
//		System.out.println(board);
//	}
	
	@Test
	public void testUpdateBoard() {
		Board board=boardRepo.findById(1L).get();
		
		board.setTitle("제목을 수정했습니다");
		boardRepo.save(board);
	}
}
