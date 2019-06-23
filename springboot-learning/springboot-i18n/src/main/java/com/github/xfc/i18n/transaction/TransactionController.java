package com.github.xfc.i18n.transaction;

import com.github.xfc.i18n.model.I18N;
import com.github.xfc.i18n.service.I18NService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private I18NService i18NService;

    @RequestMapping("trans")
    public ResponseEntity<I18N> trans(){
        I18N i18N = i18NService.getById(1L);
        System.out.println("i18N.toString() = " + i18N.toString());
        i18NService.updateByIdForTrans(i18N);

        return ResponseEntity.ok(i18N);
    }
}

