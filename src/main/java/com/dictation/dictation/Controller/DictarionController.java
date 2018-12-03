package com.dictation.dictation.Controller;
import com.dictation.dictation.domain.Dictation;
import com.dictation.dictation.service.impl.DictationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author wb
 * DictarionController
 */
@Controller
public class DictarionController {

    @Autowired
    private DictationServiceImpl dictationServiceImpl;

    //查询所有
    @RequestMapping("/")
    public ModelAndView show(){
        List<Dictation> dictationList= dictationServiceImpl.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("list",dictationList);
        mv.setViewName("entry");
        return mv;
    }

    //添加单词
    @RequestMapping("/addWords")
    @ResponseBody
    public String  addWords(Dictation dictation){
        try {
            dictationServiceImpl.insertWord(dictation);
            return "true";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }

    //删除
    @RequestMapping("/delWords")
    @ResponseBody
    public String delWords(Integer id){
        try {
            dictationServiceImpl.deleteWord(id);
            return "true";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }

/*    //修改
    @RequestMapping("/updateWords")
    public @ResponseBody String updateWrods(Dictation dictation){
        try {

            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "failure";
        }
    }*/
}
