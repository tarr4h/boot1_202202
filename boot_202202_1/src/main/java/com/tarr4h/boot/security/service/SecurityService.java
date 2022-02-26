package com.tarr4h.boot.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tarr4h.boot.security.dao.SecurityDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SecurityService implements UserDetailsService {
	
	@Autowired
	private SecurityDao securityDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails member = securityDao.loadUserByUsername(username);
		log.info("securityService username = {}", username);
		
		if(member == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return member;
	}

}
