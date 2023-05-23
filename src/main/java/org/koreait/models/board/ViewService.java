package org.koreait.models.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewService {

    @Autowired
    private BoardDao boardDao;

    public Board view(Long id) {



        return boardDao.postLookup(id);


    }
}
