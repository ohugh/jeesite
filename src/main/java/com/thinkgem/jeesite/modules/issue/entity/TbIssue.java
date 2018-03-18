/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.issue.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生问题管理Entity
 * @author 毕业设计
 * @version 2018-03-15
 */
public class TbIssue extends DataEntity<TbIssue> {
	
	private static final long serialVersionUID = 1L;
	private String issueTitle;		// 标题
	private String issueContent;		// 内容
	private Integer issueStatus;		// 状态
	private Integer popularity;		// 热度
	private String teacherid; 		//解答老师id  对应数据库的列
	private String content;			//解答内容
	
	private boolean isSelf;		//添加 是否显示另一个标签 数据库中没有此列
	
	//添加开始

	//用isself属性 来判断 是否显示另一个 标签
	public void setSelf(boolean isSelf) {
		this.isSelf = isSelf;
	}
	
	public boolean isSelf() {
		return isSelf;
	}
	//添加结束
	
	public TbIssue() {
		super();
	}

	public TbIssue(String id){
		super(id);
	}

	@Length(min=1, max=255, message="标题长度必须介于 1 和 255 之间")
	public String getIssueTitle() {
		return issueTitle;
	}

	public void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}
	
	public String getIssueContent() {
		return issueContent;
	}

	public void setIssueContent(String issueContent) {
		this.issueContent = issueContent;
	}
	
	@NotNull(message="状态不能为空")
	public Integer getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(Integer issueStatus) {
		this.issueStatus = issueStatus;
	}
	
	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
	
	//添加教师回复内容
	public String getcontent() {
		return content;
	}

	public void setcontent(String content) {
		this.content = content;
	}
	
	//添加教师id
	public String getteacherid() {
		return teacherid;
	}

	public void setteacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	
	
}
