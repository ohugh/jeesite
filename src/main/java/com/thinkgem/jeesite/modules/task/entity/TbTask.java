/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.task.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 作业发布管理Entity
 * @author 毕业设计
 * @version 2018-03-16
 */
public class TbTask extends DataEntity<TbTask> {
	
	private static final long serialVersionUID = 1L;
	private String taskTitle;		// 作业题目
	private String taskClass;		// 发布班级
	private String taskFile;		// 作业
	private String taskCreateId;		// 创建老师id
	
	public TbTask() {
		super();
	}

	public TbTask(String id){
		super(id);
	}

	@Length(min=1, max=255, message="作业题目长度必须介于 1 和 255 之间")
	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	
	@Length(min=1, max=255, message="发布班级长度必须介于 1 和 255 之间")
	public String getTaskClass() {
		return taskClass;
	}

	public void setTaskClass(String taskClass) {
		this.taskClass = taskClass;
	}
	
	public String getTaskFile() {
		return taskFile;
	}

	public void setTaskFile(String taskFile) {
		this.taskFile = taskFile;
	}
	
	@Length(min=1, max=255, message="创建老师id长度必须介于 1 和 255 之间")
	public String getTaskCreateId() {
		return taskCreateId;
	}

	public void setTaskCreateId(String taskCreateId) {
		this.taskCreateId = taskCreateId;
	}
	
}