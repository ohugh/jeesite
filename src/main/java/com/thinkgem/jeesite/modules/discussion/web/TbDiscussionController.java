/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.discussion.web;

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
import com.thinkgem.jeesite.modules.discussion.entity.TbDiscussion;
import com.thinkgem.jeesite.modules.discussion.service.TbDiscussionService;

/**
 * 讨论管理Controller
 * @author 毕业设计
 * @version 2018-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/discussion/tbDiscussion")
public class TbDiscussionController extends BaseController {

	@Autowired
	private TbDiscussionService tbDiscussionService;
	
	@ModelAttribute
	public TbDiscussion get(@RequestParam(required=false) String id) {
		TbDiscussion entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbDiscussionService.get(id);
		}
		if (entity == null){
			entity = new TbDiscussion();
		}
		return entity;
	}
	
	@RequiresPermissions("discussion:tbDiscussion:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbDiscussion tbDiscussion, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbDiscussion> page = tbDiscussionService.findPage(new Page<TbDiscussion>(request, response), tbDiscussion); 
		model.addAttribute("page", page);
		return "modules/discussion/tbDiscussionList";
	}

	@RequiresPermissions("discussion:tbDiscussion:view")
	@RequestMapping(value = "form")
	public String form(TbDiscussion tbDiscussion, Model model) {
		model.addAttribute("tbDiscussion", tbDiscussion);
		return "modules/discussion/tbDiscussionForm";
	}

	@RequiresPermissions("discussion:tbDiscussion:edit")
	@RequestMapping(value = "save")
	public String save(TbDiscussion tbDiscussion, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbDiscussion)){
			return form(tbDiscussion, model);
		}
		tbDiscussionService.save(tbDiscussion);
		addMessage(redirectAttributes, "保存讨论回复信息成功");
		return "redirect:"+Global.getAdminPath()+"/discussion/tbDiscussion/?repage";
	}
	
	@RequiresPermissions("discussion:tbDiscussion:edit")
	@RequestMapping(value = "delete")
	public String delete(TbDiscussion tbDiscussion, RedirectAttributes redirectAttributes) {
		tbDiscussionService.delete(tbDiscussion);
		addMessage(redirectAttributes, "删除讨论回复信息成功");
		return "redirect:"+Global.getAdminPath()+"/discussion/tbDiscussion/?repage";
	}

}