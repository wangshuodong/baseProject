package com.wangsd.common.scan;

import com.wangsd.common.entity.JSONResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * 捕获异常统一处理
 * @description TODO
 * @author chen.gs
 * @create date 2016年4月28日
 * @modified by
 * @modify date
 * @version v1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

    private final static String EXPTION_MSG_KEY = "message";

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public JSONResult handleBizExp(HttpServletRequest request, Exception ex){
        LOGGER.info("Business exception handler  " + ex.getMessage() );
        request.getSession(true).setAttribute(EXPTION_MSG_KEY, ex.getMessage());
        JSONResult jsonResult = new JSONResult();
        jsonResult.setMessage(ex.getMessage());
        jsonResult.setSuccess(false);
        return jsonResult;
    }

    @ExceptionHandler(SQLException.class)
    public ModelAndView handSql(Exception ex){
        LOGGER.info("SQL Exception " + ex.getMessage());
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", ex.getMessage());
        mv.setViewName("sql_error");
        return mv;
    }

}
