package com.vk.rico.javase.senior.guava.multimap.vo;

import java.io.Serializable;

public class UebOrderDetailVO extends BaseOrderVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private Integer id;

	/**
	 * 主表id，外键
	 */
	private Integer orderId;

	/**
	 * 订单编号，外键
	 */
	private String orderNo; // 订单号

	/**
	 * 平台code
	 */
	private String platformCode;

	/**
	 * 交易号，即平台订单号
	 */
	private String transactionNo;

	/**
	 * 站点，如tw、my、sg等
	 */
	private String site;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	// // ======== 对应oms 的 ueb_order_detail表
	//
	// // 买家优惠券(平摊后)
	// private BigDecimal platformCoupon;
	// // 交易手续费(平摊后)
	// private BigDecimal transactionFee;
	// // 平台佣金(平摊后)/成交费
	// private BigDecimal commissionFee;
	// // sku平摊后的运费，未扣除成交费
	// private BigDecimal shipFee;
	// // 单价(含成交费)
	// private BigDecimal salePrice;
	// // 产品总金额+平摊后的运费
	// private BigDecimal totalPrice;
	//
	// // ======== 对应oms 的 ueb_order_detail_extend表
	//
	// // 明细sku总销售价格
	// private BigDecimal itemSalePrice;
	// // 明细sku平摊后总售价
	// private BigDecimal itemSalePriceAllot;
	// // 平摊后的单价
	// private BigDecimal unitSalePriceAllot;
	// // 平台优惠金额
	// private BigDecimal buyerCoupon;
	// // 税费
	// private BigDecimal taxFee;
	// // 保险费
	// private BigDecimal insuranceFee;
	// // 平摊后手续费
	// private BigDecimal feeAmtAllot;
	// // '原始仓库id'
	// private Integer originalWarehouseId;
}