package com.higashi.players.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.higashi.players.dto.BBSRecord;
import com.higashi.players.service.BBSService;

@Controller
public class CommonController {

	@Autowired
	BBSService bbsService;

	/*
	 * BBS画面
	 * BBS 一覧画面を表示
	 */
	@RequestMapping(value = "/bbs", method = RequestMethod.GET)
	public String list(Model model) {
		List<BBSRecord> bbslist = bbsService.searchAll();
		model.addAttribute("bbslist", bbslist);
		return "bbs";
	}

	// login画面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

}
