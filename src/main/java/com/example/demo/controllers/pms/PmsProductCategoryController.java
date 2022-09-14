package com.example.demo.controllers.pms;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.models.pms.PmsProductCategory;
import com.example.demo.models.pms.PmsProductCategoryWithChildrenItem;
import com.example.demo.models.request.PmsProductCategoryParam;
import com.example.demo.models.request.PmsProductParam;
import com.example.demo.models.response.CommonResult;
import com.example.demo.services.pms.PmsProductCategoryService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/productCategory") // 所有本类中方法的请求路径都以 /productCategory 开头
@Controller
@Slf4j
public class PmsProductCategoryController {

    @Autowired
	private PmsProductCategoryService productCategoryService;
    
    @ResponseBody // 返回值为 ResponseBody 的内容
	@PostMapping("/create")
	public CommonResult create(@RequestBody PmsProductCategory children) { // 传入参数为 RequestBody （在文档中标识为 body）
       
    	if (productCategoryService.create(children)) {
			
			return new CommonResult(200, null, "OK");
		} else {
			return new CommonResult(500, null, "System Error");
		}
	}
  
	
    @GetMapping("/list/withChildren")
	public CommonResult listwithChildren() {
    	//List<PmsProductCategoryWithChildrenItem>getList=new ArrayList<>();
    	List<PmsProductCategoryWithChildrenItem> getList=productCategoryService.findAll();
    	return new CommonResult(200,getList,"ok");
    	
    	
    	
    }
   
	
	
	
	
	

}
