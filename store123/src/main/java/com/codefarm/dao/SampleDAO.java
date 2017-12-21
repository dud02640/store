package com.codefarm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository("sampleDAO")
public class SampleDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
    public List<Map<String, Object>> selectBoardList(Map<String, Object> paraMap) throws Exception{
        return (List<Map<String, Object>>)selectList("sample.selectBoardList", paraMap);
    }

	public void insertBoardList(Map<String, Object> paraMap) {
		insert("sample.insertBoardList",paraMap);
	}
	public List<Map<String, Object>> selectUserList(Map<String, Object> map12) {
		return  (List<Map<String, Object>>)selectList("sample.selectUserList", map12);
	}

	public List<Map<String, Object>> selectlogincheck(Map<String, Object> paraMap) {
		return (List<Map<String, Object>>)selectList("sample.selectloginchek", paraMap);
	}

	public void deletelist(Map<String, Object> paraMap) {
		delete("sample.deleteList",paraMap);
	}

	public void insertBasketList(Map<String, Object> paraMap) {
		insert("sample.insertBasketList",paraMap);
	}

	public List<Map<String, Object>> selectPurchaseList(
			Map<String, Object> paraMap) {
		return (List<Map<String, Object>>)selectList("sample.selectpurchaselist", paraMap);
	}

	public void updatebasketlist(Map<String, Object> paraMap) {
		update("sample.updateBasketList",paraMap);
	}

	public void updatepoint(Map<String, Object> paraMap) {
		update("sample.updatePoint",paraMap);
	}

	public void updatepurchaseYN(Map<String, Object> paraMap) {
		update("sample.updatepurchaseYN",paraMap);
	}

	public void insertProductList(Map<String, Object> paraMap) {
		insert("sample.insertProductList",paraMap);
	}

	public void deletebasket(Map<String, Object> paraMap) {
		delete("sample.deletebasket",paraMap);
	}

}