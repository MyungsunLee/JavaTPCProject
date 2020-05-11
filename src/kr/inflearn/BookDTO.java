package kr.inflearn;

public class BookDTO {
	private String title;
	private String company;
	private int page;
	private int price;
	
	
	public BookDTO() {}
	
	public BookDTO(String title, String company, int page, int price) {
		super();
		this.title = title;
		this.company = company;
		this.page = page;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", company=" + company + ", page=" + page + ", price=" + price + "]";
	}
}
