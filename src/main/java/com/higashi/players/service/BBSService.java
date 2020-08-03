package com.higashi.players.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.higashi.players.dto.BBSForm;
import com.higashi.players.dto.BBSRecord;
import com.higashi.players.entity.BBS;
import com.higashi.players.repository.BBSRepository;
import com.higashi.players.repository.UserTableRepository;
import com.higashi.players.util.LoginState;

@Service
@Transactional(rollbackOn = Exception.class)
public class BBSService {

	/*
	 * BBS Repository
	 */
	@Autowired
	BBSRepository bbsRepository;

	@Autowired
	UserTableRepository userTableRepository;

	/*
	 * BBS情報 全検索
	 * return 検索結果
	 */
	public List<BBSRecord> searchAll() {

		List<BBSRecord> bbsRecords = new ArrayList<BBSRecord>();
		for (BBS bbs : bbsRepository.findAll()) {
			String userName = bbs.getUserTable().getAdd().getName();
			BBSRecord bbsRecord = new BBSRecord();
			bbsRecord.setBbs(bbs);
			bbsRecord.setUserName(userName);
			bbsRecords.add(bbsRecord);
		}
		return bbsRecords;

	}

	/*
	 * BBS情報新規登録
	 *
	 */
	public void create(BBSForm formRequest) {
		bbsRepository.save(createBBS(formRequest));
	}

	/*
	 * Entityの生成
	 * @param formRequest
	 * @return ユーザーTBL Entity
	 */

	private BBS createBBS(BBSForm formRequest) {

		BBS bbs = new BBS();

		bbs.setUserTable(userTableRepository.findByEmail(LoginState.loginEmail()));
		bbs.setTeam(formRequest.getTeam());
		bbs.setEvent(formRequest.getEvent().atTime(0, 0, 0));
		bbs.setDeadline(formRequest.getDeadline().atTime(0, 0, 0));
		bbs.setArea(formRequest.getArea());
		bbs.setVenue(formRequest.getVenue());
		bbs.setCost(formRequest.getCost());
		bbs.setCapacity(formRequest.getCapacity());
		bbs.setLevel(formRequest.getLevel());
		bbs.setType(formRequest.getType());
		bbs.setText(formRequest.getText());

		bbs.setCreated(LocalDateTime.now()); // 作成日を自動生成

		return bbs;
	}

}
