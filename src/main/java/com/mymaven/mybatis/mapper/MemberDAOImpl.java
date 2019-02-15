package com.mymaven.mybatis.mapper;

import java.util.HashMap;
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
	
	
	/*
	 * @Autowired private SqlSessionFactory sqlMapper;
	 */
	@Autowired
	private SqlSession sqlMap;
	
	@Override
	public List<MemberVO> getMemberList(String sqlid) {
		// TODO Auto-generated method stub
		//openSession은 SqlSession객체를 생성하는 명령어
		//SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberVO> list = sqlMap.selectList(sqlid);
		return list;
	}

	@Override
	public MemberVO findById(String sqlid, String id) {
		//SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		MemberVO user = sqlMap.selectOne("detail",id);
		return user;
	}

	@Override
	public void insert(String sqlid, MemberVO user) {
		//SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.insert(sqlid,user);
		//sqlMap.commit();
		
	}

	@Override
	public void update(String sqlid, MemberVO user) {
		//SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.update(sqlid, user);
		//sqlMap.commit();
		//지워도 되네...버전업때문에
	}

	@Override
	public void delete(String sqlid, String id) {
		//SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.delete(sqlid, id);
		//sqlMap.commit();
		
	}

	@Override
	public List<MemberVO> search(String sqlid, String field, String word) {
		/*
		 * SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
		 * HashMap<String, String> hm = new HashMap<String, String>(); hm.put("field",
		 * field); hm.put("word", word); List<MemberVO> list =
		 * sqlMap.selectList("select", hm); return list;
		 */
		return null;
	}
	
   public List<MemberVO> paging(String sqlid, HashMap<String, String> hm){
      //SqlSession sqlMap = sqlMapper.openSession(ExecutorType.REUSE);
	   System.out.println(hm.get("field"));
	   System.out.println(hm.get("word"));
      List<MemberVO> arr= sqlMap.selectList(sqlid,hm);
      System.out.println(arr.size());
      return arr;
   }

	

	



	
	


}
