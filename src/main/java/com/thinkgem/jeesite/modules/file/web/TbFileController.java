/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.file.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.file.entity.TbFile;
import com.thinkgem.jeesite.modules.file.service.TbFileService;

/**
 * 文件管理Controller
 * @author 毕业设计
 * @version 2018-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/file/tbFile")
public class TbFileController extends BaseController {

	@Autowired
	private TbFileService tbFileService;
	
	@ModelAttribute
	public TbFile get(@RequestParam(required=false) String id) {
		TbFile entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbFileService.get(id);
		}
		if (entity == null){
			entity = new TbFile();
		}
		return entity;
	}
	
	@RequiresPermissions("file:tbFile:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbFile tbFile, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbFile> page = tbFileService.findPage(new Page<TbFile>(request, response), tbFile); 
		model.addAttribute("page", page);
		return "modules/file/tbFileList";
	}

	@RequiresPermissions("file:tbFile:view")
	@RequestMapping(value = "form")
	public String form(TbFile tbFile, Model model) {
		model.addAttribute("tbFile", tbFile);
		return "modules/file/tbFileForm";
	}

	@RequiresPermissions("file:tbFile:edit")
	@RequestMapping(value = "save")
	public String save(TbFile tbFile, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbFile)){
			return form(tbFile, model);
		}
		tbFileService.save(tbFile);
		addMessage(redirectAttributes, "保存文件成功");
		return "redirect:"+Global.getAdminPath()+"/file/tbFile/?repage";
	}
	
	@RequiresPermissions("file:tbFile:edit")
	@RequestMapping(value = "delete")
	public String delete(TbFile tbFile, RedirectAttributes redirectAttributes) {
		tbFileService.delete(tbFile);
		addMessage(redirectAttributes, "删除文件成功");
		return "redirect:"+Global.getAdminPath()+"/file/tbFile/?repage";
	}

}