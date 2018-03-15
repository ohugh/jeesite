/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.issue.web;

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
import com.thinkgem.jeesite.modules.issue.entity.TbIssue;
import com.thinkgem.jeesite.modules.issue.service.TbIssueService;
import com.thinkgem.jeesite.modules.oa.entity.OaNotify;

/**
 * 学生问题管理Controller
 * @author 毕业设计
 * @version 2018-03-15
 */
@Controller
@RequestMapping(value = "${adminPath}/issue/tbIssue")
public class TbIssueController extends BaseController {

	@Autowired
	private TbIssueService tbIssueService;
	
	@ModelAttribute
	public TbIssue get(@RequestParam(required=false) String id) {
		TbIssue entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbIssueService.get(id);
		}
		if (entity == null){
			entity = new TbIssue();
		}
		return entity;
	}
	
	@RequiresPermissions("issue:tbIssue:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbIssue tbIssue, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbIssue> page = tbIssueService.findPage(new Page<TbIssue>(request, response), tbIssue); 
		model.addAttribute("page", page);
		return "modules/issue/tbIssueList";
	}

	@RequiresPermissions("issue:tbIssue:view")
	@RequestMapping(value = "form")
	public String form(TbIssue tbIssue, Model model) {
		model.addAttribute("tbIssue", tbIssue);
		return "modules/issue/tbIssueForm";
	}

	@RequiresPermissions("issue:tbIssue:edit")
	@RequestMapping(value = "save")
	public String save(TbIssue tbIssue, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbIssue)){
			return form(tbIssue, model);
		}
		tbIssueService.save(tbIssue);
		addMessage(redirectAttributes, "保存问题信息成功");
		return "redirect:"+Global.getAdminPath()+"/issue/tbIssue/?repage";
	}
	
	@RequiresPermissions("issue:tbIssue:edit")
	@RequestMapping(value = "delete")
	public String delete(TbIssue tbIssue, RedirectAttributes redirectAttributes) {
		tbIssueService.delete(tbIssue);
		addMessage(redirectAttributes, "删除问题信息成功");
		return "redirect:"+Global.getAdminPath()+"/issue/tbIssue/?repage";
	}
	
	/**
	 * 是否显示另一个标题
	 */
	@RequestMapping(value = "self")
	public String selfList(TbIssue tbIssue, HttpServletRequest request, HttpServletResponse response, Model model) {
		tbIssue.setSelf(true);
		
		Page<TbIssue> page = tbIssueService.findPage(new Page<TbIssue>(request, response), tbIssue); 
		model.addAttribute("page", page);
		return "modules/issue/tbIssueList";

	}

}