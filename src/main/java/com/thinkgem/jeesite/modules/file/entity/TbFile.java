/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.file.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 文件管理Entity
 * @author 毕业设计
 * @version 2018-03-17
 */
public class TbFile extends DataEntity<TbFile> {
	
	private static final long serialVersionUID = 1L;
	private String fileTitle;		// 文件名称
	private Integer fileIden;		// 文件类型
	private String filePath;		// 文件路径
	
	public TbFile() {
		super();
	}

	public TbFile(String id){
		super(id);
	}

	@Length(min=0, max=255, message="文件名称长度必须介于 0 和 255 之间")
	public String getFileTitle() {
		return fileTitle;
	}

	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
	
	public Integer getFileIden() {
		return fileIden;
	}

	public void setFileIden(Integer fileIden) {
		this.fileIden = fileIden;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}