package com.higashi.players.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/*
 * Add Entity
 * DBに入れる値を格納するクラス
 */
@Entity
@Data
@Table(name = "add_master")
public class Add {

	/*
	 * add ID
	 */
	@Id
	//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long userId;

	/*
	 * 名前
	 */
	@Column(name = "username")
	private String name;

	/*
	 * 所属チーム名
	 */
	@Column(name = "teamid")
	private String team;

	/*
	 * ポジション
	 */
	@Column(name = "position")
	private String position;

	/*
	 * 更新日時
	 */
	@Column(name = "update_date")
	private LocalDateTime updateDate;

	/**
	 * 登録日時
	 */
	@Column(name = "create_date")
	private LocalDateTime createDate;

	/**
	 * 削除日時
	 */
	@Column(name = "delete_date")
	private LocalDateTime deleteDate;

	@OneToOne
	@MapsId
	private UserTable userTable;

}
