package com.mymaven.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

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
	
	//����¡ �Ǵ� ����Ʈ
	public List<MemberVO> memberList(int startRow, int endRow,String field,String word){
		System.out.println("����"+field);
		System.out.println("����"+word);
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
