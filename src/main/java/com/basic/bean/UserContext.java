package com.basic.bean;

import java.math.BigDecimal;;

public class UserContext {
	
    private final String username;
	
	private final Integer UID;//用户id
	
	private BigDecimal COIN;
	
	private BigDecimal FCION;
	
	private BigDecimal AGENT_COIN;
	
	public BigDecimal getAGENT_COIN() {
		return AGENT_COIN;
	}

	private String USERTYPE;
	
	private int chatAdmin;
	
	private String data;

    private UserContext(String username,Integer UID, BigDecimal FCION, BigDecimal COIN) {
        this.username = username;
        this.UID = UID;
        this.COIN = COIN;
        this.FCION = FCION;
    }
    
    private UserContext(String username, Integer UID, BigDecimal FCION, BigDecimal COIN,int chatAdmin,String data,BigDecimal AGENT_COIN,String USERTYPE) {
        this.username = username;
        this.UID = UID;
        this.COIN = COIN;
        this.FCION = FCION;
        this.chatAdmin=chatAdmin;
        this.data = data;
        this.AGENT_COIN = AGENT_COIN;
        this.USERTYPE = USERTYPE;
    }
    
    private UserContext(String username,Integer UID, BigDecimal FCION, BigDecimal COIN,int chatAdmin,String data) {
        this.username = username;
        this.UID = UID;
        this.COIN = COIN;
        this.FCION = FCION;
        this.chatAdmin=chatAdmin;
        this.data = data;
    }
    
    private UserContext(String username,Integer UID) {
        this.username = username;
        this.UID = UID;
    }
   
    public String getUsername() {
        return username;
    }

	public Integer getUID() {
		return UID;
	}

	public BigDecimal getCOIN() {
		return COIN;
	}

	public BigDecimal getFCION() {
		return FCION;
	}

	public int getChatAdmin() {
		return chatAdmin;
	}
	
	public String getData() {
		return data;
	}
	public String getUSERTYPE() {
		return USERTYPE;
	}

	@Override
	public String toString() {
		return "UserContext [username=" + username + ", UID=" + UID + ", COIN=" + COIN + ", FCION=" + FCION
				+ ", AGENT_COIN=" + AGENT_COIN + ", USERTYPE=" + USERTYPE + ", chatAdmin=" + chatAdmin + ", data="
				+ data + "]";
	}
}
