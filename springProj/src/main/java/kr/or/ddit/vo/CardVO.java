package kr.or.ddit.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

// 자바빈 클래스
// Pojo
@Data
public class CardVO {
	
	private String userId;		// 회원 아이디
	private String no;				// 번호
	// 2022-11-01(기본 포맷 : 2022/11/01)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validMonth;	// 연월일
	
}
