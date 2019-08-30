package com.bank.web.serviceimpls;
import java.util.ArrayList;
import java.util.List;

import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private List<CustomerBean> customers;
	private List<EmployeeBean> employees;
	
	public MemberServiceImpl() {
		customers = new ArrayList<>();
		employees = new ArrayList<>();
	}
	

	@Override
	public void join(CustomerBean param) {
		customers.add(param);
		
	}

	@Override
	public void register(EmployeeBean param) {
		employees.add(param);
		
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		return customers;
	}

	@Override
	public List<EmployeeBean> findAllEmployees() {
		return employees;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> ms  = new ArrayList();
		int count = 0;
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				count++;
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				count++;
			}
		}
		int j = 0;
		for(CustomerBean c : customers) {
			if(name.equals(c.getName())) {
				ms.add(c);
				j++;
				if(j==count) {
					return ms;
				}
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getName())) {
				ms.add(e);
				if(j==count) {
					break;
				}
			}
		}
		return ms;
	}

	@Override
	public MemberBean findById(String id) {     //리턴값이 객체라서String id도 객체로 됨. 아이디를 주면 객체가됨.
		MemberBean m = new MemberBean();        //객체 기능과 속성, 메모리에 주소가 있으면 객체 , id를 주면 객체.
		for(CustomerBean c : customers) {
			if(id.equals(c.getId())) {
				m = c;
				break;
			}
		}
		for(EmployeeBean e:employees) {
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
		}
		return m;
	}

	@Override
	public boolean login(MemberBean param) {
		MemberBean mb = findById(param.getId());
		boolean flag = false;
		for(CustomerBean c : customers) {
			if(mb.equals(c.getId())) {
				flag = true;
				break;
			}
		}
		for(EmployeeBean e:employees) {
			if(mb.equals(e.getId())) {
				flag = true;
				break;
			}
		}
		return flag;
	
	}

	@Override
	public int countCustomers() {
		return customers.size();
	}

	@Override
	public int countEmployees() {
		return employees.size();
	}

	@Override
	public boolean existId(String id) {
		MemberBean m = findById(id);
		return (employees.contains(m) || customers.contains(m));
	}

	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String oldPw = param.getPw().split(",")[0];
		String newPw = param.getPw().split(",")[1];
		MemberBean m = findById(id);
		if(m.getPw().equals(oldPw)) {
			int idx = (employees.contains(m)) 
					? employees.indexOf(m)
						:customers.indexOf(m);
			if(employees.contains(m)) {
				employees.get(idx).setPw(newPw);
			}else {
				customers.get(idx).setPw(newPw);
			}		
		}
			
	}

	@Override
	public boolean deleteMember(MemberBean param) {   //상황이 로그인 된 상태 가정에서 탈퇴라 아이디 검색 필요없고 직원인지 고객인지 판단만 하면된다.
		MemberBean m= findById(param.getId());
		return (employees.contains(m))?employees.remove(m):customers.remove(m); 
		
		
	}

}
