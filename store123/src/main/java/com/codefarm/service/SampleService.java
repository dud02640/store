package com.codefarm.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

public interface SampleService {
	List<Map<String, Object>> selectBoardList(Map<String, Object> paraMap) throws Exception;

	void insertBoardList(Map<String, Object> paraMap)throws Exception;

	List<Map<String, Object>> selectUserList(Map<String, Object> map12) throws Exception;

	List<Map<String, Object>> selectlogincheck(Map<String, Object> paraMap);

	void deletelist(Map<String, Object> paraMap);

	void insertbasketlist(Map<String, Object> paraMap);

	List<Map<String, Object>> selectpurchaselist(Map<String, Object> paraMap);

	void updatebasketlist(Map<String, Object> paraMap);

	void updatepoint(Map<String, Object> paraMap);

	void updatepurchaseYN(Map<String, Object> paraMap);

	void insertProductList(Map<String, Object> paraMap);

	void deletebasket(Map<String, Object> paraMap);

}
