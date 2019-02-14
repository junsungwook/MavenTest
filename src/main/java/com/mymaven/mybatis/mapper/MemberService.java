package com.mymaven.mybatis.mapper;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mymaven.mybatis.vo.MemberVO;

//Repository랑 같은 개념이나 리소스는 서비스와 짝  autowired는 repository와 짝
@Service("mService")
public class MemberService {

	@Resource(name="mDao")
	private MemberDAOImpl mDao;
	
	
	//insert
	public void insert(MemberVO user) {
		//서비스 단에서 "insertMEmber"라는 이름을 정해준다!
		mDao.insert("insertMember",user);
	}
}
