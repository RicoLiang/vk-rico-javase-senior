package com.vk.rico.javase.senior.guava.multimap.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UebOrderOwnerVO extends BaseOrderVO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 内存使用
	 */
	
	
	/**
	 * 对应PO
	 */
    private Integer id;
    private Integer orderId;
    private String orderNo;
    private String platformCode;
    private String platformOrderNo;
    private String site;
    private Integer accountId;
    private String itemId;
    private String oriSku;
    private String oriSkuOnline;
    private Integer developerId;
    private Integer documentaryId;
    private Integer sellerId;
    private String creater;
    private Date createtime;
    private String updater;
    private Date updatetime;
    
    private BigDecimal buyerCoupon;//主表的买家优惠
    private BigDecimal shipFee;//运费
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
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode == null ? null : platformCode.trim();
    }

    public String getPlatformOrderNo() {
        return platformOrderNo;
    }

    public void setPlatformOrderNo(String platformOrderNo) {
        this.platformOrderNo = platformOrderNo == null ? null : platformOrderNo.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getOriSku() {
        return oriSku;
    }

    public void setOriSku(String oriSku) {
        this.oriSku = oriSku == null ? null : oriSku.trim();
    }

    public String getOriSkuOnline() {
        return oriSkuOnline;
    }

    public void setOriSkuOnline(String oriSkuOnline) {
        this.oriSkuOnline = oriSkuOnline == null ? null : oriSkuOnline.trim();
    }

    public Integer getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public Integer getDocumentaryId() {
        return documentaryId;
    }

    public void setDocumentaryId(Integer documentaryId) {
        this.documentaryId = documentaryId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

	public BigDecimal getBuyerCoupon() {
		return buyerCoupon;
	}

	public void setBuyerCoupon(BigDecimal buyerCoupon) {
		this.buyerCoupon = buyerCoupon;
	}

	public BigDecimal getShipFee() {
		return shipFee;
	}

	public void setShipFee(BigDecimal shipFee) {
		this.shipFee = shipFee;
	}
    
    
}