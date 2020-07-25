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
public class HomeController {

	@Autowired
	BBSRepository bbsRepository;

	/*
	 * HOME画面
	 * BBSのタイトル、募集者、開催日、募集者、種類を表示
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		/*
		 * ログインユーザーの情報を取得する
		 * ログインしていないユーザーには"ゲストユーザー"を返す
		 */
		List<BBS> homelist = bbsRepository.findAll();
		model.addAttribute("bbslist", homelist);
		return "home";
	}
}
