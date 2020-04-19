package com.xfc.distributed.dubbo.aop;

import com.xfc.distributed.dubbo.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.service.GenericService;

@Slf4j
@Activate(group = Constants.PROVIDER)
public class ExceptionFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) {
        Result result = null;
        try {
            result = invoker.invoke(invocation);
            if (result.hasException() && GenericService.class != invoker.getInterface()) {
                Throwable exception = result.getException();
                ResponseDto resultVo = new ResponseDto();
                resultVo.setErrorCode(00L);
                resultVo.setErrorMsg(exception.getMessage());
                //出现异常，打印日志后返回错误码
                return new RpcResult(resultVo);
            }
        } catch (RuntimeException e) {
            log.error("error", e);
        }
        return result;
    }
}