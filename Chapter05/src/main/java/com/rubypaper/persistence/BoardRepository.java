package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;

public interface BoardRepository extends CrudRepository<Board,Long>{
	List<Board> findBytitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
}
