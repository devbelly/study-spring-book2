package com.rubypaper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {
	@Autowired
	private BoardRepository boardRepo;
	
//	@Before
//	public void dataPrepare() {
//		for(int i=1;i<=200;++i) {
//			Board board = new Board();
//			board.setTitle("테스트 제목 " + i);
//			board.setWriter("테스트");
//			board.setContent("테스트 내용" +i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);
//		}
//	}
//	
//	@Test
//	public void testFindByTitle() {
//		List<Board> boardList =boardRepo.findBytitle("테스트 제목 10");
//		
//		System.out.println("검색결과");
//		for(Board board: boardList) {
//			System.out.println(board);
//		}
//	}
	
	@Test
	public void testFindByContentContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("17");
		for(Board board : boardList) {
			System.out.println(board);
		}
	}
}
