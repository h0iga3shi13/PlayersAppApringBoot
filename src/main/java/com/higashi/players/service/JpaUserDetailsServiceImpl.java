package com.higashi.players.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.higashi.players.entity.UserTable;
import com.higashi.players.repository.UserTableRepository;

@Component
public class JpaUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserTableRepository userTableRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { //UserDetailsServiceインターフェースを実装することで、任意の保存場所から認証ユーザー情報を取得することができる
		UserTable table = userTableRepository.findByEmail(email);
		return table;
	}

}
