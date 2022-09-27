package com.example.demo.repositories.oms;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.oms.OmsOrder;

@Repository
public interface OmsOrderRepository extends JpaRepository<OmsOrder,Long>{
	Page<OmsOrder>findByOrderSn(@Param(value = "orderSn")String orderSn,Pageable paging);
	
	Page<OmsOrder>findByReceiverName(@Param(value = "receiverKeyword")String receiverKeyword,Pageable paging);
	
	Page<OmsOrder>findByStatus(@Param(value = "status")Integer status,Pageable paging);
	
	Page<OmsOrder>findByOrderType(@Param(value = "orderType")Integer orderType,Pageable paging);
	
	Page<OmsOrder>findBySourceType(@Param(value = "sourceType")Integer sourceType,Pageable paging);
	
	Page<OmsOrder>findByCreateTime(@Param(value = "createTime")String createTime,Pageable paging);
	
//	OmsOrder findByOrderSn(String orderSn);
//
//	OmsOrder findByReceiverName(String receiverKeyword);
//
//	OmsOrder findByStatus(Integer status);
//
//	OmsOrder findByOrderType(Integer orderType);
//
//	OmsOrder findBySourceType(Integer sourceType);
//	
//	OmsOrder findByCreateTime(String createTime);
}
