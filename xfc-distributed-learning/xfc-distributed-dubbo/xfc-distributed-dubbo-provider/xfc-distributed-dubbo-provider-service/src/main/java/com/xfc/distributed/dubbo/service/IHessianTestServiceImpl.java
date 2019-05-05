package com.xfc.distributed.dubbo.service;

import com.xfc.distributed.dubbo.api.IDubboTestService;
import com.xfc.distributed.dubbo.api.IHessianTestService;
import com.xfc.distributed.dubbo.common.RequestDto;
import com.xfc.distributed.dubbo.common.ResponseDto;

/**
 * @author : chenxingfei
 * @date: 2019-05-04  21:13
 * @description:
 */
public class IHessianTestServiceImpl implements IHessianTestService {
    /**
     * dubbo测试
     *
     * @param requestDto
     * @return
     */
    @Override
    public ResponseDto helloDubboFromHessian(RequestDto requestDto) {
        System.out.println("请求参数 = " + requestDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErrorCode(0L);
        responseDto.setErrorMsg("hessian test ");
        return responseDto;
    }
}
