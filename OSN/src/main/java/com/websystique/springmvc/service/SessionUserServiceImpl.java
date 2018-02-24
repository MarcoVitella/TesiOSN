package com.websystique.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.SessionUserDao;
import com.websystique.springmvc.model.SessionUser;
import com.websystique.springmvc.model.User;

@Service("sessionUserService")
@Transactional
public class SessionUserServiceImpl implements SessionUserService{

	@Autowired 
	private SessionUserDao dao;




	public void saveSession(SessionUser u) {
		dao.saveSession(u);

	}


	public void updateSession(User u, String s) {

		SessionUser user=dao.getSessionUser(u);
		if(user!=null){
			user.setSessionId(s);
		}
		dao.saveSession(user);
	}


	public SessionUser getSessionUser(User u) {
		SessionUser sesUser=dao.getSessionUser(u);
		return sesUser;
	}


	public void deleteSession(User u) {
		dao.deleteSession(u);

	}



}
