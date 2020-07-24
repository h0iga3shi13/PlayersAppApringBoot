package com.higashi.players.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.higashi.players.entity.BBS;
import com.higashi.players.repository.BBSRepository;

@Controller
public class TeamController {

	@Autowired
	BBSRepository bbsRepository;

	/*
	 * Team一覧
	 * チーム名を表示
	 */
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String index(Model model) {
		List<BBS> teamlist = bbsRepository.findAll();
		model.addAttribute("bbslist", teamlist);
		return "team";
	}

}
