/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.question.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.question.entity.TbQuestions;
import com.thinkgem.jeesite.modules.question.dao.TbQuestionsDao;

/**
 * 提问回复管理Service
 * @author 毕业设计
 * @version 2018-03-17
 */
@Service
@Transactional(readOnly = true)
public class TbQuestionsService extends CrudService<TbQuestionsDao, TbQuestions> {

	public TbQuestions get(String id) {
		return super.get(id);
	}
	
	public List<TbQuestions> findList(TbQuestions tbQuestions) {
		return super.findList(tbQuestions);
	}
	
	public Page<TbQuestions> findPage(Page<TbQuestions> page, TbQuestions tbQuestions) {
		return super.findPage(page, tbQuestions);
	}
	
	@Transactional(readOnly = false)
	public void save(TbQuestions tbQuestions) {
		super.save(tbQuestions);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbQuestions tbQuestions) {
		super.delete(tbQuestions);
	}
	
}