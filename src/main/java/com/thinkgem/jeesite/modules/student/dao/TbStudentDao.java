/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.student.entity.TbStudent;

/**
 * 学生管理DAO接口
 * @author 毕业设计
 * @version 2018-03-17
 */
@MyBatisDao
public interface TbStudentDao extends CrudDao<TbStudent> {
	
}