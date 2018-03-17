/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.discussion.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 讨论管理Entity
 * @author 毕业设计
 * @version 2018-03-17
 */
public class TbDiscussion extends DataEntity<TbDiscussion> {
	
	private static final long serialVersionUID = 1L;
	private String selfId;		// 回复者id
	private String pointToId;		// 指向回复人id
	private String replyContent;		// 回复内容
	
	public TbDiscussion() {
		super();
	}

	public TbDiscussion(String id){
		super(id);
	}

	@Length(min=0, max=255, message="回复者id长度必须介于 0 和 255 之间")
	public String getSelfId() {
		return selfId;
	}

	public void setSelfId(String selfId) {
		this.selfId = selfId;
	}
	
	@Length(min=0, max=255, message="指向回复人id长度必须介于 0 和 255 之间")
	public String getPointToId() {
		return pointToId;
	}

	public void setPointToId(String pointToId) {
		this.pointToId = pointToId;
	}
	
	@Length(min=0, max=1024, message="回复内容长度必须介于 0 和 1024 之间")
	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
}