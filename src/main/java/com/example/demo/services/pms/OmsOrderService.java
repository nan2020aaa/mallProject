package com.example.demo.services.pms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.oms.OmsOrder;
import com.example.demo.repositories.oms.OmsOrderRepository;
import com.example.demo.repositories.pms.PmsProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OmsOrderService {
	@Autowired
	private OmsOrderRepository repository;
	
	public Long countAll() {
		log.info("countメソッドを呼び出した。");
		return repository.count();
	}
	
	public Page<OmsOrder> findAll(Example<OmsOrder> example, Pageable paging) {
		log.info("findAllメソッドを呼び出した。");
		return repository.findAll(example, paging);
	}

	public Integer getTotalPageDependsOnContent(Integer pageSize) {
		if (countAll() % pageSize == 0) {
			log.info("getTotalPageメソッドを呼び出した、要求されたページは内容で満たされている。");
			return (int) (countAll() / pageSize);
		} else {
			log.info("getTotalPageメソッドを呼び出した、要求されたページは内容で満たされていない。");
			return (int) ((countAll() / pageSize) + 1);
		}
	}

	public boolean create(OmsOrder data) {
		repository.save(data);
		log.info("OmsOrderService, create(), DBに保存完成：{}", data);
		return true;
	}

}
