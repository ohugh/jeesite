/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.school.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学院管理Entity
 * @author 毕业设计
 * @version 2018-03-17
 */
public class TbSchool extends DataEntity<TbSchool> {
	
	private static final long serialVersionUID = 1L;
	private String departmentName;		// 院系名称
	
	public TbSchool() {
		super();
	}

	public TbSchool(String id){
		super(id);
	}

	@Length(min=0, max=255, message="院系名称长度必须介于 0 和 255 之间")
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
}