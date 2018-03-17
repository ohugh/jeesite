/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.task.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.task.entity.TbTask;
import com.thinkgem.jeesite.modules.task.dao.TbTaskDao;

/**
 * 作业发布管理Service
 * @author 毕业设计
 * @version 2018-03-16
 */
@Service
@Transactional(readOnly = true)
public class TbTaskService extends CrudService<TbTaskDao, TbTask> {

	public TbTask get(String id) {
		return super.get(id);
	}
	
	public List<TbTask> findList(TbTask tbTask) {
		return super.findList(tbTask);
	}
	
	public Page<TbTask> findPage(Page<TbTask> page, TbTask tbTask) {
		return super.findPage(page, tbTask);
	}
	
	@Transactional(readOnly = false)
	public void save(TbTask tbTask) {
		super.save(tbTask);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbTask tbTask) {
		super.delete(tbTask);
	}
	
}