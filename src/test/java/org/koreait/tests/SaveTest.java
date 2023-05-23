package org.koreait.tests;

import org.koreait.models.board.SaveService;
import org.koreait.controllers.BoardFrom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.koreait.Validator.SaveValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SaveTest {
    @Autowired
    private SaveService saveService;

    BoardFrom boardFrom;

    @Test
    @DisplayName("게시글 정상 등록되는지 확인 ( 오류 안뜸 )")
    void saveSuccess(){ // 게시글 정상 등록되는지 확인 ( 오류 안뜸 )
        BoardFrom boardFrom = getBoardFrom();
        saveService.save(boardFrom);
    }

    public BoardFrom getBoardFrom(){
        BoardFrom boardFrom = new BoardFrom();
        boardFrom.setTitle("제목");
       boardFrom.setContent("내용");


        return boardFrom;
    }

    @Test
    @DisplayName("제목")
    void NullCheck(){
        assertAll(
                ()->// 제목이 빈칸일 경우 오류 메세지 표시 되는지 확인
           assertThrows(SaveValidationException.class,()->{
               BoardFrom boardFrom = getBoardFrom();
               boardFrom.setTitle("  ");
               saveService.save(boardFrom);
               System.out.println(boardFrom);
           }),
                ()->// 제목이 null일 경우 오류 메세지 표시 되는지 확인
                        assertThrows(SaveValidationException.class,()->{
                            BoardFrom boardFrom = getBoardFrom();
                            boardFrom.setTitle(null);
                            saveService.save(boardFrom);
                        }),
                ()->// 내용이 빈칸일 경우 오류 메세지 표시 되는지 확인
                        assertThrows(SaveValidationException.class,()->{
                            BoardFrom boardFrom = getBoardFrom();
                            boardFrom.setTitle("  ");
                            saveService.save(boardFrom);
                        }),
                ()->// 내용이 null일 경우 오류 메세지 표시 되는지 확인
                        assertThrows(SaveValidationException.class,()->{
                            BoardFrom boardFrom = getBoardFrom();
                            boardFrom.setTitle(null);
                            saveService.save(boardFrom);
                        })

        );




    }
}
