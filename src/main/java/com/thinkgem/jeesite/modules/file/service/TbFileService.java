/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.file.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.file.entity.TbFile;
import com.thinkgem.jeesite.modules.file.dao.TbFileDao;

/**
 * 文件管理Service
 * @author 毕业设计
 * @version 2018-03-17
 */
@Service
@Transactional(readOnly = true)
public class TbFileService extends CrudService<TbFileDao, TbFile> {

	public TbFile get(String id) {
		return super.get(id);
	}
	
	public List<TbFile> findList(TbFile tbFile) {
		return super.findList(tbFile);
	}
	
	public Page<TbFile> findPage(Page<TbFile> page, TbFile tbFile) {
		return super.findPage(page, tbFile);
	}
	
	@Transactional(readOnly = false)
	public void save(TbFile tbFile) {
		super.save(tbFile);
	}
	
	@Transactional(readOnly = false)
	public void delete(TbFile tbFile) {
		super.delete(tbFile);
	}
	
}