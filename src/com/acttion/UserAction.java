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
 * �û�ҵ�������(չ�ֲ�)
 * @author Administrator
 * @DAte
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
	 * ��Ӧ�̲�ѯ
	 * @return
	 */
	@RequestMapping("querySupplier")
	public String querySupplier(Supplier supplier, PageAssistant pa, HttpSession session) {
		System.out.println("--> supplier query");
		System.out.println(supplier);
		System.out.println(pa);
		
		/* 1. ����map����, ��Ӳ�ѯ���� */
		//����map����
		Map<String, Object> map = new HashMap<>();
		//�жϺ���Ӳ���
		if(supplier.getName() != null) {
			//ȥ���ո�
			supplier.setName(supplier.getName().trim());
			//�ж�, �Ƿ���ַ���
			if(!supplier.getName().equals("")) {
				map.put("keyword", supplier.getName());
			}
		}
		if(supplier.getDetail() != null) {
			map.put("detail", supplier.getDetail());
		}
		
		/* 2. ��ѯ��ȡ�ܼ�¼�� */
		pa.setCount(supplierService.count(map));
		
		/* 3. ��ӷ�ҳ���� */
		map.put("start", pa.getStart());
		map.put("size", pa.getPageSize());
		
		/* 4. ��ѯ */
		List<Supplier> list = supplierService.selectByPage(map);
		
		/* 5. �������� */
		session.setAttribute("supplierList", list); //��Ҫ��ʾ�ļ���
		session.setAttribute("querySupplierInfo", supplier); //��ѯ����
		session.setAttribute("pa", pa); //��ҳ����
		
		return "/page/supplier/list.jsp";
		
	}
	
	/**
	 * �˵���ѯ
	 * @return
	 */
	@RequestMapping("queryBill")
	public String queryBill(Bill bill, PageAssistant pa, HttpSession session) {
		System.out.println("--> user query");
		System.out.println(bill);
		System.out.println(pa);
		
		/* 1. ����map����, ��Ӳ�ѯ���� */
		//����map����
		Map<String, Object> map = new HashMap<>();
		//�жϺ���Ӳ���
		if(bill.getName() != null) {
			//ȥ���ո�
			bill.setName(bill.getName().trim());
			//�ж�, �Ƿ���ַ���
			if(!bill.getName().equals("")) {
				map.put("keyword", bill.getName());
			}
		}
		if(bill.getPayment() != null) {
			map.put("payment", bill.getPayment());
		}
		
		/* 2. ��ѯ��ȡ�ܼ�¼�� */
		pa.setCount(billService.count(map));
		
		/* 3. ��ӷ�ҳ���� */
		map.put("start", pa.getStart());
		map.put("size", pa.getPageSize());
		
		/* 4. ��ѯ */
		List<Bill> list = billService.selectByPage(map);
		
		/* 5. �������� */
		session.setAttribute("billList", list); //��Ҫ��ʾ�ļ���
		System.out.println(list.get(0).getTime());
		session.setAttribute("queryBillInfo", bill); //��ѯ����
		session.setAttribute("pa", pa); //��ҳ����
		
		return "/page/bill/list.jsp";
		
	}
	
	/**
	 * �������
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
	 * ��ת
	 * @return
	 */
	@RequestMapping("jump")
	public String jump() {
		
		System.out.println("--> jump");
		
		return "redirect:/page/user/userAdd.jsp";
	}
	
	/**
	 * �޸��û�����
	 * @return
	 */
	@RequestMapping("modify")
	public String modify(User user, HttpSession session) {
		System.out.println("--> user modify");
		System.out.println(user);
		
		/* �޸� */
		userService.update(user);
		
		/* ���� */
		session.setAttribute("hint", "�û���Ϣ�޸ĳɹ�!");
		
		return "queryOne";
	}
	
	/**
	 * ɾ���û�
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(User user, HttpSession session) {
		System.out.println("--> user delete");
		System.out.println(user);
		
		/* ɾ�� */
		userService.delete(user);
		
		/* ������ʾ��Ϣ */
		session.setAttribute("hint", "ɾ���û��ɹ�!");
		session.setAttribute("hintClass", "suc-hint");
		
		return "redirect:/user/query";
	}
	
	/**
	 * ����id��ѯ�����˵���Ϣ
	 * @return
	 */
	@RequestMapping("queryBillOne")
	public String queryBillOne(Bill bill, HttpSession session) {
		System.out.println("--> bill query one by id");
		System.out.println(bill);
		
		/* ��ѯ */
		bill = billService.select(bill).get(0);
		
		/* ���� */
		session.setAttribute("billInfo", bill);

		return "/page/bill/info.jsp";
	}
	
	/**
	 * ����id��ѯ�����û���Ϣ
	 * @return
	 */
	@RequestMapping("queryOne")
	public String queryOne(User user, HttpSession session) {
		System.out.println("--> user query one by id");
		System.out.println(user);
		
		/* ��ѯ */
		user = userService.select(user).get(0);
		
		/* ���� */
		session.setAttribute("userInfo", user);

		return "/page/user/info.jsp";
	}
	
	/**
	 * ��ѯ
	 * @return
	 */
	@RequestMapping("query")
	public String query(User user, PageAssistant pa, HttpSession session) {
		System.out.println("--> user query");
		System.out.println(user);
		System.out.println(pa);
		
		/* 1. ����map����, ��Ӳ�ѯ���� */
		//����map����
		Map<String, Object> map = new HashMap<>();
		//�жϺ���Ӳ���
		if(user.getUserName() != null) {
			//ȥ���ո�
			user.setUserName(user.getUserName().trim());
			//�ж�, �Ƿ���ַ���
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
		
		/* 2. ��ѯ��ȡ�ܼ�¼�� */
		pa.setCount(userService.count(map));
		
		/* 3. ��ӷ�ҳ���� */
		map.put("start", pa.getStart());
		map.put("size", pa.getPageSize());
		
		/* 4. ��ѯ */
		List<User> list = userService.selectByPage(map);
		
		/* 5. �������� */
		session.setAttribute("userList", list); //��Ҫ��ʾ�ļ���
		session.setAttribute("queryInfo", user); //��ѯ����
		session.setAttribute("pa", pa); //��ҳ����
		
		return "/page/user/list.jsp";
		
	}
	
	/**
	 * �˳�
	 * @param session
	 * @return
	 */
	@RequestMapping("logoff")
	public String logoff(HttpSession session) {
		
		System.out.println("--> user logoff");
		
		//���ٻỰ
		session.invalidate();
		
		return "redirect:/login.jsp";
	}
	
	/**
	 * ��¼
	 * @return
	 */
	@RequestMapping("login")
	public String login(User user, HttpSession session) {
		
		System.out.println("--> user login");
		System.out.println(user);
		
		/* 1. ��ѯ */
		List<User> list = userService.select(user);
		/* 2. �ж�, �Ƿ��¼�ɹ� */
		if(list.size() != 1) {
			session.setAttribute("errMsg", "�û������������!");
			return "redirect:/login.jsp";
		}
		
		session.setAttribute("loginInfo", list.get(0));
		return "queryRoles";
	}
	
	/**
	 * ��ѯ��ɫ����
	 * @return
	 */
	@RequestMapping("queryRoles")
	public String queryRoles(HttpSession session) {
		
		System.out.println("--> user query roles");
		
		/* 1. ��ѯ */
		//��ȡapplication����
		ServletContext application = session.getServletContext();
		//�ж�
		if(application.getAttribute("roleList") == null) {
			//��ѯ
			List<Role> list = roleService.select(null);
			//����
			application.setAttribute("roleList", list);
		}
		
		return "redirect:/page/main.jsp";
	}
	
}











