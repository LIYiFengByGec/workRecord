package com.raymon.workrecord.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.raymon.workrecord.common.R;
import com.raymon.workrecord.entity.WorkLoad;
import com.raymon.workrecord.pojo.WorkLoadForm;
import com.raymon.workrecord.pojo.WorkloadDetails;
import com.raymon.workrecord.service.WorkLoadService;

@RestController
@RequestMapping("workload")
public class WorkLoadController {
	
	@Autowired
	private WorkLoadService workLoadService;
	
	// 添加一条工作量
	@PostMapping("/addWorkLoad")
	public R addWorkLoad(@RequestBody WorkLoad workload) {
		workLoadService.addWorkLoad(workload);
		return R.ok();
	}
	
	// 修改工作量信息
	@PutMapping("/updateWorkLoad")
	public R updateWorkLoad(@RequestBody WorkLoad workLoad) {
		workLoadService.updateWorkLoad(workLoad);
		return R.ok();
	}
	//删除一条工作量
	@DeleteMapping("/deleteById/{workloadId}")
	public R deleteById(@PathVariable String workloadId) {
		workLoadService.deleteById(workloadId);
		return R.ok();
	}
	// 根据指定时间查询指定员工工作量信息
	@PostMapping("/listWorkLoadByUserIdByTime")
	public R listWorkLoadByUserIdByTime(@RequestBody WorkLoadForm form) {
		List<WorkLoad> list = workLoadService.listWorkLoadByUserIdByTime(form);
		return R.ok().put(list);
	}
	
	// 查询某一天某个部门所有员工的工作记录
	@PostMapping("/listWorkLoadByTimeByDepartmentId")
	public R listWorkLoadByTimeByDepartmentId(@RequestBody WorkLoadForm form) {
		List<WorkloadDetails> list = workLoadService.listWorkLoadByTimeByDepartmentId(form.getSearchTime(), form.getDepartmentId());
		return R.ok().put(list);
	}
	
	// 查询一段时间内部门下各个成员每个需求的工作量合计
	@PostMapping("/listWorkLoadByDepartmentIdByTimeRange")
	public R listWorkLoadByDepartmentIdByTimeRange(@RequestBody WorkLoadForm form) {
		List<WorkloadDetails> list = workLoadService.listWorkLoadByDepartmentIdByTimeRange(form.getDepartmentId(), form.getBeginTime(), form.getEndTime());
		return R.ok().put(list);
	}
}
