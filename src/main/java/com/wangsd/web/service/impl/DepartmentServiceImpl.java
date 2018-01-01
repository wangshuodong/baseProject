package com.wangsd.web.service.impl;

import com.wangsd.web.model.Department;
import com.wangsd.web.mapper.DepartmentMapper;
import com.wangsd.web.service.IDepartmentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangsd
 * @since 2018-01-01
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
