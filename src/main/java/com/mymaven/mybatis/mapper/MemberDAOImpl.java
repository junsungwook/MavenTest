package com.mymaven.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mymaven.mybatis.vo.MemberVO;

@Repository("mDao")
public class MemberDAOImpl implements MemberDAO{

	
	//root-context의 sqlMapper와 일치시킨다
	@Autowired
	private SqlSessionFactory sqlMapper;
	
	
	@Override
	public List<MemberVO> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findById(String sqlid, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(String sqlid, MemberVO user) {
		SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.insert(sqlid,user);
		sqlMap.commit();
		
	}

	@Override
	public void update(String sqlid, MemberVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String sqlid, String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberVO> search(String sqlid, String field, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	



	
	


}
