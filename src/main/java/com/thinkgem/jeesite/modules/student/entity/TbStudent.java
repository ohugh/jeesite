/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生管理Entity
 * @author 毕业设计
 * @version 2018-03-17
 */
public class TbStudent extends DataEntity<TbStudent> {
	
	private static final long serialVersionUID = 1L;
	private String account;		// 学生账号
	private String studentName;		// 学生姓名
	private String passwd;		// 登录密码
	private String sex;		// 性别
	private Integer identity;		// 身份标识
	private String fileId;		// 文件id
	private String issueId;		// 问题id
	private Integer classId;		// 班级id
	
	public TbStudent() {
		super();
	}

	public TbStudent(String id){
		super(id);
	}

	@Length(min=0, max=255, message="学生账号长度必须介于 0 和 255 之间")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	@Length(min=0, max=255, message="学生姓名长度必须介于 0 和 255 之间")
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	@Length(min=0, max=255, message="登录密码长度必须介于 0 和 255 之间")
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
	
	@Length(min=0, max=1024, message="问题id长度必须介于 0 和 1024 之间")
	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
	
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	
}