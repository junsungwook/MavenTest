package com.mymaven.mybatis.mapper;

import java.util.List;

import com.mymaven.mybatis.vo.MemberVO;


public interface MemberDAO {
	List<MemberVO> getMemberList(String sqlid);
	MemberVO findById(String sqlid,String id);
	void insert(String sqlid,MemberVO user);
	void update(String sqlid,MemberVO user);
	void delete(String sqlid,String id);
	List<MemberVO> search(String sqlid,String field,String word);
}
