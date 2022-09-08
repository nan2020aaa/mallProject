package com.example.demo.models.request;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.models.cms.CmsPrefrenceAreaProductRelation;
import com.example.demo.models.cms.CmsSubjectProductRelation;
import com.example.demo.models.pms.PmsMemberPrice;
import com.example.demo.models.pms.PmsProductAttributeValue;
import com.example.demo.models.pms.PmsProductFullReduction;
import com.example.demo.models.pms.PmsProductLadder;
import com.example.demo.models.pms.PmsSkuStock;

import lombok.Data;

@Entity
@Data
public class PmsProductParam {
	// 画册图片，连产品图片限制为5张，以逗号分割
	@Column
	private String albumPics;
	
	@Column
	private Long brandId;
	
	// 品牌名称
	@Column
	private String brandName;

	// 删除状态：0->未删除；1->已删除
	@Column
	private Integer deleteStatus;

	// 产品描述
	@Column
	private String description;

	// 产品详情网页内容
	@Column
	private String detailDesc;
	
	@Column
	private String detailHtml;

	// 移动端网页详情
	@Column
	private String detailMobileHtml;

	// 赠送的成长值
	@Column
	private String detailTitle;
	
	@Column
	private Long feightTemplateId;
	
	@Column
	private Integer giftGrowth;

	// 赠送的积分
	@Column
	private Integer giftPoint;

	// 库存预警值
	@Id
	private Long id;
	
	@Column
	private String keywords;
	
	@Column
	private Integer lowStock;

	// 商品会员价格设置
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
	private List<PmsMemberPrice> memberPriceList;

	@Column
	private String name;

	// 新品状态：0->不是新品；1->新品
	@Column
	private String mame;
	
	@Column
	private Integer newStatus;

	//市场价
	@Column
	private Double originalPrice;
	
	@Column
	private String note;

	// 优选专区和商品的关系
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
	private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;

	// 是否为预告商品：0->不是；1->是
	@Column
	private Integer previewStatus;
	
	// 商品参数及自定义规格属性
	@Column
	private Double price;
	
	@Column
	private Long productAttributeCategoryId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
	private List<PmsProductAttributeValue> productAttrubuteValueList;

	// 商品分类名称
	@Column
	private Long productCategoryId;
	
	@Column
	private String productCategoryName;

	// 商品满减价格设置
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
	private List<PmsProductFullReduction> productFullReductionList;

	// 商品阶梯价格设置
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
	private List<PmsProductLadder> productLadderList;

	// 货号
	@Column
	private String productSn;

	// 促销结束时间
	@Column
	private String promotionEndTime;

	// 活动限购数量
	@Column
	private Integer promotionPerLimit;

	//促销价格
	@Column
	private Double promotionPrice;
	
	//促销开始时间
	@Column
	private String promotionStartTime;

	// 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
	@Column
	private Integer promotionType;

	// 上架状态：0->下架；1->上架
	@Column
	private Integer publishStatus;

	// 推荐状态：0->不推荐；1->推荐
	@Column
	private Integer recommandStatus;

	// 销量
	@Column
	private Integer sale;

	// 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
	@Column
	private String serviceIds;

	// 商品的sku库存信息
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
	private List<PmsSkuStock> skuStockList;

	// 排序
	@Column
	private Integer sort;

	// 库存
	@Column
	private Integer stock;

	// 副标题
	@Column
	private String subTitle;

	// 专题和商品关系
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
	private List<CmsSubjectProductRelation> subjectProductRelationList;

	// 单位
	@Column
	private String unit;

	// 限制使用的积分数
	@Column
	private Integer usePointLimit;

	// 审核状态：0->未审核；1->审核通过
	@Column
	private Integer veryfyStatus;
	
	//商品重量，默认为克
	@Column
	private Double weight;
}
