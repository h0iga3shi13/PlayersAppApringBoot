package com.higashi.players.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.higashi.players.dto.AddForm;
import com.higashi.players.entity.Add;
import com.higashi.players.repository.AddRepository;
import com.higashi.players.repository.UserTableRepository;
import com.higashi.players.util.LoginState;

@Service
@Transactional(rollbackOn = Exception.class)
public class AddService {
	@Autowired
	AddRepository addRepository;

	@Autowired
	UserTableRepository userTableRepository;

	/*
	 * 会員登録情報 全検索
	 * return 検索結果
	 */
	public List<Add> searchAll() {
		return addRepository.findAll();
	}

	/*
	 * 会員情報 新規登録
	 */
	public void create(AddForm addRequest) {
		addRepository.save(createAdd(addRequest));
	}

	/*
	 * ユーザー情報削除
	 * userRepository.deleteById()メソッドを使って削除処理を行うdelete()メソッド
	 */
	public void delete(Long id) {
		addRepository.deleteById(id);

	}

	/*
	 * 入力された値をDBに保存
	 * @param addForm
	 * @return ユーザーTBL Entity
	 */
	private Add createAdd(AddForm addRequest) {

		Add add = new Add();

		add.setUserTable(userTableRepository.findByEmail(LoginState.loginEmail()));
		add.setName(addRequest.getName());
		add.setTeam(addRequest.getTeam());
		add.setPosition(addRequest.getPosition());
		add.setCreateDate(LocalDateTime.now());
		add.setUpdateDate(LocalDateTime.now());

		return add;
	}

}
