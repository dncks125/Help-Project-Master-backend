package com.shincom.graduation_project_backend_server.controller;

import com.shincom.graduation_project_backend_server.ConfigConstant;
import com.shincom.graduation_project_backend_server.domain.*;


import com.shincom.graduation_project_backend_server.persistence.ApiMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/shincom")
public class ApiController {
    @Autowired
    private ApiMapper apiMapper;

    @Autowired
    private ConfigConstant configConstant;

    @PostMapping("/feed")
    public ResultVO addFeed(@RequestBody FeedVO feed) {
        int result = apiMapper.insertFeed(feed);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @GetMapping("/feed/{feed_no}")
    public FeedVO findOneFeed(@PathVariable int feed_no) {
        return apiMapper.findOneFeed(feed_no);
    }


    @GetMapping("/feedes")
    public List<FeedVO> findFeed() {
        return apiMapper.findFeed();
    }

    @PutMapping("/feed")
    public ResultVO modifyFeed(@RequestBody FeedVO feed) {
        int result = apiMapper.updateFeed(feed);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @DeleteMapping("feed")
    public ResultVO removeFeed(@RequestParam int feed_no) {
        int result = apiMapper.deleteFeed(feed_no);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }


    //댓글-------------------------------------------------------------------------

    @PostMapping("/feed-re")
    public ResultVO addFeedRe(@RequestBody FeedReVO feedre) {
        int result = apiMapper.insertFeedRe(feedre);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }


    @GetMapping("/feed-re/{feed_re_no}")
    public FeedReVO findOneFeedRe(@PathVariable int feed_re_no) {
        return apiMapper.findOneFeedRe(feed_re_no);
    }


    @GetMapping("/feedrees")
    public List<FeedReVO> findFeedRe() {
        return apiMapper.findFeedRe();
    }

    @GetMapping("/feedrees-reply")
    public List<FeedReVO> findReplyFeedRe() {
        return apiMapper.findReplyFeedRe();
    }

    @PutMapping("/feed-re")
    public ResultVO modifyFeedRe(@RequestBody FeedReVO feedre) {
        int result = apiMapper.updateFeedRe(feedre);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @DeleteMapping("feed-re")
    public ResultVO removeFeedRe(@RequestParam int feed_re_no) {
        int result = apiMapper.deleteFeedRe(feed_re_no);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    // 파일 업로드
    @PostMapping("/file")
    public ResultVO fileUpload(@RequestPart(value = "file") MultipartFile file) {
        try {
            // 이미지가 있는지 체크
            if (file != null) {
                //업로드할 디렉토리가 있는지 체크
                String path =  configConstant.rootFolder + configConstant.uploadFolder;
                File dir = new File(path);
                if (!dir.isDirectory()) {
                    dir.mkdirs();
                }
                // 파일 저장: 파일명은 중복을 피하기 위해서 파일명 _타임스템프
                String filename = file.getOriginalFilename();
                String savedFilename = filename.substring(0, filename.lastIndexOf(".")) + "_" +
                        System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
                File saveFile = new File(path, savedFilename);
                file.transferTo(saveFile);
                return new ResultVO(0, configConstant.uploadFolder + "/" + savedFilename);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVO(500, "internal server error");
    }

    //좋아요---------------------------------------------------------------------------------------------

    @PostMapping("/like")
    public ResultVO addLike(@RequestBody LikeVO like) {
        int result = apiMapper.insertFeedLike(like);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    //게시판==================================================================================
    @PostMapping("/board")
    public ResultVO addBoard(@RequestBody BoardVO board) {
        int result = apiMapper.insertBoard(board);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @GetMapping("/board/{board_no}")
    public BoardVO findOneBoard(@PathVariable int board_no) {
        return apiMapper.findOneBoard(board_no);
    }


    @GetMapping("/boards")
    public List<BoardVO> findBoard() {
        return apiMapper.findBoard();
    }

    @PutMapping("/board")
    public ResultVO modifyBoard(@RequestBody BoardVO board) {
        int result = apiMapper.updateBoard(board);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @DeleteMapping("board")
    public ResultVO removeBoard(@RequestParam int board_no) {
        int result = apiMapper.deleteBoard(board_no);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    //게시판댓글=========================================================

    @PostMapping("/boardre")
    public ResultVO addBoardRe(@RequestBody Board_commentVO boardre) {
        int result = apiMapper.insertBoardRe(boardre);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @GetMapping("/boardre/{board_no}")
    public Board_commentVO findOneBoardRe(@PathVariable int comment_no) {
        return apiMapper.findOneBoardRe(comment_no);
    }


    @GetMapping("/boardres")
    public List<Board_commentVO> findBoardRe() {
        return apiMapper.findBoardRe();
    }

    @PutMapping("/boardre")
    public ResultVO modifyBoardRe(@RequestBody Board_commentVO boardre) {
        int result = apiMapper.updateBoardRe(boardre);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @DeleteMapping("boardre")
    public ResultVO removeBoardRe(@RequestParam int comment_no) {
        int result = apiMapper.deleteBoardRe(comment_no);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }
    //프로젝트=======================================================
    @PostMapping("/project")
    public ResultVO addProject(@RequestBody ProjectVO project) {
        int result = apiMapper.insertProject(project);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @GetMapping("/project/{project_no}")
    public ProjectVO findOneProject(@PathVariable int project_no) {
        return apiMapper.findOneProject(project_no);
    }


    @GetMapping("/projects")
    public List<ProjectVO> findProject() {
        return apiMapper.findProject();
    }

    @PutMapping("/project")
    public ResultVO modifyProject(@RequestBody ProjectVO project) {
        int result = apiMapper.updateProject(project);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @DeleteMapping("project")
    public ResultVO removeProject(@RequestParam int project_no) {
        int result = apiMapper.deleteProject(project_no);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }
    //메뉴=======================================================
    @PostMapping("/menu")
    public ResultVO addMenu(@RequestBody MenuVO menu) {
        int result = apiMapper.insertMenu(menu);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @GetMapping("/menu/{menu_no}")
    public MenuVO findOneMenu(@PathVariable int menu_no) {
        return apiMapper.findOneMenu(menu_no);
    }


    @GetMapping("/menues")
    public List<MenuVO> findMenu() {
        return apiMapper.findMenu();
    }

    @PutMapping("/menu")
    public ResultVO modifyMenu(@RequestBody MenuVO menu) {
        int result = apiMapper.updateMenu(menu);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @DeleteMapping("menu")
    public ResultVO removeMenu(@RequestParam int menu_no) {
        int result = apiMapper.deleteMenu(menu_no);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    //=============================================

    @PostMapping("/user")
    public ResultVO addUser(@RequestBody UserVO user) {
        int result = apiMapper.insertUser(user);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }
    @GetMapping("/user/{user_no}")
    public UserVO findOneUser(@PathVariable int user_no) {
        return apiMapper.findOneUser(user_no);
    }


    @GetMapping("/users")
    public List<UserVO> findUser() {
        return apiMapper.findUser();
    }

    @PutMapping("/user")
    public ResultVO modifyUser(@RequestBody UserVO user) {
        int result = apiMapper.updateUser(user);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

    @DeleteMapping("user")
    public ResultVO removeUser(@RequestParam int user_no) {
        int result = apiMapper.deleteUser(user_no);
        if (result > 0) {
            return new ResultVO(0, "success");
        } else {
            return new ResultVO(100, "fail");
        }
    }

}








