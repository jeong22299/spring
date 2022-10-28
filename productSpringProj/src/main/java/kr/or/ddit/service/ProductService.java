package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.ProductVO;

// 서비스 interface : 비지니스 로직
public interface ProductService {
	// 메소드 시그니처
	
	// BOOK 테이블에 INSERT
	public int insert(ProductVO productVO);

	// 상품 목록
	public List<ProductVO> list(String keyword);
	
	// 상품 상세
	public ProductVO selectDetail(ProductVO productVO);
	
	// 상품 수정
	public int update(ProductVO productVO);

	// 상품 삭제
	public int delete(String productId);

	// CART 및 CART_DET 테이블에 INSERT
	public int thankCustomer(CartVO cartVO);
}
