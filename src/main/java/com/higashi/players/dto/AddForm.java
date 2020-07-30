package com.higashi.players.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

/*
 * 会員登録form リクエストデータ
 */
@Data
public class AddForm implements Serializable {

	/*
	 * 名前(ユーザー名)
	 */
	@NotBlank(message = "名前を入力してください")
	@Size(max = 64)
	private String name;

	/*
	 * 所属チーム名(bbs情報と紐付けする)
	 */
	@NotBlank(message = "所属チーム名を入力してください")
	@Size(max = 64)
	private String team;

	/*
	 * ポジション
	 */
	@NotBlank(message = "投手、捕手、一塁手、二塁手、三塁手、遊撃手、外野手")
	private String position;

}
