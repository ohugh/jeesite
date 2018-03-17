/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.clas.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.clas.entity.TbClass;
import com.thinkgem.jeesite.modules.clas.dao.TbClassDao;

/**
 * 班级管理Service
 * @author 毕业设计
 * @version 2018-03-17
 */
@Service
@Transactional(readOnly = true)
public class TbClassService extends CrudService<TbClassDao, TbClass> {

	public TbClass get(String id) {
		return super.get(id);
	}
	
	public List<TbClass> findList(TbClass tbClass) {
		return super.findList(tbClass);
	}
	
	public Page<TbClass> findPage(Page<TbClass> page, TbClass tbClass) {
		return super.findPage(page, tbClass);
	}
	
	@Transactional(readOnly = false)
	public void save(TbClass tbClass) {
		super.save(tbClass);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbClass tbClass) {
		super.delete(tbClass);
	}
	
}