package com.study.boy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.boy.domain.Boy;
import com.study.boy.domain.Result;
import com.study.boy.exception.BoyException;
import com.study.boy.service.BoyService;
import com.study.boy.utils.ResultUtil;

@RestController
public class BoyController {
	
	@Autowired
	private BoyService boyService;
	
	/**
	 * 查询所有数据
	 * @return
	 */
	@GetMapping(value="/boys")
	public Result findAll() {
		List<Boy> boys = boyService.findAll();
		return ResultUtil.success(boys);
	}
	
	/**
	 * 按id查询数据
	 * @param id
	 * @return
	 */
	@GetMapping(value="/boy/{id}")
	public Result findOne(@PathVariable("id") Integer id) {
		Boy boy = boyService.findOne(id);
		return ResultUtil.success(boy);
	}
	
	/**
	 * 添加一条数据
	 * 如果表单验证失败抛出异常
	 * @param boy
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value="/boyadd")
	public Result addOne(@Valid Boy boy, BindingResult bindingResult) throws Exception{
		if(bindingResult.hasErrors()) {
			throw new BoyException("100", bindingResult.getFieldError().getDefaultMessage());
		}
		Boy boy1 = boyService.addOne(boy);
		return ResultUtil.success(boy1);
	}
	
	/**
	 * 修改一条数据
	 * 如果表单验证失败抛出异常
	 * @param boy
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value="/boyupd")
	public Result updOne(@Valid Boy boy, BindingResult bindingResult) throws Exception{
		if(bindingResult.hasErrors()) {
			throw new BoyException("100", bindingResult.getFieldError().getDefaultMessage());
		}
		Boy boy1 = boyService.updOne(boy);
		return ResultUtil.success(boy1);
	}
	
	/**
	 * 删除一条数据
	 * @param id
	 */
	@DeleteMapping(value="/boydel/{id}")
	public Result delOne(@PathVariable("id") Integer id) throws Exception{
		boyService.delOne(id);
		return ResultUtil.success();
	}
	
}
