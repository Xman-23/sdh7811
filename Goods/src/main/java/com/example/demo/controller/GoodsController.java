package com.example.demo.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDAO;
import com.example.demo.vo.GoodsVO;

@Controller
public class GoodsController {
	public int totalRecord = 0;
	public int pageSize = 4;
	public int totalPage = 1;
	
	@Autowired
	private GoodsDAO g_Dao;

	public GoodsController(GoodsDAO g_Dao) {
		super();
		this.g_Dao = g_Dao;
	}
	
	
	@RequestMapping(value = "/insertGoods",method = RequestMethod.GET)
	public void insertForm(HttpServletRequest request)
	{
		
	}
	@RequestMapping(value = "/insertGoods",method = RequestMethod.POST)
	public ModelAndView insertSubmit(HttpServletRequest request,GoodsVO g)
	{
		ModelAndView modelAndView = new ModelAndView("redirect:/listGoods");
		String path = request.getRealPath("images");
		System.out.println("이미지 경로 : " +path);
		MultipartFile uploadFile = g.getUploadFile();
		String fname = null;
		fname = uploadFile.getOriginalFilename();
		
		if(fname != null && !fname.equals("")) {
			
			g.setFname(fname); //업로드한 파일을 실고
		}else {
			g.setFname(""); // 업로드한 파일이 없다면 "" 실어준다
		}
		int re = g_Dao.insertGoods(g);
		if(re==1)
		{
			if(fname != null && !fname.equals(""))
			{
				try {
					byte[] data = uploadFile.getBytes();
					FileOutputStream fileOutputStream = new FileOutputStream(path+"/"+fname);
					fileOutputStream.write(data);
					fileOutputStream.close();
				} catch (Exception e) {
					System.out.println("예외 발생"+e.getMessage());
				}
			}
		}else {
			modelAndView.addObject("msg", "상품등록에 실패하였습니다");
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}
	//목록 코드 
	@RequestMapping("/listGoods")
	public void listGoods(HttpServletRequest request,Model model,@RequestParam(value = "pageNUM",defaultValue = "1") int pageNUM) {
		System.out.println("pageNUM : "+ pageNUM);
		totalRecord= g_Dao.count();
		totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
		
		//현재 페이지에 보여줄 시작 레코드, 마지막 레코드
		
		/*
		String pageStr = "str";
		
		for(int i=1; i<=totalPage;i++)
		{
			pageStr += "<a href = 'listGoods?pageNUM="+i+"'>"+i+"</a>&npsp;";
		}
		*/
		
		int start = (pageNUM-1) * pageSize + 1;
		int end = start+pageSize-1;
		
		if(end> totalRecord)
		{
			end = totalRecord;
		}
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		model.addAttribute("list", g_Dao.findAll(map));
		model.addAttribute("totalPage", totalPage);
		
	}
	@RequestMapping("/detailGoods")
	public void detailGoods(HttpServletRequest request,Model model, int no)
	{
		GoodsVO g_Vo = g_Dao.findByNo(no);
		model.addAttribute("g", g_Vo);
		String fname = g_Vo.getFname();
		if(fname != null && !fname.equals(""))
		{
			if(fname.endsWith(".png")||fname.endsWith(".jpg")||fname.endsWith(".gif"))
			{
				model.addAttribute("img", "yes");
			}
		}
	}
	
	@RequestMapping(value = "/updateGoods",method = RequestMethod.GET)
	public void updateForm(HttpServletRequest request,Model model, int no)
	{
		model.addAttribute("g", g_Dao.findByNo(no));
	}
	@RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
	public ModelAndView updateSubmit(HttpSession session,GoodsVO g, HttpServletRequest request)
	{
		String path = request.getRealPath("images");
		String oldFname = g.getFname(); //이미 있는 이미지 파일;
		String fname = null; // 수정할 파일
		
		MultipartFile uploadFile = g.getUploadFile();
		fname = uploadFile.getOriginalFilename();
		
		if(fname != null && !fname.equals(""))
		{
			g.setFname(fname); // 새로운 수정 파일을 넣어준다
			
			try {

				byte[] data = uploadFile.getBytes();
				FileOutputStream fileOutputStream = new FileOutputStream(path+"/"+fname);
				fileOutputStream.write(data);
				fileOutputStream.close();
			} catch (Exception e) {
				System.out.println("예외 발생 :" + e.getMessage());
			}
			
		}
		
		ModelAndView modelAndView = new ModelAndView("redirect:/listGoods");
		
		int re = g_Dao.update(g);
		
		if(re != 1)
		{
			modelAndView.addObject("msg", "게시물 수정에 실패했습니다");
			modelAndView.setViewName("error");
			
			if(fname != null && !fname.equals("")) //수정에 실패 했는데에도 수정 파일이 폴더에 남아 있다면
			{
				File file = new File(path+"/"+fname); // 실패한 수정 파일의 경로와 이름을 차장
				file.delete(); // 파일을 삭제 해준다
			}
		}else { // 수정에 성공 했다면은
			if(fname !=null && !fname.equals("") && oldFname !=null && !oldFname.equals(""))
				//원본 파일이 있고 , 수정 파일이 있다면은
			{
				File file = new File(path+"/"+oldFname); // 원본 파일의 경로를 찾아 
				file.delete();// 삭제해준다.
				
			}
		}
		
		
		return modelAndView;
	}
	

	@RequestMapping("/deleteGoods")
	public ModelAndView deleteSubmit(HttpServletRequest request,int no) {
		
		ModelAndView modelAndView = new ModelAndView("redirect:/listGoods");
		String path = request.getRealPath("images");
		String oldFname = g_Dao.findByNo(no).getFname();
		
		int re = g_Dao.delete(no);
		
		if(re != 1)
		{
			modelAndView.addObject("msg", "상품 삭제에 실패하였습니다");
			modelAndView.setViewName("error");
		}else {
			if(oldFname != null && !oldFname.equals(""))
			{
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
		}
		
		

		
		return modelAndView;
	}
	
	
}
