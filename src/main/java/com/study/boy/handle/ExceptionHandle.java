package com.study.boy.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.boy.domain.Result;
import com.study.boy.exception.BoyException;
import com.study.boy.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if(e instanceof BoyException) {
			BoyException boyException = (BoyException) e;
			return ResultUtil.error(boyException.getCode(), boyException.getMessage());
		} else {
			return ResultUtil.error("-1", e.getMessage());
		}
		
	}

}
