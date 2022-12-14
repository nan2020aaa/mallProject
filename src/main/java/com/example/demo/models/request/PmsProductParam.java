package com.example.demo.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PmsProductParam {
	// 画册图片，连产品图片限制为5张，以逗号分割
	private String albumPics;

	private Long brandId;

	// 品牌名称
	private String brandName;

	// 删除状态：0->未删除；1->已删除
	private Integer deleteStatus;

	// 产品描述
	private String description;

	// 产品详情网页内容
	private String detailDesc;

	private String detailHtml;

	// 移动端网页详情
	private String detailMobileHtml;

	// 赠送的成长值
	private String detailTitle;

	private Long feightTemplateId;

	private Integer giftGrowth;

	// 赠送的积分
	private Integer giftPoint;

	private String keywords;

	// 库存预警值
	private Integer lowStock;

	// 商品会员价格设置
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
//	private List<PmsMemberPrice> memberPriceList;

	// 新品状态：0->不是新品；1->新品
	private String name;

	private Integer newStatus;

	// 市场价
	private Double originalPrice;

	private String note;

//	 优选专区和商品的关系
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
//	private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;

	// 是否为预告商品：0->不是；1->是
	private Integer previewStatus;

	// 商品参数及自定义规格属性
	private Double price;

	private Long productAttributeCategoryId;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
//	private List<PmsProductAttributeValue> productAttrubuteValueList;

	// 商品分类名称
	private Long productCategoryId;

	private String productCategoryName;

	// 商品满减价格设置
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
//	private List<PmsProductFullReduction> productFullReductionList;

	// 商品阶梯价格设置
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
//	private List<PmsProductLadder> productLadderList;

	// 货号
	private String productSn;

	// 促销结束时间
	private String promotionEndTime;

	// 活动限购数量
	private Integer promotionPerLimit;

	// 促销价格
	private Double promotionPrice;

	// 促销开始时间
	private String promotionStartTime;

	// 促销类型：0->没有促销使用原价;1->使用促销价；2->使用会员价；3->使用阶梯价格；4->使用满减价格；5->限时购
	private Integer promotionType;

	// 上架状态：0->下架；1->上架
	private Integer publishStatus;

	// 推荐状态：0->不推荐；1->推荐
	private Integer recommandStatus;

	// 销量
	private Integer sale;

	// 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
	private String serviceIds;

	// 商品的sku库存信息
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
//	private List<PmsSkuStock> skuStockList;

	// 排序
	private Integer sort;

	// 库存
	private Integer stock;

	// 副标题
	private String subTitle;

	// 专题和商品关系
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productParam")
//	private List<CmsSubjectProductRelation> subjectProductRelationList;

	// 单位
	private String unit;

	// 限制使用的积分数
	private Integer usePointLimit;

	// 审核状态：0->未审核；1->审核通过
	private Integer verifyStatus;

	// 商品重量，默认为克
	private Double weight;
}
