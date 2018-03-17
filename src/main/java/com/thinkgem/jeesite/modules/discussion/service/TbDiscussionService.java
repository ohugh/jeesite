/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.discussion.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.discussion.entity.TbDiscussion;
import com.thinkgem.jeesite.modules.discussion.dao.TbDiscussionDao;

/**
 * 讨论管理Service
 * @author 毕业设计
 * @version 2018-03-17
 */
@Service
@Transactional(readOnly = true)
public class TbDiscussionService extends CrudService<TbDiscussionDao, TbDiscussion> {

	public TbDiscussion get(String id) {
		return super.get(id);
	}
	
	public List<TbDiscussion> findList(TbDiscussion tbDiscussion) {
		return super.findList(tbDiscussion);
	}
	
	public Page<TbDiscussion> findPage(Page<TbDiscussion> page, TbDiscussion tbDiscussion) {
		return super.findPage(page, tbDiscussion);
	}
	
	@Transactional(readOnly = false)
	public void save(TbDiscussion tbDiscussion) {
		super.save(tbDiscussion);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbDiscussion tbDiscussion) {
		super.delete(tbDiscussion);
	}
	
}