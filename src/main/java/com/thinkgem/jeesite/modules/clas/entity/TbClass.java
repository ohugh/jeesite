/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.clas.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 班级管理Entity
 * @author 毕业设计
 * @version 2018-03-17
 */
public class TbClass extends DataEntity<TbClass> {
	
	private static final long serialVersionUID = 1L;
	private String className;		// 班级名称
	private String departmentId;		// 所属院系
	
	public TbClass() {
		super();
	}

	public TbClass(String id){
		super(id);
	}

	@Length(min=0, max=255, message="班级名称长度必须介于 0 和 255 之间")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	@Length(min=0, max=64, message="所属院系长度必须介于 0 和 64 之间")
	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	
}