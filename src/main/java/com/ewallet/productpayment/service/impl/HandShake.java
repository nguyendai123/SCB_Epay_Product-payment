package com.ewallet.productpayment.service.impl;


import com.ewallet.productpayment.dto.EWalletHandShakeObject;
import com.ewallet.objects.ProcessObject;
import com.ewallet.objects.base.EWalletResponse;
import com.ewallet.service.FunctionBase;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.ewallet.objects.Constants.EWalletResponseCode.SUCCESS;
import static com.ewallet.util.SerializerUtil.deserialize;
import static com.ewallet.util.SerializerUtil.serialize;

@Service("eWalletHandShake")
@Slf4j
@RequiredArgsConstructor
public class HandShake extends FunctionBase {

    @Override
    @SneakyThrows
    public String execute(ProcessObject processObject) {
        EWalletResponse response = processObject.getResponseObject();
        var obj = deserialize(processObject.getRequestObject().getData(), EWalletHandShakeObject.class);
        obj.setDesKey("sfbn9823ufrwoiejfl2387rywikfrhdf9823425rrgdfG");
        obj.setPinPublicKeyExponent("njrkfi2yu0f9ip2oefjksdlfjsuidfy09fup2ji3flksdhf");
        obj.setPinPublicKeyModulus("8ryiwlfjhsk,ldjfslduifw0jflksdf");
        response.setRespCode(SUCCESS);

        response.setData(serialize(obj));
        return processObject.response(response);
    }
}
