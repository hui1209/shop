package com.util;

/**
 * 页面助手
 * @author Administrator
 *
 */
public class PageAssistant {

	/** 总记录数(数据总数) */
	private int count;
	/** 页面大小(每页的最大数据条数) */
	private int pageSize = 20;
	/** 总页数 */
	private int totalPage;
	/** 目标页码(当前页) */
	private int currPage = 1;
	/** 起始序号 */
	private int start;
	
	@Override
	public String toString() {
		return "PageAssistant [count=" + count + ", pageSize=" + pageSize + ", totalPage=" + totalPage + ", currPage="
				+ currPage + ", start=" + start + "]";
	}
	/* 总记录数需要通过查询语句查询赋值 */
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		setTotalPage();
		//判断
		if(totalPage < currPage) {
			setCurrPage(totalPage);
		}
	}
	
	/* 可以在需要的时候改变 */
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setTotalPage();
		setStart();
	}
	
	/* 不能主动修改, 通过总记录数和页面大小计算得到 */
	public int getTotalPage() {
		return totalPage;
	}
	private void setTotalPage() {
		this.totalPage = count / pageSize;
		if(count % pageSize != 0) {
			totalPage++;
		}
	}
	
	/* 当前页必须通过赋值得到 */
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
		setStart();
	}
	
	/* 起始数据的序号通过当前页和页面大小计算得到, 不能主动赋值 */
	public int getStart() {
		return start;
	}
	private void setStart() {
		this.start = (currPage-1) * pageSize;
	}
	
}
