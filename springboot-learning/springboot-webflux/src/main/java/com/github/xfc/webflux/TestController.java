package com.github.xfc.webflux;

import com.github.xfc.webflux.model.CaseInCollectionBatchModel;
import com.github.xfc.webflux.model.CaseInCollectionModel;
import com.github.xfc.webflux.producer.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : chenxingfei
 * @date: 2019-07-14  20:49
 * @description:
 */
@RestController
public class TestController {


    @Value("${user.id:123}")
    private String value;

    @Autowired
    private ProducerService producerService;

    @RequestMapping(value = "test")
    public String test() {

        producerService.testSend();

        return value;
    }

    /**
     * 数据构建
     *
     * @return
     */
    @RequestMapping(value = "dataBuild")
    @ResponseBody
    public CaseInCollectionBatchModel dataBuild(CaseInCollectionBatchModel caseInCollectionBatchModel) {
        System.out.println(caseInCollectionBatchModel);

        caseInCollectionBatchModel.setCallbackUrl("http:baidu.com");
        caseInCollectionBatchModel.setProduct("KG");
        caseInCollectionBatchModel.setSecret("qwertyuio");
        caseInCollectionBatchModel.setTimestamp(Instant.now().toEpochMilli());
        caseInCollectionBatchModel.setTotal(100);
        List<CaseInCollectionModel> list = new ArrayList<>(2);

        for (int i = 0; i < 500; i++) {

            CaseInCollectionModel caseInCollectionModel = new CaseInCollectionModel();
            caseInCollectionModel.setAccountType("ACCOUNT_TYPE" + i);
            caseInCollectionModel.setProduct("PRODUCT" + i);

            caseInCollectionModel.setAppId("appId1");
            caseInCollectionModel.setBusinessId("businessId" + i);
            caseInCollectionModel.setApprovedDate(new Date());
            caseInCollectionModel.setApprovedPeriod(i);
            caseInCollectionModel.setOrderNo("orderNo" + i);
            caseInCollectionModel.setApprovedPrincipal(BigDecimal.valueOf(100).add(BigDecimal.valueOf(i)));
            caseInCollectionModel.setCurrentTerm(i);
            caseInCollectionModel.setDueDate(new Date());
            list.add(caseInCollectionModel);
        }
        caseInCollectionBatchModel.setCollectionModels(list);
        return caseInCollectionBatchModel;
    }

    @RequestMapping("buildData")
    @ResponseBody
    public CaseInCollectionBatchModel buildData(@RequestBody CaseInCollectionBatchModel caseInCollectionBatchModel) {

        return caseInCollectionBatchModel;
    }

}
