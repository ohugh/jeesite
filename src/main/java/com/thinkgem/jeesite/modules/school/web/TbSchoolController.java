/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.school.web;

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
import com.thinkgem.jeesite.modules.school.entity.TbSchool;
import com.thinkgem.jeesite.modules.school.service.TbSchoolService;

/**
 * 学院管理Controller
 * @author 毕业设计
 * @version 2018-03-17
 */
@Controller
@RequestMapping(value = "${adminPath}/school/tbSchool")
public class TbSchoolController extends BaseController {

	@Autowired
	private TbSchoolService tbSchoolService;
	
	@ModelAttribute
	public TbSchool get(@RequestParam(required=false) String id) {
		TbSchool entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbSchoolService.get(id);
		}
		if (entity == null){
			entity = new TbSchool();
		}
		return entity;
	}
	
	@RequiresPermissions("school:tbSchool:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbSchool tbSchool, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbSchool> page = tbSchoolService.findPage(new Page<TbSchool>(request, response), tbSchool); 
		model.addAttribute("page", page);
		return "modules/school/tbSchoolList";
	}

	@RequiresPermissions("school:tbSchool:view")
	@RequestMapping(value = "form")
	public String form(TbSchool tbSchool, Model model) {
		model.addAttribute("tbSchool", tbSchool);
		return "modules/school/tbSchoolForm";
	}

	@RequiresPermissions("school:tbSchool:edit")
	@RequestMapping(value = "save")
	public String save(TbSchool tbSchool, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbSchool)){
			return form(tbSchool, model);
		}
		tbSchoolService.save(tbSchool);
		addMessage(redirectAttributes, "保存学院信息成功");
		return "redirect:"+Global.getAdminPath()+"/school/tbSchool/?repage";
	}
	
	@RequiresPermissions("school:tbSchool:edit")
	@RequestMapping(value = "delete")
	public String delete(TbSchool tbSchool, RedirectAttributes redirectAttributes) {
		tbSchoolService.delete(tbSchool);
		addMessage(redirectAttributes, "删除学院信息成功");
		return "redirect:"+Global.getAdminPath()+"/school/tbSchool/?repage";
	}

}