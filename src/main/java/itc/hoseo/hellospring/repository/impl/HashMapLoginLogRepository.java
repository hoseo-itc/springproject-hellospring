package itc.hoseo.hellospring.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import itc.hoseo.hellospring.domain.LoginLog;
import itc.hoseo.hellospring.repository.LoginLogRepository;

@Repository
public class HashMapLoginLogRepository implements LoginLogRepository{

	private Map<String, List<LoginLog>> logMap = new HashMap<>();
	
	@Override
	public void addLog(LoginLog log) {
		String memberId = log.getMember().getId();
		if(logMap.containsKey(memberId) == false) {
			logMap.put(memberId, new ArrayList<LoginLog>());
		}
		logMap.get(memberId).add(log);
		
	}

	@Override
	public List<LoginLog> getLoginLogs(String id) {
		if(logMap.containsKey(id) == false) {
			logMap.put(id, new ArrayList<LoginLog>());
		}
		
		return Collections.unmodifiableList(logMap.get(id));
	}

}
