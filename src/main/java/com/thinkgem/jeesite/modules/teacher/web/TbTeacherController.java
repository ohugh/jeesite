/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teacher.web;

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
import com.thinkgem.jeesite.modules.teacher.entity.TbTeacher;
import com.thinkgem.jeesite.modules.teacher.service.TbTeacherService;

/**
 * 教师管理Controller
 * @author 毕业设计
 * @version 2018-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/teacher/tbTeacher")
public class TbTeacherController extends BaseController {

	@Autowired
	private TbTeacherService tbTeacherService;
	
	@ModelAttribute
	public TbTeacher get(@RequestParam(required=false) String id) {
		TbTeacher entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbTeacherService.get(id);
		}
		if (entity == null){
			entity = new TbTeacher();
		}
		return entity;
	}
	
	@RequiresPermissions("teacher:tbTeacher:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbTeacher tbTeacher, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbTeacher> page = tbTeacherService.findPage(new Page<TbTeacher>(request, response), tbTeacher); 
		model.addAttribute("page", page);
		return "modules/teacher/tbTeacherList";
	}

	@RequiresPermissions("teacher:tbTeacher:view")
	@RequestMapping(value = "form")
	public String form(TbTeacher tbTeacher, Model model) {
		model.addAttribute("tbTeacher", tbTeacher);
		return "modules/teacher/tbTeacherForm";
	}

	@RequiresPermissions("teacher:tbTeacher:edit")
	@RequestMapping(value = "save")
	public String save(TbTeacher tbTeacher, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbTeacher)){
			return form(tbTeacher, model);
		}
		tbTeacherService.save(tbTeacher);
		addMessage(redirectAttributes, "保存教师信息成功");
		return "redirect:"+Global.getAdminPath()+"/teacher/tbTeacher/?repage";
	}
	
	@RequiresPermissions("teacher:tbTeacher:edit")
	@RequestMapping(value = "delete")
	public String delete(TbTeacher tbTeacher, RedirectAttributes redirectAttributes) {
		tbTeacherService.delete(tbTeacher);
		addMessage(redirectAttributes, "删除教师信息成功");
		return "redirect:"+Global.getAdminPath()+"/teacher/tbTeacher/?repage";
	}

}