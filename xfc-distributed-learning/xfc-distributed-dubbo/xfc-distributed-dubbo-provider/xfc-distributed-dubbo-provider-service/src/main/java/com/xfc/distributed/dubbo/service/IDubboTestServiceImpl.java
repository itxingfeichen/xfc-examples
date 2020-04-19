package com.xfc.distributed.dubbo.service;

import com.xfc.distributed.dubbo.api.IDubboTestService;
import com.xfc.distributed.dubbo.common.RequestDto;
import com.xfc.distributed.dubbo.common.ResponseDto;

/**
 * @author : chenxingfei
 * @date: 2019-05-04  21:13
 * @description:
 */
public class IDubboTestServiceImpl implements IDubboTestService {
    /**
     * dubbo测试
     *
     * @param requestDto
     * @return
     */
    @Override
    public ResponseDto helloDubbo(RequestDto requestDto) {

        System.out.println("请求参数 = " + requestDto);
        int i = 1/0;
        ResponseDto responseDto = new ResponseDto();
        responseDto.setErrorCode(0L);
        responseDto.setErrorMsg("no error ");
        return responseDto;
    }
}
