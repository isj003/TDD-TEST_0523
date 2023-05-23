package org.koreait.models.board;


import org.koreait.controllers.BoardFrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void insert(BoardFrom boardFrom){
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql="INSERT INTO BOARD98 (ID,TITLE,CONTENT) VALUES (BOARD98_SEQ.nextval,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement psmt = con.prepareStatement(sql, new String[]{"id"});

            psmt.setString(1, boardFrom.getTitle());
            psmt.setString(2, boardFrom.getContent());


            return psmt;
        },keyHolder);
        Number key = keyHolder.getKey();
        boardFrom.setId(key.longValue());
    }

    public Board postLookup(Long id) { // 뷰로 연결해야됨
        String sql = "SELECT * FROM board98 WHERE id = ?";
       Board board = jdbcTemplate.queryForObject(sql,this::mapper,id);
        return board;
    }


    public List<Board> list() { // 최신순으로 리스트 글 목록 불러오기
        String sql = "SELECT * FROM BOARD98 ORDER BY REGDT DESC";
        List<Board> list = jdbcTemplate.query(sql,this::mapper);

        return list;
    }







    public Board mapper(ResultSet resultSet , int i) throws SQLException {
        Board board = new Board();
        board.setId(resultSet.getLong("id"));
        board.setTitle(resultSet.getString("title"));
        board.setContent(resultSet.getString("content"));
        board.setRegDt(resultSet.getTimestamp("regDt").toLocalDateTime());

        return board;
    }
}
