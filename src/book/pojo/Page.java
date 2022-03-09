package book.pojo;

import java.util.List;

/**
 * This is the paging object
 * @author mengli
 *
 * @param <T> The javabean object of a concrete model
 */
public class Page<T> {
	public Page(int pageNumber, int totalPages, int itemsNumber, List<T> items, int pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.totalPages = totalPages;
		this.itemsNumber = itemsNumber;
		this.items = items;
		this.pageSize = pageSize;
	}
	
	public Page() {
		
	}

	public static final int PAGE_SIZE = 4;
	private int pageNumber;
	private int totalPages;
	private int itemsNumber;
	private List<T> items;
	private int pageSize = PAGE_SIZE;

	public int getPageNumber() {
		return pageNumber;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getItemsNumber() {
		return itemsNumber;
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

	public void setItemsNumber(int totalItems) {
		this.itemsNumber = totalItems;
	}

	public void setBookItems(List<T> items) {
		this.items = items;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "page [pageNumber=" + pageNumber + ", totalPages=" + totalPages + ", totalItems=" + itemsNumber
				+ ", bookItems=" + items + ", pageSize=" + pageSize + "]";
	}
}
