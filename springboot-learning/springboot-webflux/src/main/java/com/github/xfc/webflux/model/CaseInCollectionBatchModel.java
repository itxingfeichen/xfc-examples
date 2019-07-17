package com.github.xfc.webflux.model;

import java.util.List;

/**
 * @Author chenxingfei
 * @Description 案件批量入催
 * @Date 2018/12/4 16:10
 **/
public class CaseInCollectionBatchModel {

    /**
     * 入催总条数
     */
    private Integer total;

    /**
     * 产品
     */
    private String product;

    /**
     * 秘钥
     */
    private String secret;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 回调url
     */
    private String callbackUrl;

    /**
     * 入催列表
     */
    private List<CaseInCollectionModel> collectionModels;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public List<CaseInCollectionModel> getCollectionModels() {
        return collectionModels;
    }

    public void setCollectionModels(List<CaseInCollectionModel> collectionModels) {
        this.collectionModels = collectionModels;
    }

    @Override
    public String toString() {
        return "CaseInCollectionBatchModel{" +
                "total=" + total +
                ", product='" + product + '\'' +
                ", secret='" + secret + '\'' +
                ", timestamp=" + timestamp +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", collectionModels=" + collectionModels +
                '}';
    }
}
