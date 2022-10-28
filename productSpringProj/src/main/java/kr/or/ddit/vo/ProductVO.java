package kr.or.ddit.vo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

// 자바빈 클래스
// 1) 멤버변수 2) 기본 생성자 3) getter/setter 메소드
public class ProductVO {
	private String productId;		// 상품코드
	private String pname;			// 상품명
	private int unitPrice;			// 상품가격
	private String description;		// 상품설명
	private String manufacturer;	// 제조사
	private String  category;		// 분류
	private int unitsInStock;		// 재고수
	private String condition;		// 신상품 or 중고품 or 재생품
	private String filename;		// 이미지 파일명
	private int quantity;			// 장바구니에 상품을 담은 개수
	
	//<input type="file" id="productImage" name="productImage" class="form-control" multiple>
	private MultipartFile[] productImage;
	
	// 2) 기본 생성자(생략가능)
	public ProductVO() {}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public MultipartFile[] getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile[] productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "ProductVO [productId=" + productId + ", pname=" + pname + ", unitPrice=" + unitPrice + ", description="
				+ description + ", manufacturer=" + manufacturer + ", category=" + category + ", unitsInStock="
				+ unitsInStock + ", condition=" + condition + ", filename=" + filename + ", quantity=" + quantity
				+ ", productImage=" + Arrays.toString(productImage) + "]";
	}

}










