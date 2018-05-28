package com.study.boy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.study.boy.domain.Boy;
import com.study.boy.exception.BoyException;
import com.study.boy.repository.IBoyRepository;

import enums.ResultEnums;

@Service
public class BoyService {
	@Autowired
	private IBoyRepository boyRepository;
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<Boy> findAll() {
		return boyRepository.findAll();
	}
	
	/**
	 * 按id查询数据
	 * @param id 
	 * @return
	 */
	public Boy findOne(Integer id) {		
		return boyRepository.findOne(id);
	}
	
	/**
	 * 添加一条数据
	 * @param boy
	 * @return
	 */
	public Boy addOne(Boy boy) throws Exception {
		if(boy.getAge() < 16) {
			throw new BoyException(ResultEnums.YOUNG_ERROR);
		}
		return boyRepository.save(boy);
	}
	
	/**
	 * 修改一条数据
	 * 如果要id不存在则抛出异常
	 * @param boy
	 * @return
	 * @throws Exception
	 */
	public Boy updOne(Boy boy) throws Exception {
		Integer id = boy.getId();
		if(boyRepository.findOne(id) != null) {
			if(boy.getAge() < 16) {
				throw new BoyException(ResultEnums.YOUNG_ERROR);
			}
			return boyRepository.save(boy);
		} else {
			throw new BoyException(ResultEnums.NO_DATA);
		}
	}
	
	public void delOne(Integer id) throws Exception {
		if(boyRepository.findOne(id) != null) {
			boyRepository.delete(id);
		} else {
			throw new BoyException(ResultEnums.NO_DATA);
		}
	}

}
