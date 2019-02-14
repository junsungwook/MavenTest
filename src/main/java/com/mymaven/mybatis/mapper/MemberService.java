package com.mymaven.mybatis.mapper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mymaven.mybatis.vo.MemberVO;

//Repository�� ���� �����̳� ���ҽ��� ���񽺿� ¦  autowired�� repository�� ¦
@Service("mService")
public class MemberService {

	@Resource(name="mDao")
	private MemberDAOImpl mDao;
	
	
	//insert
	public void insert(MemberVO user) {
		//���� �ܿ��� "insertMEmber"��� �̸��� �����ش�!
		mDao.insert("insertMember",user);
	}
}
