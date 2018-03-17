/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.web;

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
import com.thinkgem.jeesite.modules.student.entity.TbStudent;
import com.thinkgem.jeesite.modules.student.service.TbStudentService;

/**
 * 学生管理Controller
 * @author 毕业设计
 * @version 2018-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/student/tbStudent")
public class TbStudentController extends BaseController {

	@Autowired
	private TbStudentService tbStudentService;
	
	@ModelAttribute
	public TbStudent get(@RequestParam(required=false) String id) {
		TbStudent entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbStudentService.get(id);
		}
		if (entity == null){
			entity = new TbStudent();
		}
		return entity;
	}
	
	@RequiresPermissions("student:tbStudent:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbStudent tbStudent, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbStudent> page = tbStudentService.findPage(new Page<TbStudent>(request, response), tbStudent); 
		model.addAttribute("page", page);
		return "modules/student/tbStudentList";
	}

	@RequiresPermissions("student:tbStudent:view")
	@RequestMapping(value = "form")
	public String form(TbStudent tbStudent, Model model) {
		model.addAttribute("tbStudent", tbStudent);
		return "modules/student/tbStudentForm";
	}

	@RequiresPermissions("student:tbStudent:edit")
	@RequestMapping(value = "save")
	public String save(TbStudent tbStudent, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbStudent)){
			return form(tbStudent, model);
		}
		tbStudentService.save(tbStudent);
		addMessage(redirectAttributes, "保存学生信息成功");
		return "redirect:"+Global.getAdminPath()+"/student/tbStudent/?repage";
	}
	
	@RequiresPermissions("student:tbStudent:edit")
	@RequestMapping(value = "delete")
	public String delete(TbStudent tbStudent, RedirectAttributes redirectAttributes) {
		tbStudentService.delete(tbStudent);
		addMessage(redirectAttributes, "删除学生信息成功");
		return "redirect:"+Global.getAdminPath()+"/student/tbStudent/?repage";
	}

}