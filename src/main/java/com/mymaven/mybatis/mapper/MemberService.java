package com.mymaven.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

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
	
	//list
	public List<MemberVO> list() {
		return mDao.getMemberList("listMember");
	}
	
	//detail
	public MemberVO detail(String id) {
		return mDao.findById("detail", id);
	}
	//update
	public void update(MemberVO user) {
		mDao.update("update", user);
	}
	//delete
	public void delete(String id) {
		mDao.delete("delete", id);
	}
	//select
	public List<MemberVO> select(String field,String word) {
		return mDao.search("select",field,word);
	}
	
	//페이징 되는 리스트
	public List<MemberVO> memberList(int startRow, int endRow,String field,String word){
		System.out.println("서비스"+field);
		System.out.println("서비스"+word);
	  String sRow = String.valueOf(startRow);
	  String eRow = String.valueOf(endRow);
	  HashMap<String, String> hm = new HashMap<String, String>();
	  hm.put("startRow", sRow);
	  hm.put("endRow", eRow);
	  hm.put("field",field);
	  hm.put("word",word);
	  List<MemberVO> arr = mDao.paging("pageMember",hm);
	  return arr;
	}
	
	
}
