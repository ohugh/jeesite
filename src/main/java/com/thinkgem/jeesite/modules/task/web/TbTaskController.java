/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.task.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.thinkgem.jeesite.modules.clas.entity.TbClass;
import com.thinkgem.jeesite.modules.clas.service.TbClassService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.thinkgem.jeesite.modules.task.entity.TbTask;
import com.thinkgem.jeesite.modules.task.service.TbTaskService;

/**
 * 作业发布管理Controller
 * @author 毕业设计
 * @version 2018-03-16
 */
@Controller
@RequestMapping(value = "${adminPath}/task/tbTask")
public class TbTaskController extends BaseController {

	@Autowired
	private TbTaskService tbTaskService;
	
	@Autowired
	private TbClassService tbClassService;
	
	@ModelAttribute
	public TbTask get(@RequestParam(required=false) String id) {
		TbTask entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tbTaskService.get(id);
		}
		if (entity == null){
			entity = new TbTask();
		}
		return entity;
	}
	
	@RequiresPermissions("task:tbTask:view")
	@RequestMapping(value = {"list", ""})
	public String list(TbTask tbTask, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbTask> page = tbTaskService.findPage(new Page<TbTask>(request, response), tbTask); 
		model.addAttribute("page", page);
		return "modules/task/tbTaskList";
	}
	
	
	@RequiresPermissions("task:tbTask:view")
	@RequestMapping(value = {"studentlist"})
	public String studenlist(TbTask tbTask, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbTask> page = tbTaskService.findPage(new Page<TbTask>(request, response), tbTask); 
		model.addAttribute("page", page);
		return "modules/task/studentTaskList";
	}

	@RequiresPermissions("task:tbTask:view")
	@RequestMapping(value = "form")
	public String form(TbTask tbTask, Model model) {
		
		List<TbClass> tbClassList = tbClassService.findList(new TbClass());
		
		Map<String,String> classNameList = new HashMap<String,String>();
		
		for(TbClass clas : tbClassList) {
			classNameList.put(clas.getClassName(),clas.getClassName());
		}
		model.addAttribute("tbTask", tbTask);
		model.addAttribute("classNameList", classNameList);
		return "modules/task/tbTaskForm";
	}

	@RequiresPermissions("task:tbTask:edit")
	@RequestMapping(value = "save")
	public String save(TbTask tbTask, Model model, RedirectAttributes redirectAttributes) {
		tbTask.setTaskCreateId(UserUtils.getUser().getId());	//保存当前发布作业的教师id
		if (!beanValidator(model, tbTask)){
			return form(tbTask, model);
		}
		tbTaskService.save(tbTask);
		addMessage(redirectAttributes, "保存作业信息成功");
		return "redirect:"+Global.getAdminPath()+"/task/tbTask/?repage";
	}
	
	@RequiresPermissions("task:tbTask:edit")
	@RequestMapping(value = "delete")
	public String delete(TbTask tbTask, RedirectAttributes redirectAttributes) {
		tbTaskService.delete(tbTask);
		addMessage(redirectAttributes, "删除作业信息成功");
		return "redirect:"+Global.getAdminPath()+"/task/tbTask/?repage";
	}

	
	
	/**
	 * 学生提交作业 列表
	 * @param tbTask
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequiresPermissions("task:tbTask:view")
	@RequestMapping(value = {"studentTasklist"})
	public String studentTasklist(TbTask tbTask, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TbTask> page = tbTaskService.findPage(new Page<TbTask>(request, response), tbTask); 
		model.addAttribute("page", page);
		return "modules/task/studentTaskList";
	}

	/**
	 * 学生提交作业详情页
	 * @param tbTask
	 * @param model
	 * @return
	 */
	@RequiresPermissions("task:tbTask:view")
	@RequestMapping(value = "studentTaskform")
	public String studentTaskform(TbTask tbTask, Model model) {
		
		
		
		
		model.addAttribute("tbTask", tbTask);
		return "modules/task/studentTaskForm";
	}
	
	/**
	 * 学生提交作业，保存方法，（没有写入提交人的id）
	 * @param tbTask
	 * @param model
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions("task:tbTask:edit")
	@RequestMapping(value = "studentTasksave")
	public String studentTasksave(TbTask tbTask, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tbTask)){
			return form(tbTask, model);
		}
		tbTaskService.save(tbTask);
		addMessage(redirectAttributes, "保存作业信息成功");
		return "redirect:"+Global.getAdminPath()+"/task/tbTask/studentTasklist/?repage";
	}
}