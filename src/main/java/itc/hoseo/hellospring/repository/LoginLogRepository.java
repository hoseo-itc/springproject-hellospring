package itc.hoseo.hellospring.repository;

import java.util.List;

import itc.hoseo.hellospring.domain.LoginLog;

public interface LoginLogRepository {

	public void addLog(LoginLog log);
	
	public List<LoginLog> getLoginLogs(String id);
	
}
