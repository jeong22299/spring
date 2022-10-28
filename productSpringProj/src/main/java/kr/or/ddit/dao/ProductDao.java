package kr.or.ddit.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.ProductVO;

@Repository
public class ProductDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

//	PRODUCT 테이블에 insert 
	public int insert(ProductVO productVO) {
		return this.sqlSessionTemplate.insert("product.insert", productVO);
	}

	// 상품 목록
	public List<ProductVO> list(String keyword) {
		return this.sqlSessionTemplate.selectList("product.list", keyword);
	}

	// 상품 상세보기
	public ProductVO selectDetail(ProductVO productVO) {
		return this.sqlSessionTemplate.selectOne("product.detail", productVO);
	}

	// 상품 수정하기
	public int update(ProductVO productVO) {
		return this.sqlSessionTemplate.update("product.update", productVO);
	}

	// 상품책 삭제하기
	public int delete(String productId) {
		// .delete("namespace.id", 파라미터)
		return this.sqlSessionTemplate.delete("product.delete", productId);
	}

	// CART 테이블에 insert
	public int insertCart(CartVO cartVO) {
		return this.sqlSessionTemplate.insert("product.insertCart", cartVO);
	}

	// ATTACH 테이블에 다중 INSERT
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.sqlSessionTemplate.insert("product.insertAttach", attachVOList);
	}
}
