package org.koreait.Validator;


import org.koreait.controllers.BoardFrom;
import org.springframework.stereotype.Component;

@Component
public class SaveValidator {



    public void check(BoardFrom boardFrom) {
         String title = boardFrom.getTitle();
         String content = boardFrom.getContent();


         if(title==null || title.isBlank()){
             throw new org.koreait.Validator.SaveValidationException("제목 입력해주세요");
         }
         if(content==null || content.isBlank()){
             throw new org.koreait.Validator.SaveValidationException("내용을 입력해주세요");
         }
    }
}
