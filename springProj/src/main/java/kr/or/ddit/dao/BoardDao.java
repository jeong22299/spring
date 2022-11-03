package kr.or.ddit.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.MemberListVO;

// 매퍼xml(book_SQL.xml)을 실행시키는 
// DAO(Data Access Object) 클래스
// Repository 어노테이션 : 데이터에 접근하는 자바빈 객체로 스프링에 등록해줌
// 프링아, 이거 데이터를 관리하는 특별한 클래스야
@Repository
public class BoardDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 게시글 목록보기
	public List<MemberListVO> list(Map<String, String> map){
		return this.sqlSessionTemplate.selectList("board.list", map);
	}
	
	//  MEM 테이블의 전체 행의 수 구함 
//	<select id="getTotal" resultType="int">
	public int getTotal(Map<String, String> map) {
		return this.sqlSessionTemplate.selectOne("board.getTotal", map);
	}
	
	// 게시판 등록
	public int insert(MemberListVO memVO) {
		return this.sqlSessionTemplate.insert("board.memInsert", memVO);
	}

	// 아이디 중복 체크
	public int chkDup(String memId) {
		return this.sqlSessionTemplate.selectOne("board.chkDup", memId);
	}
}

















