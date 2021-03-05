package com.kingston.jforgame.server.game.accout.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.kingston.jforgame.server.db.BaseEntity;
import com.kingston.jforgame.server.thread.ThreadCenter;
import com.kingston.jforgame.server.utils.IdGenerator;
import com.kingston.jforgame.socket.actor.MailBox;


@Entity
public class AccountEnt extends BaseEntity<Long>  {
	
	@Id
	@Column
	private Long id;
	
	@Column
	private String name;
	
	public AccountEnt() {
		this.id = IdGenerator.getNextId();
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public MailBox mailBox() {
		return ThreadCenter.getLoginQueue().getSharedMailQueue(id);
	}
}
