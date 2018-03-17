/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.task.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.task.entity.TbTask;

/**
 * 作业发布管理DAO接口
 * @author 毕业设计
 * @version 2018-03-16
 */
@MyBatisDao
public interface TbTaskDao extends CrudDao<TbTask> {
	
}