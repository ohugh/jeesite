/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.question.web;

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
import com.thinkgem.jeesite.modules.question.entity.TbQuestions;
import com.thinkgem.jeesite.modules.question.service.TbQuestionsService;

/**
 * 提问回复管理Controller
 * @author 毕业设计
 * @version 2018-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/question/tbQuestions")
public class TbQuestionsController extends BaseController {

	@Autowired
	private TbQuestionsService tbQuestionsService;
	
	@ModelAttribute
	public TbQuestions get(@RequestParam(required=false) String id) {
		TbQuestions entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbQuestionsService.get(id);
		}
		if (entity == null){
			entity = new TbQuestions();
		}
		return entity;
	}
	
	@RequiresPermissions("question:tbQuestions:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbQuestions tbQuestions, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbQuestions> page = tbQuestionsService.findPage(new Page<TbQuestions>(request, response), tbQuestions); 
		model.addAttribute("page", page);
		return "modules/question/tbQuestionsList";
	}

	@RequiresPermissions("question:tbQuestions:view")
	@RequestMapping(value = "form")
	public String form(TbQuestions tbQuestions, Model model) {
		model.addAttribute("tbQuestions", tbQuestions);
		return "modules/question/tbQuestionsForm";
	}

	@RequiresPermissions("question:tbQuestions:edit")
	@RequestMapping(value = "save")
	public String save(TbQuestions tbQuestions, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbQuestions)){
			return form(tbQuestions, model);
		}
		tbQuestionsService.save(tbQuestions);
		addMessage(redirectAttributes, "保存回复信息成功");
		return "redirect:"+Global.getAdminPath()+"/question/tbQuestions/?repage";
	}
	
	@RequiresPermissions("question:tbQuestions:edit")
	@RequestMapping(value = "delete")
	public String delete(TbQuestions tbQuestions, RedirectAttributes redirectAttributes) {
		tbQuestionsService.delete(tbQuestions);
		addMessage(redirectAttributes, "删除回复信息成功");
		return "redirect:"+Global.getAdminPath()+"/question/tbQuestions/?repage";
	}

}