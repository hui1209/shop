package com.acttion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Bill;
import com.bean.Role;
import com.bean.Supplier;
import com.bean.User;
import com.service.BillService;
import com.service.RoleService;
import com.service.SupplierService;
import com.service.UserService;
import com.util.PageAssistant;

/**
 * 用户业务控制器(展现层)
 * @author Administrator
 *
 */
@Controller
@RequestMapping("user")
public class UserAction {

	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	@Resource
	private BillService billService;
	@Resource
	private SupplierService supplierService;
	
	/**
	 * 供应商查询
	 * @return
	 */
	@RequestMapping("querySupplier")
	public String querySupplier(Supplier supplier, PageAssistant pa, HttpSession session) {
		System.out.println("--> supplier query");
		System.out.println(supplier);
		System.out.println(pa);
		
		/* 1. 构建map集合, 添加查询参数 */
		//声明map集合
		Map<String, Object> map = new HashMap<>();
		//判断和添加参数
		if(supplier.getName() != null) {
			//去除空格
			supplier.setName(supplier.getName().trim());
			//判断, 是否空字符串
			if(!supplier.getName().equals("")) {
				map.put("keyword", supplier.getName());
			}
		}
		if(supplier.getDetail() != null) {
			map.put("detail", supplier.getDetail());
		}
		
		/* 2. 查询获取总记录数 */
		pa.setCount(supplierService.count(map));
		
		/* 3. 添加分页参数 */
		map.put("start", pa.getStart());
		map.put("size", pa.getPageSize());
		
		/* 4. 查询 */
		List<Supplier> list = supplierService.selectByPage(map);
		
		/* 5. 保存数据 */
		session.setAttribute("supplierList", list); //需要显示的集合
		session.setAttribute("querySupplierInfo", supplier); //查询条件
		session.setAttribute("pa", pa); //分页助手
		
		return "/page/supplier/list.jsp";
		
	}
	
	/**
	 * 账单查询
	 * @return
	 */
	@RequestMapping("queryBill")
	public String queryBill(Bill bill, PageAssistant pa, HttpSession session) {
		System.out.println("--> user query");
		System.out.println(bill);
		System.out.println(pa);
		
		/* 1. 构建map集合, 添加查询参数 */
		//声明map集合
		Map<String, Object> map = new HashMap<>();
		//判断和添加参数
		if(bill.getName() != null) {
			//去除空格
			bill.setName(bill.getName().trim());
			//判断, 是否空字符串
			if(!bill.getName().equals("")) {
				map.put("keyword", bill.getName());
			}
		}
		if(bill.getPayment() != null) {
			map.put("payment", bill.getPayment());
		}
		
		/* 2. 查询获取总记录数 */
		pa.setCount(billService.count(map));
		
		/* 3. 添加分页参数 */
		map.put("start", pa.getStart());
		map.put("size", pa.getPageSize());
		
		/* 4. 查询 */
		List<Bill> list = billService.selectByPage(map);
		
		/* 5. 保存数据 */
		session.setAttribute("billList", list); //需要显示的集合
		System.out.println(list.get(0).getTime());
		session.setAttribute("queryBillInfo", bill); //查询条件
		session.setAttribute("pa", pa); //分页助手
		
		return "/page/bill/list.jsp";
		
	}
	
	/**
	 * 添加数据
	 * @return
	 */
	@RequestMapping("insertUser")
	public String insertUser(User user, HttpSession session) {
		
		System.out.println("--> user insert");
		System.out.println(user);
		
		userService.insert(user);
		
		return "redirect:/page/main.jsp";
	}
	
	/**
	 * 跳转
	 * @return
	 */
	@RequestMapping("jump")
	public String jump() {
		
		System.out.println("--> jump");
		
		return "redirect:/page/user/userAdd.jsp";
	}
	
	/**
	 * 修改用户数据
	 * @return
	 */
	@RequestMapping("modify")
	public String modify(User user, HttpSession session) {
		System.out.println("--> user modify");
		System.out.println(user);
		
		/* 修改 */
		userService.update(user);
		
		/* 保存 */
		session.setAttribute("hint", "用户信息修改成功!");
		
		return "queryOne";
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(User user, HttpSession session) {
		System.out.println("--> user delete");
		System.out.println(user);
		
		/* 删除 */
		userService.delete(user);
		
		/* 保存提示信息 */
		session.setAttribute("hint", "删除用户成功!");
		session.setAttribute("hintClass", "suc-hint");
		
		return "redirect:/user/query";
	}
	
	/**
	 * 根据id查询具体账单信息
	 * @return
	 */
	@RequestMapping("queryBillOne")
	public String queryBillOne(Bill bill, HttpSession session) {
		System.out.println("--> bill query one by id");
		System.out.println(bill);
		
		/* 查询 */
		bill = billService.select(bill).get(0);
		
		/* 保存 */
		session.setAttribute("billInfo", bill);

		return "/page/bill/info.jsp";
	}
	
	/**
	 * 根据id查询具体用户信息
	 * @return
	 */
	@RequestMapping("queryOne")
	public String queryOne(User user, HttpSession session) {
		System.out.println("--> user query one by id");
		System.out.println(user);
		
		/* 查询 */
		user = userService.select(user).get(0);
		
		/* 保存 */
		session.setAttribute("userInfo", user);

		return "/page/user/info.jsp";
	}
	
	/**
	 * 查询
	 * @return
	 */
	@RequestMapping("query")
	public String query(User user, PageAssistant pa, HttpSession session) {
		System.out.println("--> user query");
		System.out.println(user);
		System.out.println(pa);
		
		/* 1. 构建map集合, 添加查询参数 */
		//声明map集合
		Map<String, Object> map = new HashMap<>();
		//判断和添加参数
		if(user.getUserName() != null) {
			//去除空格
			user.setUserName(user.getUserName().trim());
			//判断, 是否空字符串
			if(!user.getUserName().equals("")) {
				map.put("keyword", user.getUserName());
			}
		}
		if(user.getGender() != null) {
			map.put("gender", user.getGender());
		}
		if(user.getAge() != null) {
			map.put("age", user.getAge());
		}
		
		/* 2. 查询获取总记录数 */
		pa.setCount(userService.count(map));
		
		/* 3. 添加分页参数 */
		map.put("start", pa.getStart());
		map.put("size", pa.getPageSize());
		
		/* 4. 查询 */
		List<User> list = userService.selectByPage(map);
		
		/* 5. 保存数据 */
		session.setAttribute("userList", list); //需要显示的集合
		session.setAttribute("queryInfo", user); //查询条件
		session.setAttribute("pa", pa); //分页助手
		
		return "/page/user/list.jsp";
		
	}
	
	/**
	 * 退出
	 * @param session
	 * @return
	 */
	@RequestMapping("logoff")
	public String logoff(HttpSession session) {
		
		System.out.println("--> user logoff");
		
		//销毁会话
		session.invalidate();
		
		return "redirect:/login.jsp";
	}
	
	/**
	 * 登录
	 * @return
	 */
	@RequestMapping("login")
	public String login(User user, HttpSession session) {
		
		System.out.println("--> user login");
		System.out.println(user);
		
		/* 1. 查询 */
		List<User> list = userService.select(user);
		/* 2. 判断, 是否登录成功 */
		if(list.size() != 1) {
			session.setAttribute("errMsg", "用户名或密码错误!");
			return "redirect:/login.jsp";
		}
		
		session.setAttribute("loginInfo", list.get(0));
		return "queryRoles";
	}
	
	/**
	 * 查询角色集合
	 * @return
	 */
	@RequestMapping("queryRoles")
	public String queryRoles(HttpSession session) {
		
		System.out.println("--> user query roles");
		
		/* 1. 查询 */
		//获取application对象
		ServletContext application = session.getServletContext();
		//判断
		if(application.getAttribute("roleList") == null) {
			//查询
			List<Role> list = roleService.select(null);
			//保存
			application.setAttribute("roleList", list);
		}
		
		return "redirect:/page/main.jsp";
	}
	
}











