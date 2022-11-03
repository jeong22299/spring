package kr.or.ddit.dao;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookVO;

// 매퍼xml(book_SQL.xml)을 실행시키는 
// DAO(Data Access Object) 클래스
// Repository 어노테이션 : 데이터에 접근하는 자바빈 객체로 스프링에 등록해줌
// 프링아, 이거 데이터를 관리하는 특별한 클래스야
@Repository
public class BookDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// <insert id="insert" parameterType="vo.BookVO">
	// BOOK 테이블에 insert
	public int insert(BookVO bookVO) {
		return this.sqlSessionTemplate.insert("book.insert", bookVO);
	}
	
	// 책 상세보기
	public BookVO selectDetail(BookVO bookVO) {
		return this.sqlSessionTemplate.selectOne("book.select_detail", bookVO);
	}
	
	// 책 목록보기
	public List<BookVO> list(String keyword){
		return this.sqlSessionTemplate.selectList("book.list", keyword);
	}
	
//	// 책 수정하기
//	public int update(BookVO bookVO) {
//		return this.sqlSessionTemplate.update("book.update", bookVO);
//	}
//	
//	// 책 삭제하기
//	public int delete(int bookId) {
//		return this.sqlSessionTemplate.delete("book.delete", bookId);
//	}
	// ATTACH 테이블에 다중 INSERT
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.sqlSessionTemplate.insert("book.insertAttach", attachVOList);
	}
}

















