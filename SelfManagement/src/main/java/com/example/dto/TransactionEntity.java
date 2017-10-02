package com.example.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/**
 * トランザクションデータのベース
 *
 * @author Cai.sj
 */
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class TransactionEntity {
	/** 削除フラグ */
	@Column(name = "DEL_FLG", updatable = false)
	private Integer delFlg = 0;

	/** 登録日時 */
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name = "CREATE_DATE", updatable = false)
	private Date createDate;

	/** 登録者名 */
	@CreatedBy
	@Column(name = "CREATE_NAME", nullable = false, updatable = false)
	private String createName;

	/** 更新日時 */
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	/** 更新者名 */
	@LastModifiedBy
	@Column(name = "UPDATE_NAME")
	private String updateName;

}
