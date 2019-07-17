package com.github.xfc.webflux.model;

import com.mintq.collection.enums.OrderStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author chenxingfei
 * @Description 入催模型对象（之后需要将菲律宾入催也改为此对象数据，统一入催）</br>
 * @Date 2018/8/20 10:53
 * @see com.mintq.collection.models.CaseInCollection
 **/
public class CaseInCollectionModel implements Serializable {

    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 还款计划id
     */
    private Long scheduleId;

    /**
     * 当前期数
     */
    private Integer currentTerm;

    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 客户身份证号
     */
    private String customerIdCardNo;
    /**
     * 客户手机号
     */
    private String customerCellPhone;
    /**
     * 账户类型
     */
    private String accountType;
    /**
     * 订单状态
     */
    private OrderStatus orderStatus;
    /**
     * 城市
     */
    private String city;
    /**
     * 产品
     */
    private String product;
    /**
     * app标识
     */
    private String appId;
    /**
     * 业务id
     */
    private String businessId;
    /**
     * 渠道
     */
    private String channel;
    /**
     * 合同金额
     */
    private BigDecimal approvedPrincipal;
    /**
     * 放款金额
     */
    private BigDecimal approvedAmount;
    /**
     * 应还总金额
     */
    private BigDecimal totalAmount;
    /**
     * 放款期限（分期存期数，xqd存贷款天数）
     */
    private Integer approvedPeriod;
    /**
     * 放款日期
     */
    private Date approvedDate;
    /**
     * 还款日（分期存逾期最早一期还款日）
     */
    private Date dueDate;
    /**
     * 逾期日期
     */
    private Date lateDate;
    /**
     * 逾期天数（分期存逾期最早一期逾期天数）
     */
    private Integer lateDay;
    /**
     * 历史贷款次数
     */
    private Integer orderNum;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(Integer currentTerm) {
        this.currentTerm = currentTerm;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIdCardNo() {
        return customerIdCardNo;
    }

    public void setCustomerIdCardNo(String customerIdCardNo) {
        this.customerIdCardNo = customerIdCardNo;
    }

    public String getCustomerCellPhone() {
        return customerCellPhone;
    }

    public void setCustomerCellPhone(String customerCellPhone) {
        this.customerCellPhone = customerCellPhone;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public BigDecimal getApprovedPrincipal() {
        return approvedPrincipal;
    }

    public void setApprovedPrincipal(BigDecimal approvedPrincipal) {
        this.approvedPrincipal = approvedPrincipal;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getApprovedPeriod() {
        return approvedPeriod;
    }

    public void setApprovedPeriod(Integer approvedPeriod) {
        this.approvedPeriod = approvedPeriod;
    }


    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getLateDate() {
        return lateDate;
    }

    public void setLateDate(Date lateDate) {
        this.lateDate = lateDate;
    }

    public Integer getLateDay() {
        return lateDay;
    }

    public void setLateDay(Integer lateDay) {
        this.lateDay = lateDay;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "CaseInCollectionModel{" +
                "orderNo='" + orderNo + '\'' +
                ", orderId=" + orderId +
                ", scheduleId=" + scheduleId +
                ", currentTerm=" + currentTerm +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerIdCardNo='" + customerIdCardNo + '\'' +
                ", customerCellPhone='" + customerCellPhone + '\'' +
                ", accountType=" + accountType +
                ", orderStatus=" + orderStatus +
                ", city='" + city + '\'' +
                ", product=" + product +
                ", appId='" + appId + '\'' +
                ", businessId='" + businessId + '\'' +
                ", channel='" + channel + '\'' +
                ", approvedPrincipal=" + approvedPrincipal +
                ", approvedAmount=" + approvedAmount +
                ", totalAmount=" + totalAmount +
                ", approvedPeriod=" + approvedPeriod +
                ", approveDate=" + approvedDate +
                ", dueDate=" + dueDate +
                ", lateDate=" + lateDate +
                ", lateDay=" + lateDay +
                ", orderNum=" + orderNum +
                '}';
    }
}
