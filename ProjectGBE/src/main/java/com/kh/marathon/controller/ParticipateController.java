package com.kh.marathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kh.marathon.model.service.ParticipateService;

public class ParticipateController {
	@Autowired
	private ParticipateService participateService;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	@RequestMapping("")
}
