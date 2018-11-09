package com.stephulz.ProjectAsh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stephulz.ProjectAsh.repositories.CdkeyRepository;

@Service
public class CdkeyService {

	@Autowired
	private CdkeyRepository repo;
	
}
