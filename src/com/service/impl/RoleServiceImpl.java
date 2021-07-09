package com.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Role;
import com.dao.RoleMapper;
import com.service.RoleService;

/**
 * 角色业务逻辑实现
 * @author Administrator
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper mapper;

	@Override
	public void insert(Role t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Role t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Role t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> select(Role t) {
		return mapper.select(t);
	}

	@Override
	public int count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> selectByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
