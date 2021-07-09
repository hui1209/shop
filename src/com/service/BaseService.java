package com.service;

import java.util.List;
import java.util.Map;

import com.bean.User;

/**
 * ͨ��ҵ���߼��ӿ�
 * @author Administrator
 *
 */
public interface BaseService<T> {

	/** ��� */
	void insert(T t);
	/** ɾ�� */
	void delete(T t);
	/** �޸� */
	void update(T t);
	/** ��ѯ */
	List<T> select(T t);
	/** �ܼ�¼�� */
	int count(Map<String, Object> map);
	/** ��ҳ�����������ѯ */
	List<T> selectByPage(Map<String, Object> map);
}
















