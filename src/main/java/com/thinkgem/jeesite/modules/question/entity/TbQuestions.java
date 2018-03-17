/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.question.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 提问回复管理Entity
 * @author 毕业设计
 * @version 2018-03-17
 */
public class TbQuestions extends DataEntity<TbQuestions> {
	
	private static final long serialVersionUID = 1L;
	private String questionId;		// 提问id
	private String messageId;		// 回复表id
	
	public TbQuestions() {
		super();
	}

	public TbQuestions(String id){
		super(id);
	}

	@Length(min=0, max=255, message="提问id长度必须介于 0 和 255 之间")
	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	@Length(min=0, max=255, message="回复表id长度必须介于 0 和 255 之间")
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
}