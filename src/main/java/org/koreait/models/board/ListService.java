package org.koreait.models.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    @Autowired
    private BoardDao boardDao;

    public List<Board> list(){

        return boardDao.list();
    }
}
