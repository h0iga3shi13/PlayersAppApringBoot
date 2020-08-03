package com.higashi.players.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/*
 * BBS Entity
 */
@Entity
@Data
@Table(name = "bbs_master")
public class BBS {

	/*
	 * BBS id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BBS_ID")
	private Long bbsId;

	/*
	 * チームid (ユーザー登録時に紐付ける)
	 */
	@Column(name = "teamid")
	private String team;

	/*
	 * 開催日
	 */
	@Column(name = "eventday")
	private LocalDateTime event;

	/*
	 * 募集期日
	 */
	@Column(name = "application_deadline")
	private LocalDateTime deadline;

	/*
	 * 募集エリア
	 */
	@Column(name = "recruitment_area")
	private String area;

	/*
	 * 会場
	 */
	@Column(name = "venue")
	private String venue;

	/*
	 * 会費
	 */
	@Column(name = "membership_fee")
	private int cost;

	/*
	 * 募集人数(定員)
	 */
	@Column(name = "number_of_applicants")
	private int capacity;

	/*
	 * 募集レベル
	 */
	@Column(name = "technical_level")
	private int level;

	/*
	 * 種類
	 *
	 */
	@Column(name = "category")
	private String type;

	/*
	 * 本文
	 */
	@Column(name = "text")
	private String text;

	/*
	 * 作成日
	 */
	@Column(name = "created_date")
	private LocalDateTime created;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "BBS_USER", joinColumns = {
			@JoinColumn(name = "BBS_ID", referencedColumnName = "BBS_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID") })
	private UserTable userTable;
}
