/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.issue.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.issue.entity.TbIssue;

/**
 * 学生问题管理DAO接口
 * @author 毕业设计
 * @version 2018-03-15
 */
@MyBatisDao
public interface TbIssueDao extends CrudDao<TbIssue> {
	
}