package com.service;

import java.util.List;
import java.util.Map;

import com.bean.User;

/**
 * 通用业务逻辑接口
 * @author Administrator
 *
 */
public interface BaseService<T> {

	/** 添加 */
	void insert(T t);
	/** 删除 */
	void delete(T t);
	/** 修改 */
	void update(T t);
	/** 查询 */
	List<T> select(T t);
	/** 总记录数 */
	int count(Map<String, Object> map);
	/** 分页及组合条件查询 */
	List<T> selectByPage(Map<String, Object> map);
}
















