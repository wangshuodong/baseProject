package com.wangsd.common.shiro;

import com.wangsd.common.utils.DigestUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * shiro密码加密配置
 * InitializingBean接口为bean提供了初始化方法的方式，它只包括afterPropertiesSet方法，凡是继承该接口的类，在初始化bean的时候会执行该方法。
 *
 */
public class PasswordHash implements InitializingBean {
	//算法
	private String algorithmName;
	//hash次数
	private int hashIterations;

	public String getAlgorithmName() {
		return algorithmName;
	}
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	public int getHashIterations() {
		return hashIterations;
	}
	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		//当algorithmName为 null 或长度为 0 时抛出异常；
		Assert.hasLength(algorithmName, "algorithmName必须传入算法：MD5、SHA-1、SHA-256、SHA-384、SHA-512");
	}

	/**
	 * 密码加密
	 * @param source 需要加密的原值
	 * @param salt 加密盐
	 * @return
	 */
	public String toHex(Object source, Object salt) {
		return DigestUtils.hashByShiro(algorithmName, source, salt, hashIterations);
	}
}
