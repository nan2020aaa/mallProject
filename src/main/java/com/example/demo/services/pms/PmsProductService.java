package com.example.demo.services.pms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.example.demo.models.pms.PmsProduct;
import com.example.demo.repositories.pms.PmsProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PmsProductService {
	@Autowired
	private PmsProductRepository repository;

	public boolean create(PmsProduct data) {
		repository.save(data);
		log.info("PmsProductService, create(), DBに保存完成：{}", data);
		return true;
	}

	public Long countAll() {
		log.info("countメソッドを呼び出した。");
		return repository.count();
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

	public Page<PmsProduct> findAll(Example<PmsProduct> example, Pageable paging) {
		log.info("findAllメソッドを呼び出した。");
		return repository.findAll(example, paging);
	}
	
	public Page<PmsProduct> findAll(Pageable paging) {
		log.info("findAllメソッドを呼び出した。");
		return repository.findAll(paging);
	}

	public void delete(List<Long> ids) {
		repository.deleteAllById(ids);
	}

	public void updatePublishStatus(List<Long> ids, Integer publishStatus) {
		// 按照ids从数据库里取出商品的list
		List<PmsProduct> pmsProducts = repository.findAllById(ids);
		log.info("按照ids从数据库里取出商品的list" + pmsProducts);
		// 更改取出来的商品状态
		pmsProducts.forEach((pmsProduct) -> {
			pmsProduct.setPublishStatus(publishStatus);
			repository.save(pmsProduct);
		});
	}

	public void updateNewStatus(List<Long> ids, Integer newStatus) {
		// 按照ids从数据库里取出商品的list
		List<PmsProduct> pmsProducts = repository.findAllById(ids);
		log.info("按照ids从数据库里取出商品的list" + pmsProducts);
		// 更改取出来的商品状态
		pmsProducts.forEach((pmsProduct) -> {
			pmsProduct.setNewStatus(newStatus);
			repository.save(pmsProduct);
		});
	}

	public void updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
		// 按照ids从数据库里取出商品的list
		List<PmsProduct> pmsProducts = repository.findAllById(ids);
		log.info("按照ids从数据库里取出商品的list" + pmsProducts);
		// 更改取出来的商品状态
		pmsProducts.forEach((pmsProduct) -> {
			pmsProduct.setRecommandStatus(recommendStatus);
			repository.save(pmsProduct);
		});
	}
}
