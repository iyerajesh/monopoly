package org.activiti;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.domain.Manager;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClaimService {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private ManagerRepository managerRepository;

	private static final Logger logger = LoggerFactory.getLogger(ClaimService.class);

	public void startProcess(String assignee) {

		Manager person = managerRepository.findByUsername(assignee);

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("manager", person);
		runtimeService.startProcessInstanceByKey("colonialClaimsWorkflow", variables);
	}

	public List<Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}

	public void createDemoUsers() {

		logger.debug("Size of the Manager repository:" + managerRepository.findAll().size());

		if (managerRepository.findAll().size() == 0) {

			managerRepository.save(new Manager("sharon", "Sharon", "Amick", new Date()));
			managerRepository.save(new Manager("kareem", "Kareem", "Mitchell", new Date()));
		}
	}

}
