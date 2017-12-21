package com.codefarm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.codefarm.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
    Logger log = Logger.getLogger(this.getClass());

    @Resource(name="sampleDAO")
    private SampleDAO sampleDAO;
    

    @Override
    public List<Map<String, Object>> selectBoardList(Map<String, Object> paraMap) throws Exception {
        return sampleDAO.selectBoardList(paraMap);
    }

	@Override
	public void insertBoardList(Map<String,Object> paraMap) throws Exception {
		sampleDAO.insertBoardList(paraMap);	
	}

	@Override
	public List<Map<String, Object>> selectUserList(Map<String, Object> map12)
			throws Exception {
		return sampleDAO.selectUserList(map12);
	}
	@Override
	public List<Map<String, Object>> selectlogincheck(Map<String, Object> paraMap) {
		return sampleDAO.selectlogincheck(paraMap);
	}

	@Override
	public void deletelist(Map<String, Object> paraMap) {
		sampleDAO.deletelist(paraMap);	
	}

	@Override
	public void insertbasketlist(Map<String, Object> paraMap) {
		sampleDAO.insertBasketList(paraMap);	
	}

	@Override
	public List<Map<String, Object>> selectpurchaselist(
			Map<String, Object> paraMap) {
		return sampleDAO.selectPurchaseList(paraMap);
	}

	@Override
	public void updatebasketlist(Map<String, Object> paraMap) {
		sampleDAO.updatebasketlist(paraMap);	
	}

	@Override
	public void updatepoint(Map<String, Object> paraMap) {
		sampleDAO.updatepoint(paraMap);
	}

	@Override
	public void updatepurchaseYN(Map<String, Object> paraMap) {
		sampleDAO.updatepurchaseYN(paraMap);
	}

	@Override
	public void insertProductList(Map<String, Object> paraMap) {
		sampleDAO.insertProductList(paraMap);	
	}

	@Override
	public void deletebasket(Map<String, Object> paraMap) {
		sampleDAO.deletebasket(paraMap);
	}

}
