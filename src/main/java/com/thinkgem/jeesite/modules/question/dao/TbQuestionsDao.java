/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.question.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.question.entity.TbQuestions;

/**
 * 提问回复管理DAO接口
 * @author 毕业设计
 * @version 2018-03-17
 */
@MyBatisDao
public interface TbQuestionsDao extends CrudDao<TbQuestions> {
	
}