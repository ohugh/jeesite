/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teacher.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.teacher.entity.TbTeacher;
import com.thinkgem.jeesite.modules.teacher.dao.TbTeacherDao;

/**
 * 教师管理Service
 * @author 毕业设计
 * @version 2018-03-17
 */
@Service
@Transactional(readOnly = true)
public class TbTeacherService extends CrudService<TbTeacherDao, TbTeacher> {

	public TbTeacher get(String id) {
		return super.get(id);
	}
	
	public List<TbTeacher> findList(TbTeacher tbTeacher) {
		return super.findList(tbTeacher);
	}
	
	public Page<TbTeacher> findPage(Page<TbTeacher> page, TbTeacher tbTeacher) {
		return super.findPage(page, tbTeacher);
	}
	
	@Transactional(readOnly = false)
	public void save(TbTeacher tbTeacher) {
		super.save(tbTeacher);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbTeacher tbTeacher) {
		super.delete(tbTeacher);
	}
	
}