package book.pojo;

import java.math.BigDecimal;

public class Book {
	private Integer id;
	private String name;
	private BigDecimal price;
	private String author;
	private Integer sales;
	private Integer stock;
	private String imgPath = "static/img/default.jpg";

	public Book() {
		super();
	}

	public Book(Integer id, String name, BigDecimal price, String author, Integer sales, Integer stock,
			String imgPath) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
		this.sales = sales;
		this.stock = stock;
		// if the image path is empty or null, don't assign value to img path.
		if (imgPath != null && !imgPath.equals("")) {
			this.imgPath = imgPath;
		}
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getSales() {
		return sales;
	}

	public Integer getStock() {
		return stock;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public void setImgPath(String imgPath) {
		// if the image path is empty or null, don't assign value to img path.
		if (imgPath != null && !imgPath.equals("")) {
			this.imgPath = imgPath;
		}
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", author=" + author + ", sales=" + sales
				+ ", stock=" + stock + ", imgPath=" + imgPath + "]";
	}
	
	

}
