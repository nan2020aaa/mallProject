package com.example.demo.controllers.oms;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.oms.OmsOrder;
import com.example.demo.models.request.OmsOrderParam;
import com.example.demo.models.response.CommonPage;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.OmsOrderService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/order") // 所有本类中方法的请求路径都以 /product 开头
@Controller
@Slf4j
public class OmsOrderController {

	@Autowired
	private OmsOrderService orderService;

	@ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/create")
	public CommonResult create(@RequestBody OmsOrderParam param) {
		log.info("OmsOrderController, /create, パラメータを受け取った：{}", param);

		OmsOrder data = OmsOrder.builder().build();
		log.info("paramの内容は：" + param + ".");
		BeanUtils.copyProperties(param, data);
		log.info("dataの内容は：" + data + ".");
		log.info("BeanCopy完成：{}", data);

		if (orderService.create(data)) {
			log.info("DBに保存完成：{}", data);
			return CommonResult.builder().code(200).data(null).message("OK").build();
		} else {
			return CommonResult.builder().code(500).data(null).message("System error").build();
		}
	}

	@ResponseBody // 返回值为 ResponseBody 的内容
	@GetMapping("/list")

	public CommonResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
			@RequestParam(required = false) String orderSn, @RequestParam(required = false) String receiverKeyword,
			@RequestParam(required = false) Integer status, @RequestParam(required = false) Integer orderType,
			@RequestParam(required = false) Integer sourceType, @RequestParam(required = false) String createTime) {

		Pageable paging = PageRequest.of(pageNum - 1, pageSize);
		log.info("pagingというインスタンス作成、pageNum: " + pageNum + "; pageSize: " + pageSize + ".");

		OmsOrder order = new OmsOrder();
		order.setOrderSn(orderSn);
		order.setReceiverName(receiverKeyword);
		order.setStatus(status);
		order.setOrderType(orderType);
		order.setSourceType(sourceType);
		order.setCreateTime(createTime);

		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("orderSn",
				match -> match.ignoreCase().contains());

		Example<OmsOrder> example = Example.of(order, matcher);

		Page<OmsOrder> orders = orderService.findAll(example, paging);
		orders.forEach(System.out::println);
		log.info("ページの導入完成、内容は: " + orders.toList().toString() + ".");
		
		CommonPage commonPage = CommonPage.builder().list(orders.toList()).pageNum(pageNum).pageSize(pageSize)
				.total(orders.getTotalElements())
				.totalPage(orderService.getTotalPageDependsOnContent(pageSize)).build();

		return CommonResult.builder().code(200).data(commonPage).message("OK").build();
	}
}
