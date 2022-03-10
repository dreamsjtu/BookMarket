package book.pojo;

import java.util.List;

/**
 * This is the paging object
 * 
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

	public List<T> getItems() {
		return items;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageNumber(int pageNumber) {
		// Validate page range.
		if (pageNumber < 1) {
			pageNumber = 1;
		} else if (pageNumber > totalPages) {
			pageNumber = totalPages;
		}
		this.pageNumber = pageNumber;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setItemsNumber(int totalItems) {
		this.itemsNumber = totalItems;
	}

	public void setItems(List<T> items) {
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
