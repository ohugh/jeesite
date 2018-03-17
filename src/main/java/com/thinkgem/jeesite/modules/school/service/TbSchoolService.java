/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.school.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.school.entity.TbSchool;
import com.thinkgem.jeesite.modules.school.dao.TbSchoolDao;

/**
 * 学院管理Service
 * @author 毕业设计
 * @version 2018-03-17
 */
@Service
@Transactional(readOnly = true)
public class TbSchoolService extends CrudService<TbSchoolDao, TbSchool> {

	public TbSchool get(String id) {
		return super.get(id);
	}
	
	public List<TbSchool> findList(TbSchool tbSchool) {
		return super.findList(tbSchool);
	}
	
	public Page<TbSchool> findPage(Page<TbSchool> page, TbSchool tbSchool) {
		return super.findPage(page, tbSchool);
	}
	
	@Transactional(readOnly = false)
	public void save(TbSchool tbSchool) {
		super.save(tbSchool);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbSchool tbSchool) {
		super.delete(tbSchool);
	}
	
}