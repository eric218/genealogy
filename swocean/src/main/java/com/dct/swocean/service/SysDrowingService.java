package com.dct.swocean.service;

import java.util.List;

import com.dct.swocean.entity.SysDrowingInfo;

public interface SysDrowingService {

	void insert(SysDrowingInfo sysDrowingInfo);

	List<SysDrowingInfo> select(String areaCode, Integer pageNo, Integer pageSize);
}
