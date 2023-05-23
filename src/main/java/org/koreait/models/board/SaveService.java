package org.koreait.models.board;


import org.koreait.controllers.BoardFrom;

import org.koreait.Validator.SaveValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveService {
    @Autowired
    SaveValidator validator;
    @Autowired
    BoardDao boardDao;

    public void save(BoardFrom boardFrom){
    validator.check(boardFrom);
    boardDao.insert(boardFrom);

    }

}
