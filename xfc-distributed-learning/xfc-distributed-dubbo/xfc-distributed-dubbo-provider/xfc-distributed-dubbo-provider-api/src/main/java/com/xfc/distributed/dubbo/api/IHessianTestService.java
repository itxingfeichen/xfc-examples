package com.xfc.distributed.dubbo.api;

import com.xfc.distributed.dubbo.common.RequestDto;
import com.xfc.distributed.dubbo.common.ResponseDto;

/**
 * @author : chenxingfei
 * @date: 2019-05-04  21:07
 * @description: dubbo测试
 */
public interface IHessianTestService {
    /**
     * dubbo测试
     * @param requestDto
     * @return
     */
    ResponseDto helloDubboFromHessian(RequestDto requestDto);
}
