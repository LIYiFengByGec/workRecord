package com.raymon.workrecord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raymon.workrecord.common.R;
import com.raymon.workrecord.entity.Demand;
import com.raymon.workrecord.service.DemandService;

@RestController
@RequestMapping("demand")
public class DemandController {

	@Autowired
	private DemandService demandService;
	
	// 新增需求
	@PostMapping("/addDemand")
	public R addDemand(@RequestBody Demand demand) {
		demandService.addDemand(demand);
		return R.ok();
	}
	
	// 更新需求
	@PutMapping("/updateDemand")
	public R updateDemand(@RequestBody Demand demand) {
		demandService.updateDemand(demand);
		return R.ok();
	}
	
	// 查询需求列表,按创建时间倒序排序
	@GetMapping("/listDemand")
	public R listDemand() {
		List<Demand> list = demandService.listDemand();
		return R.ok().put(list);
	}
	
	// 更新是否已建单状态
	@GetMapping("/updateDemandCreateByDemandId/{demandId}")
	public R updateDemandCreateByDemandId(@PathVariable String demandId) {
		demandService.updateDemandCreateByDemandId(demandId);
		return R.ok();
	}
	
	// 更新是否完成信息
	@GetMapping("/updateDemandFinishByDemandId/{demandId}")
	public R updateDemandFinishByDemandId(@PathVariable String demandId) {
		demandService.updateDemandFinishByDemandId(demandId);
		return R.ok();
	}
}
