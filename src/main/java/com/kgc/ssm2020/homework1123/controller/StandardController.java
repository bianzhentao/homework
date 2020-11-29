package com.kgc.ssm2020.homework1123.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.ssm2020.homework1123.pojo.Standard;
import com.kgc.ssm2020.homework1123.service.StandardService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.IntRange;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
public class StandardController {
    @Resource
    StandardService standardService;

    @RequestMapping(value = "stand.do")
    public String selectAll(@RequestParam(value = "stand",defaultValue = "")String stand,
                            @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                            Model model){
        Integer pageSize=3;
        PageInfo<Standard> pageInfo=standardService.selectStandards(stand,pageNum,pageSize);
        model.addAttribute("stand",stand);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("pageInfo",pageInfo);

        System.out.println(stand);
        return "index";
    }

    @RequestMapping("del.do")
    public String del(HttpServletRequest request){
        String checkVal=request.getParameter("checkVal");
        System.out.println(checkVal);
        if(checkVal!=null&&!checkVal.equals("")){
            String[] ids=checkVal.split(",");
//            System.out.println(ids.toString());
            for(String id : ids){
                System.out.println(id);
                if(id!=null&&!id.equals("")){
                    int sid=Integer.parseInt(id);
                    standardService.delStandard(sid);
                }
            }
            return "forward:stand.do";
        }

        return "forward:null";
    }

    @RequestMapping("add.do")
    public String add(){
        return "add";
    }

    @RequestMapping(value = "doadd.do",method = RequestMethod.POST,produces="text/html;charset=utf-8")
    @ResponseBody
    public String doAdd(HttpServletRequest request, @RequestParam("id_Pic") MultipartFile idPic, HttpSession session, Model model){
        String stdNum=request.getParameter("stdNum");
        String zhname=request.getParameter("zhname");
        String version=request.getParameter("version");
        String keys=request.getParameter("keys");
        String release=request.getParameter("releaseDate");
        String impl=request.getParameter("implDate");
        Standard standard=new Standard();
        standard.setStdNum(stdNum);
        standard.setZhname(zhname);
        standard.setVersion(version);
        standard.setKeys(keys);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date releaseDate=null,implDate=null;
        try{
            releaseDate=sdf.parse(release);
            implDate=sdf.parse(impl);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        standard.setReleaseDate(releaseDate);
        standard.setImplDate(implDate);
        //获取上传路径
        String realPath = session.getServletContext().getRealPath("images/uploadfiles/");
        //获取原文件名
        String oldName = idPic.getOriginalFilename();
        //获取扩展名
        String extension = FilenameUtils.getExtension(oldName);//原文件后缀
        //生成新文件名
        String newName = System.currentTimeMillis() + new Random().nextInt(1000) + "_id_pic." + extension;
        //封装文件对象
        System.out.println(newName);
        File file = new File(realPath, newName);
        try {
            idPic.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        standard.setPackagePath(newName);
        int i =standardService.addStandard(standard);
        if (i>0){
            return "<script>alert('添加成功！');location.href='stand.do';</script>";
        }else {
            return "<script>alert('添加失败！');location.href='add.do';</script>";
        }
    }

    @RequestMapping("update.do")
    public String update(){
        return "update";
    }
    @RequestMapping("doupdate.do")
    @ResponseBody
    public String doupdate(@RequestParam("id")Integer id,
                           @RequestParam("stdNum")String stdNum,
                           @RequestParam("zhname")String zhname,
                           @RequestParam("version")String version,
                           @RequestParam("keys")String keys,
                           @RequestParam("releaseDate")Date releaseDate,
                           @RequestParam("implDate")Date implDate,
                           @RequestParam("id_Pic") MultipartFile idPic,
                           HttpServletRequest request, HttpSession session){
        //获取上传路径
        String realPath = session.getServletContext().getRealPath("images/uploadfiles/");
        //获取原文件名
        String oldName = idPic.getOriginalFilename();
        //获取扩展名
        String extension = FilenameUtils.getExtension(oldName);//原文件后缀
        //生成新文件名
        String newName = System.currentTimeMillis() + new Random().nextInt(1000) + "_id_pic." + extension;
        //封装文件对象
        System.out.println(newName);
        File newFile = new File(realPath, newName);
        try {
            idPic.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Standard standard=new Standard();
        standard.setPackagePath(newName);
        standard.setId(id);
        standard.setStdNum(stdNum);
        standard.setZhname(zhname);
        standard.setVersion(version);
        standard.setKeys(keys);
        standard.setReleaseDate(releaseDate);
        standard.setImplDate(implDate);
        System.out.println(id);
        session.setAttribute("standard",standard);
        if (standardService.updateStandard(standard)>0){
            return "<script>alert('修改成功！');location.href='stand.do';</script>";
        }else {
            return "<script>alert('修改失败！');location.href='update.do';</script>";
        }
    }
}
