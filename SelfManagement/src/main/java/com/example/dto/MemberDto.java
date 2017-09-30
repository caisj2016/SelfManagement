package com.example.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Cai.sj
 */
@Data
@Entity
@Table(name = "Member")
public class MemberDto extends TransactionEntity implements java.io.Serializable {
	@Id
	private Integer memberId;
	private String loginId;
	private String encodedPassword;
	private String nickName;
	private String email;
	private String birthday;
	private String gender;
	private String telphone;
	private Integer rank;
	private String adminRole;
	private Date createDate;
}
