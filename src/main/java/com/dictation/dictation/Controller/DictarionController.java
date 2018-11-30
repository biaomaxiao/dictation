package com.dictation.dictation.Controller;
import com.dictation.dictation.domain.Dictation;
import com.dictation.dictation.service.impl.DictationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author wb
 * DictarionController
 */

public class DictarionController {
    @Autowired
    private DictationServiceImpl dictationServiceImpl;

    public String  addwords(Dictation dictation){
        dictationServiceImpl.insertWord(dictation);
        return "entry";
    };
}
