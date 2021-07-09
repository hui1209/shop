package com.util;

/**
 * ҳ������
 * @author Administrator
 *
 */
public class PageAssistant {

	/** �ܼ�¼��(��������) */
	private int count;
	/** ҳ���С(ÿҳ�������������) */
	private int pageSize = 20;
	/** ��ҳ�� */
	private int totalPage;
	/** Ŀ��ҳ��(��ǰҳ) */
	private int currPage = 1;
	/** ��ʼ��� */
	private int start;
	
	@Override
	public String toString() {
		return "PageAssistant [count=" + count + ", pageSize=" + pageSize + ", totalPage=" + totalPage + ", currPage="
				+ currPage + ", start=" + start + "]";
	}
	/* �ܼ�¼����Ҫͨ����ѯ����ѯ��ֵ */
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		setTotalPage();
		//�ж�
		if(totalPage < currPage) {
			setCurrPage(totalPage);
		}
	}
	
	/* ��������Ҫ��ʱ��ı� */
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setTotalPage();
		setStart();
	}
	
	/* ���������޸�, ͨ���ܼ�¼����ҳ���С����õ� */
	public int getTotalPage() {
		return totalPage;
	}
	private void setTotalPage() {
		this.totalPage = count / pageSize;
		if(count % pageSize != 0) {
			totalPage++;
		}
	}
	
	/* ��ǰҳ����ͨ����ֵ�õ� */
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
		setStart();
	}
	
	/* ��ʼ���ݵ����ͨ����ǰҳ��ҳ���С����õ�, ����������ֵ */
	public int getStart() {
		return start;
	}
	private void setStart() {
		this.start = (currPage-1) * pageSize;
	}
	
}
