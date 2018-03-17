/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.issue.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.issue.entity.TbIssue;
import com.thinkgem.jeesite.modules.issue.dao.TbIssueDao;

/**
 * 学生问题管理Service
 * @author 毕业设计
 * @version 2018-03-15
 */
@Service
@Transactional(readOnly = true)
public class TbIssueService extends CrudService<TbIssueDao, TbIssue> {

	public TbIssue get(String id) {
		return super.get(id);
	}
	
	public List<TbIssue> findList(TbIssue tbIssue) {
		return super.findList(tbIssue);
	}
	
	public Page<TbIssue> findPage(Page<TbIssue> page, TbIssue tbIssue) {
		return super.findPage(page, tbIssue);
	}
	
	
	public Page<TbIssue> findPagelist(Page<TbIssue> page, TbIssue tbIssue) {
		List<TbIssue> issueList = new ArrayList<TbIssue>();
		List<TbIssue> s = findList(tbIssue);
		for(TbIssue issue : s) {
			if(issue.getIssueStatus() == 1) {
				issueList.add(issue);
			}
		}
		
		page.setList(issueList);
		return page;
	}
	
	
	
	
	@Transactional(readOnly = false)
	public void save(TbIssue tbIssue) {
		super.save(tbIssue);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbIssue tbIssue) {
		super.delete(tbIssue);
	}
	
}