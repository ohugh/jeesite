/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.TbStudent;
import com.thinkgem.jeesite.modules.student.dao.TbStudentDao;

/**
 * 学生管理Service
 * @author 毕业设计
 * @version 2018-03-17
 */
@Service
@Transactional(readOnly = true)
public class TbStudentService extends CrudService<TbStudentDao, TbStudent> {

	public TbStudent get(String id) {
		return super.get(id);
	}
	
	public List<TbStudent> findList(TbStudent tbStudent) {
		return super.findList(tbStudent);
	}
	
	public Page<TbStudent> findPage(Page<TbStudent> page, TbStudent tbStudent) {
		return super.findPage(page, tbStudent);
	}
	
	@Transactional(readOnly = false)
	public void save(TbStudent tbStudent) {
		super.save(tbStudent);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbStudent tbStudent) {
		super.delete(tbStudent);
	}
	
}