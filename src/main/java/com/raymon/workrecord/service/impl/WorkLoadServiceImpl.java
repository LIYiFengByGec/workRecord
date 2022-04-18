package com.raymon.workrecord.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.raymon.workrecord.dao.WorkLoadMapper;
import com.raymon.workrecord.entity.Account;
import com.raymon.workrecord.entity.Demand;
import com.raymon.workrecord.entity.WorkLoad;
import com.raymon.workrecord.pojo.WordInfo;
import com.raymon.workrecord.pojo.WordInfo.PersonWorkload;
import com.raymon.workrecord.pojo.WordInfo.WorkloadContent;
import com.raymon.workrecord.pojo.WorkLoadForm;
import com.raymon.workrecord.pojo.WorkloadDetails;
import com.raymon.workrecord.service.AccountService;
import com.raymon.workrecord.service.DemandService;
import com.raymon.workrecord.service.WorkLoadService;
import com.raymon.workrecord.utils.FileUtils;
import com.raymon.workrecord.utils.JavaToWordUtils;

@Service
public class WorkLoadServiceImpl implements WorkLoadService {

	@Autowired
	private WorkLoadMapper workLoadMapper;
	@Autowired
	private DemandService demandService;
	@Autowired
	private AccountService accountService;
	
	@Override
	public void addWorkLoad(WorkLoad workload) {
		workLoadMapper.insert(workload);
	}

	@Override
	public void updateWorkLoad(WorkLoad workLoad) {
		workLoadMapper.updateById(workLoad);
	}

	@Override
	public List<WorkLoad> listWorkLoadByUserIdByTime(WorkLoadForm form) {
		return workLoadMapper.listWorkLoadByUserIdByTime(form.getUserId(), form.getSearchTime());
	}

	@Override
	public void deleteById(String workloadId) {
		workLoadMapper.deleteById(workloadId);
	}

	@Override
	public List<WorkloadDetails> listWorkLoadByTimeByDepartmentId(Date time, String departmentId) {
		return workLoadMapper.listWorkLoadByTimeByDepartmentId(time, departmentId);
	}

	@Override
	public List<WorkloadDetails> listWorkLoadByDepartmentIdByTimeRange(String departmentId, Date beginTime,
			Date endTime) {
		return workLoadMapper.listWorkLoadByDepartmentIdByTimeRange(departmentId, beginTime, endTime);
	}

	@Override
	public List<WorkLoad> listWorkLoadContentByTimeRange(String userId, String demandId, Date beginTime,
			Date endTime) {
		QueryWrapper<WorkLoad> query = new QueryWrapper<>();
		query.eq("demand_id", demandId);
		query.eq("user_id", userId);
		query.between("work_date", beginTime, endTime);
		query.orderByAsc("work_date");
		return workLoadMapper.selectList(query);
	}

	@Override
	public HttpServletResponse exportWord(String fullName, Date beginTime, Date endTime,HttpServletResponse response) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");  
		String dateNow = sdf.format(new Date());  
		List<Demand> demandList = demandService.listDemandByTimeRange(beginTime, endTime);
		List<Account> accountList = accountService.listWorkAccountByTimeRange(beginTime, endTime);
		List<PersonWorkload> personWorkloadList = new ArrayList<>();
		for (Account account : accountList) {
			PersonWorkload personWorkload = new PersonWorkload();
			personWorkload.setFullName(account.getFullName());
			List<Demand> demands = demandService.listDemandByTimeRangeByUserId(account.getUserId(), beginTime, endTime);
			List<WorkloadContent> workloadContentList = new ArrayList<>();
			for (Demand demand : demands) {
				WorkloadContent workloadContent = new WorkloadContent();
				List<WorkLoad> workloadList = this.listWorkLoadContentByTimeRange(account.getUserId(), demand.getDemandId(), beginTime, endTime);
				workloadContent.setDemandName(demand.getDemandName());
				workloadContent.setWorkloadList(workloadList);
				workloadContentList.add(workloadContent);
			}
			personWorkload.setWorkloadContentList(workloadContentList);
			personWorkloadList.add(personWorkload);
		}
		//封装wordinfo
		WordInfo wordInfo = WordInfo.builder()
				.recordPerson(fullName)
				.mettingTime(dateNow)
				.demandList(demandList)
				.personWorkloadList(personWorkloadList)
				.build();
		JavaToWordUtils.transWord(wordInfo);
		return FileUtils.downloadFile(response, "/usr/local/word/text.doc", "政务事业部周例会会议纪要.doc");
	}

}
