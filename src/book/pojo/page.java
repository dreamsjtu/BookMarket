package book.pojo;

import java.util.List;

/**
 * This is the paging object
 * @author mengli
 *
 * @param <T> The javabean object of a concrete model
 */
public class page<T> {
	public page(int pageNumber, int totalPages, int totalItems, List<T> items, int pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.totalPages = totalPages;
		this.totalItems = totalItems;
		this.items = items;
		this.pageSize = pageSize;
	}

	public static final int PAGE_SIZE = 4;
	private int pageNumber;
	private int totalPages;
	private int totalItems;
	private List<T> items;
	private int pageSize = PAGE_SIZE;

	public int getPageNumber() {
		return pageNumber;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public List<T> getBookItems() {
		return items;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public void setBookItems(List<T> items) {
		this.items = items;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "page [pageNumber=" + pageNumber + ", totalPages=" + totalPages + ", totalItems=" + totalItems
				+ ", bookItems=" + items + ", pageSize=" + pageSize + "]";
	}
}
