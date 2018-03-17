/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teacher.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 教师管理Entity
 * @author 毕业设计
 * @version 2018-03-17
 */
public class TbTeacher extends DataEntity<TbTeacher> {
	
	private static final long serialVersionUID = 1L;
	private String account;		// 账号
	private String teacherName;		// 姓名
	private String passwd;		// 密码
	private String sex;		// 性别
	private Integer identity;		// 身份标识
	private String fileId;		// 文件id
	private String classId;		// 班级id
	
	public TbTeacher() {
		super();
	}

	public TbTeacher(String id){
		super(id);
	}

	@Length(min=0, max=255, message="账号长度必须介于 0 和 255 之间")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	@Length(min=0, max=255, message="姓名长度必须介于 0 和 255 之间")
	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	@Length(min=0, max=255, message="密码长度必须介于 0 和 255 之间")
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Length(min=0, max=10, message="性别长度必须介于 0 和 10 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
	
	@Length(min=0, max=1024, message="文件id长度必须介于 0 和 1024 之间")
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
	@Length(min=0, max=1024, message="班级id长度必须介于 0 和 1024 之间")
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
	
}