package com.shincom.graduation_project_backend_server.persistence;

import com.shincom.graduation_project_backend_server.domain.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
@Mapper
public interface ApiMapper {

    @Insert({"<script>",
            "INSERT INTO t_feed(feed_contents, feed_like, feed_unlike, feed_created, edit, file )",
            "VALUES(#{feed_contents}, #{feed_like},#{feed_unlike}, now(), #{edit}, ${saveFile})",
            "</script>"})
    int insertFeed(FeedVO feed);



    @Select({"<script>",
            "SELECT * from t_feed",
            "order by feed_no desc",
            "</script>"})
    List<FeedVO> findFeed();

    @Select({"<script>",
            "SELECT * from t_feed",
            "where feed_no = #{feed_no}",
            "</script>"})
     FeedVO findOneFeed(int feed_no);

    @Update({"<script>",
            "UPDATE t_feed",
            "<trim prefix='set' suffixOverrides=','>",
            "<if test='feed_contents!=null'>feed_contents=#{feed_contents},</if>",
            "<if test='feed_like!=null'>feed_like=#{feed_like},</if>",
            "<if test='feed_unlike!=null'>feed_unlike=#{feed_unlike},</if>",
            "<if test='edit!=null'>edit=#{edit},</if>",
            "</trim>",
            "WHERE feed_no = #{feed_no}",
            "</script>"})
    int updateFeed(FeedVO feed);

    @Delete({"<script>",
            "DELETE FROM t_feed",
            "WHERE feed_no = #{feed_no}",
            "</script>"})
    int deleteFeed(int feed_no);

//댓글----------------------------------------------------------------------------------------

    @Insert({"<script>",
            "INSERT INTO t_feed_re(feed_re_no, comment, feed_no, created, edit, parents_id, reply )",
            "VALUES(#{feed_re_no}, #{comment},#{feed_no}, now(),#{edit},#{parents_id} #{reply} )",
            "</script>"})
    int insertFeedRe(FeedReVO feedre);



    @Select({"<script>",
            "SELECT * from t_feed_re",
            "order by feed_re_no desc",
            "</script>"})
    List<FeedReVO> findFeedRe();


    @Select({"<script>",
            "SELECT * from t_feed_re",
            "where feed_re_no = #{feed_re_no}",
            "</script>"})
    FeedReVO findOneFeedRe(int feed_re_no);

    @Select({"<script>",
            "SELECT *",
            "FROM t_feed_re as a left join t_feed_re as b",
            "ON a.feed_re_no = b.parents_id",
            "ORDER BY a.feed_re_no desc",
            "</script>"})
    List<FeedReVO> findReplyFeedRe();



    @Update({"<script>",
            "UPDATE t_feed_re",
            "<trim prefix='set' suffixOverrides=','>",
            "<if test='comment!=null'>comment=#{comment},</if>",
            "<if test='edit!=null'>edit=#{edit},</if>",
            "<if test='reply!=null'>reply=#{reply},</if>",
            "</trim>",
            "WHERE feed_re_no = #{feed_re_no}",
            "</script>"})
    int updateFeedRe(FeedReVO feedre);

    @Delete({"<script>",
            "DELETE FROM t_feed_re",
            "WHERE feed_re_no = #{feed_re_no}",
            "</script>"})
    int deleteFeedRe(int feed_re_no);

    //좋아요 --------------------------------------------------------------------------

    @Insert({"<script>",
            "INSERT INTO t_like(like, unlike, feed_no, user_id)",
            "VALUES(#{like}, #{unlike},#{feed_no}, #{user_id} )",
            "</script>"})
    int insertFeedLike(LikeVO like);



//게시판=======================================================================
    @Insert({"<script>",
            "INSERT INTO board(title, contents, writer, created, menu)",
            "VALUES(#{title}, #{contents},#{writer}, now(), #{menu})",
            "</script>"})
    int insertBoard(BoardVO board);



    @Select({"<script>",
            "SELECT * from board",
            "order by board_no desc",
            "</script>"})
    List<BoardVO> findBoard();

    @Select({"<script>",
            "SELECT * from board",
            "where board_no = #{board_no}",
            "</script>"})
    BoardVO findOneBoard(int board_no);

    @Update({"<script>",
            "UPDATE board",
            "<trim prefix='set' suffixOverrides=','>",
            "<if test='title!=null'>title=#{title},</if>",
            "<if test='contents!=null'>contents=#{contents},</if>",
            "<if test='writer!=null'>writer=#{writer},</if>",
            "<if test='menu!=null'>menu=#{menu},</if>",
            "</trim>",
            "WHERE board_no = #{board_no}",
            "</script>"})
    int updateBoard(BoardVO board);

    @Delete({"<script>",
            "DELETE FROM board",
            "WHERE board_no = #{board_no}",
            "</script>"})
    int deleteBoard(int board_no);

    //게시판 댓글==========================================================
    @Insert({"<script>",
            "INSERT INTO board_comment(parent, contents, writer, created, board_no, edit)",
            "VALUES(#{parent}, #{contents},#{writer}, now(), #{board_no}, #{edit})",
            "</script>"})
    int insertBoardRe(Board_commentVO boardre);



    @Select({"<script>",
            "SELECT * from board_comment",
            "order by comment_no desc",
            "</script>"})
    List<Board_commentVO> findBoardRe();

    @Select({"<script>",
            "SELECT * from board_comment",
            "where comment_no = #{comment_no}",
            "</script>"})
    Board_commentVO findOneBoardRe(int comment_no);

    @Update({"<script>",
            "UPDATE board_comment",
            "<trim prefix='set' suffixOverrides=','>",
            "<if test='parent!=null'>parent=#{parent},</if>",
            "<if test='contents!=null'>contents=#{contents},</if>",
            "<if test='writer!=null'>writer=#{writer},</if>",
            "<if test='board_no!=null'>board_no=#{board_no},</if>",
            "<if test='edit!=null'>edit=#{edit},</if>",
            "</trim>",
            "WHERE comment_no = #{comment_no}",
            "</script>"})
    int updateBoardRe(Board_commentVO boardre);

    @Delete({"<script>",
            "DELETE FROM board_comment",
            "WHERE comment_no = #{comment_no}",
            "</script>"})
    int deleteBoardRe(int comment_no);

    //프로젝트====================================================================
    @Insert({"<script>",
            "INSERT INTO project(project_no, title, description, master, created, edit, member, sday, eday)",
            "VALUES(#{project_no}, #{title},#{description}, #{master}, now(), #{edit},#{member}, #{sday}, #{eday})",
            "</script>"})
    int insertProject(ProjectVO project);



    @Select({"<script>",
            "SELECT * from project",
            "order by project_no desc",
            "</script>"})
    List<ProjectVO> findProject();

    @Select({"<script>",
            "SELECT * from project",
            "where project_no = #{project_no}",
            "</script>"})
    ProjectVO findOneProject(int project_no);

    @Update({"<script>",
            "UPDATE project",
            "<trim prefix='set' suffixOverrides=','>",
            "<if test='title!=null'>title=#{title},</if>",
            "<if test='description!=null'>description=#{description},</if>",
            "<if test='master!=null'>master=#{master},</if>",
            "<if test='edit!=null'>edit=#{edit},</if>",
            "<if test='member!=null'>member=#{member},</if>",
            "<if test='sday!=null'>sday=#{sday},</if>",
            "<if test='eday!=null'>eday=#{eday},</if>",
            "</trim>",
            "WHERE project_no = #{project_no}",
            "</script>"})
    int updateProject(ProjectVO project);

    @Delete({"<script>",
            "DELETE FROM project",
            "WHERE project_no = #{project_no}",
            "</script>"})
    int deleteProject(int project_no);

    //메뉴=======================================================================
    @Insert({"<script>",
            "INSERT INTO menu(title, description, created )",
            "VALUES(#{title}, #{description}, now())",
            "</script>"})
    int insertMenu(MenuVO menu);



    @Select({"<script>",
            "SELECT * from menu",
            "order by menu_no desc",
            "</script>"})
    List<MenuVO> findMenu();

    @Select({"<script>",
            "SELECT * from menu",
            "where menu_no = #{menu_no}",
            "</script>"})
    MenuVO findOneMenu(int menu_no);

    @Update({"<script>",
            "UPDATE menu",
            "<trim prefix='set' suffixOverrides=','>",
            "<if test='title!=null'>title=#{title},</if>",
            "<if test='description!=null'>description=#{description},</if>",
            "</trim>",
            "WHERE menu_no = #{menu_no}",
            "</script>"})
    int updateMenu(MenuVO menu);

    @Delete({"<script>",
            "DELETE FROM menu",
            "WHERE menu_no = #{menu_no}",
            "</script>"})
    int deleteMenu(int menu_no);

    //-===========================================================
    @Insert({"<script>",
            "INSERT INTO user(id, password, name, user_no)",
            "VALUES(#{id}, #{password},#{name}, #{user_no})",
            "</script>"})
    int insertUser(UserVO user);


    @Select({"<script>",
            "SELECT * from user",
            "order by id desc",
            "</script>"})
    List<UserVO> findUser();

    @Select({"<script>",
            "SELECT * from user",
            "where user_no = #{user_no}",
            "</script>"})
    UserVO findOneUser(int user_no);

    @Update({"<script>",
            "UPDATE user",
            "<trim prefix='set' suffixOverrides=','>",
            "<if test='id!=null'>id=#{id},</if>",
            "<if test='password!=null'>password=#{password},</if>",
            "<if test='name!=null'>name=#{name},</if>",
            "</trim>",
            "WHERE user_no = #{user_no}",
            "</script>"})
    int updateUser(UserVO user);

    @Delete({"<script>",
            "DELETE FROM user",
            "WHERE user_no = #{user_no}",
            "</script>"})
    int deleteUser(int user_no);






}
