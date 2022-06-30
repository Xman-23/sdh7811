package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;

@Controller
public class BoardController {
	
		public int pageSize=10; //보여줄 게시물의 갯수
		public int totalRecord=0; //총 게시물을 담을 변수
		public int totalPage=1; // 전체 페이지의 수 
	
		@Autowired
		private BoardDAO b_Dao;
	
		public BoardController(BoardDAO b_Dao) 
		{
			super();
			this.b_Dao = b_Dao;
		}
		
		@RequestMapping("/list")
		public void b_list(Model model,@RequestParam(value = "pageNUM",defaultValue = "1") int pageNUM)
		{
			System.out.println("pageNUM :" + pageNUM);
			totalRecord = b_Dao.getTotalRecord();
			totalPage = (int)Math.ceil(totalRecord/(double)pageSize);
			int start = (pageNUM -1) * pageSize +1;
			int end = start+pageSize-1;
			
			if(end > totalRecord)
			{
				end = totalRecord;
			}
			
			HashMap map = new HashMap();
			map.put("start", start);
			map.put("end", end);
			
			model.addAttribute("list", b_Dao.list_Board(map));
			model.addAttribute("totalPage", totalPage);
		}
		
		@RequestMapping("/detaillist")
		public void findByNo(Model model,int no)
		{
			
			BoardVO b = b_Dao.findByNo(no);
			model.addAttribute("b", b);
			String fname = b.getFname();
			if(fname != null && !fname.equals(""))
			{
				if(fname.endsWith(".png")||fname.endsWith(".jpg")||fname.endsWith(".gif"))
				{
					model.addAttribute("img", "yes");
				}
			}
			
		}
		@RequestMapping(value = "/insert",method = RequestMethod.GET)
		public void insertForm(Model model,@RequestParam(value = "no",defaultValue = "0")int no)
		{
			model.addAttribute("no", no);
			String title = "새글 작성";
			if(no != 0)
			{
				title ="답글 작성";
			}
			model.addAttribute("title", title);
		}
		@RequestMapping(value = "/insert",method = RequestMethod.POST)
		public ModelAndView insertSubmit(BoardVO b, HttpServletRequest request)
		{
			String path = request.getRealPath("upload");
			System.out.println(path);
			MultipartFile uploadFile = b.getUploadFile();
			String fname = null;
			fname =	uploadFile.getOriginalFilename(); // 파일 이름 읽어오기
			if(fname != null && !fname.equals(""))
			{
				System.out.println("업로드한 파일이 있어요");
				b.setFname(fname);
				//업로드 한 파일이 있다면은 fname 저장 되고 없으면 "" 빈문자열이 담아질것이다
				try {
					byte[] data = uploadFile.getBytes();
					FileOutputStream fileOutputStream = new FileOutputStream(path+"/"+fname);
					fileOutputStream.write(data);
					fileOutputStream.close();
				} catch (Exception e) {
					System.out.println("예외 발생:" + e.getMessage());
				}
				
			}else {
				System.out.println("업로드한 파일이 없어요!");
				b.setFname("");
			}
			
		
			
			
			ModelAndView modelAndView = new ModelAndView("redirect:/list");
			
			//일단 새글
			int no = b_Dao.getNextNo();
			int b_ref = 0;
			int b_step = 0;
			int b_level =0;
			
			int pno = b.getNo(); // 부모글의 번호
			if(pno != 0) //답글 달기로 왔냐
			{
				BoardVO p = b_Dao.findByNo(pno);
				b_ref = p.getB_ref();
				b_level = p.getB_level();
				b_step = p.getB_step();
				b_Dao.updateStep(b_ref, b_step);
				b_step++;
				b_level++;
			}
			
			b.setNo(no);
			b.setB_ref(b_ref);
			b.setB_step(b_step);
			b.setB_level(b_level);
			
			int re = b_Dao.insertBoard(b);
			
			if(re != 1)
			{
				modelAndView.addObject("msg", "게시판 등록에 실패했습니다");
				modelAndView.setViewName("error");
			}
			return modelAndView;
		}
		
		@RequestMapping(value = "/updateBoard",method = RequestMethod.GET)
		public void updateForm(Model model , int no)
		{
			model.addAttribute("b", b_Dao.findByNo(no));
		}
		
		@RequestMapping(value = "/updateBoard",method = RequestMethod.POST)
		public ModelAndView updateSubmit(BoardVO b,HttpServletRequest request) {
			String path = request.getRealPath("upload");
			
			String oldFname = b.getFname(); //원래 파일 
			String fname = null; // 수정할 파일의 변수
			
			MultipartFile uploadFile = b.getUploadFile();
			fname = uploadFile.getOriginalFilename(); //fname 의 내용을 담아서
			if(fname != null && !fname.equals("")) // 더 정확하게 fname이 파일이 담겨져 있는지 확인을 해준다
			{
				b.setFname(fname);
				//파일의 수정이 완료 되었다면은 bVo에 새로운 파일 이름을 담아준다
				try {
					byte[] data = uploadFile.getBytes();
					FileOutputStream fileOutputStream = new FileOutputStream(path+"/"+fname);
					fileOutputStream.write(data);
					fileOutputStream.close();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("예외 발생:" + e.getMessage());
				}
				
			}
			
			ModelAndView modelAndView = new ModelAndView("redirect:/list");
			int re = b_Dao.updateBoard(b);
			if(re != 1)
			{
				modelAndView.addObject("msg", "게시물 수정에 실패하였습니다");
				modelAndView.setViewName("error");		
				if(fname != null && !fname.equals(""))
				{
					File file = new File(path+"/"+oldFname);
					file.delete();
				}
				
			}else {
				if(fname !=null && !fname.equals("")
						&& oldFname !=null && !oldFname.equals(""))
				{
					File file = new File(path+"/"+oldFname);
					file.delete();
				}
			}
			return modelAndView;
		}
		
		@RequestMapping(value = "/deleteBoard", method = RequestMethod.GET)
		public void deleteForm(Model model,int no)
		{
			model.addAttribute("no", no);
		}
		
		
		@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
		public ModelAndView deleteSubmit(int no , String pwd,HttpServletRequest request)
		{
			ModelAndView modelAndView = new ModelAndView("redirect:/list");
			String path = request.getRealPath("upload");
			String oldFname=b_Dao.findByNo(no).getFname();
			int re = b_Dao.deleteBoard(no, pwd);
			if(re !=1)
			{
				modelAndView.addObject("msg", "게시물 삭제에 실패하였습니다");
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
