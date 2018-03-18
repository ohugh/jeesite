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
		tbIssue.setIssueStatus(0);				//添加代码 每次修改后，状态都要变成 未通过
		if (!beanValidator(model, tbIssue)){	//验证form表	单传过来对象的有效性
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
	
	/**添加代码
	 * 是否显示另一个标题
	 */
	@RequestMapping(value = "self")
	public String selfList(TbIssue tbIssue, HttpServletRequest request, HttpServletResponse response, Model model) {
		tbIssue.setSelf(true);
		
		Page<TbIssue> page = tbIssueService.findPage(new Page<TbIssue>(request, response), tbIssue); 
		model.addAttribute("page", page);
		return "modules/issue/tbIssueList";

	}
	
	//老师审核学生问题 开始
	@RequiresPermissions("issue:tbIssue:view")
	@RequestMapping(value = "checklist")
	public String checklist(TbIssue tbIssue, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbIssue> page = tbIssueService.findPage(new Page<TbIssue>(request, response), tbIssue); 
		model.addAttribute("page", page);
		return "modules/issue/checkIssueList";
	}

	@RequiresPermissions("issue:tbIssue:view")
	@RequestMapping(value = "checkform")
	public String checkform(TbIssue tbIssue, Model model) {
		model.addAttribute("tbIssue", tbIssue);
		return "modules/issue/checkIssueForm";
	}
	
	@RequiresPermissions("issue:tbIssue:edit")
	@RequestMapping(value = "checksave")
	public String checksave(TbIssue tbIssue, Model model, RedirectAttributes redirectAttributes) {
		tbIssue.setIssueStatus(1);				//从老师通过页面后，状态要变成 通过
		if (!beanValidator(model, tbIssue)){	//验证form表	单传过来对象的有效性
			return form(tbIssue, model);
		}
		System.out.println(tbIssue.getIssueStatus());
		tbIssueService.save(tbIssue);
		addMessage(redirectAttributes, "保存问题信息成功");
		return "redirect:"+Global.getAdminPath()+"/issue/tbIssue/checklist/?repage";
	}
	//老师审核学生问题 结束
	

	//老师回复学生问题 开始
	//回复的list 页面对应处理方法
	@RequiresPermissions("issue:tbIssue:view")
	@RequestMapping(value = "replylist")
	public String replylist(TbIssue tbIssue, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println(tbIssue.getIssueStatus());
		Page<TbIssue> page = tbIssueService.findPagelist(new Page<TbIssue>(request, response), tbIssue); 
		model.addAttribute("page", page);
		return "modules/issue/replyIssueList";
	}
	
	//回复的form 页面对应处理方法
	
	@RequiresPermissions("issue:tbIssue:view")
	@RequestMapping(value = "replyform")
	public String replyform(TbIssue tbIssue, Model model) {
		System.out.println(tbIssue.getteacherid());
		model.addAttribute("tbIssue", tbIssue);
		return "modules/issue/replyIssueForm";
	}
	
	//TODO 没有给老师的id写入进去
	@RequiresPermissions("issue:tbIssue:edit")
	@RequestMapping(value = "replysave")
	public String replysave(TbIssue tbIssue, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbIssue)){	//验证form表	单传过来对象的有效性
			return form(tbIssue, model);
		}
		tbIssueService.save(tbIssue);
		addMessage(redirectAttributes, "保存问题信息成功");
		return "redirect:"+Global.getAdminPath()+"/issue/tbIssue/replylist/?repage";
	}


}
