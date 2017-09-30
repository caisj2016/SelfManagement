package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.dto.MemberDto;

/**
 * @author Cai.sj
 */
@Repository
public interface UserRepository extends JpaRepository<MemberDto, String> {
	@Query("SELECT t from MemberDto t where  t.loginId=:loginId and t.delFlg = 0")
	MemberDto findOne(@Param("loginId") String loginId);
}