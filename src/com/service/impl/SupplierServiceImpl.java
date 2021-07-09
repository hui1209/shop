package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Supplier;
import com.dao.SupplierMapper;
import com.service.SupplierService;

/**
 * 供应商业务逻辑实现
 * @author asuna
 *
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper mapper;
	
	@Override
	public void insert(Supplier t) {
		mapper.insert(t);
	}

	@Override
	public void delete(Supplier t) {
		mapper.delete(t);
	}

	@Override
	public void update(Supplier t) {
		mapper.update(t);
	}

	@Override
	public List<Supplier> select(Supplier t) {
		return mapper.select(t);
	}

	@Override
	public int count(Map<String, Object> map) {
		return mapper.count(map);
	}

	@Override
	public List<Supplier> selectByPage(Map<String, Object> map) {
		return mapper.selectByPage(map);
	}

}
