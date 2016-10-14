package com.tulingchain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tulingchain.model.bill.Discount;
import com.tulingchain.model.bill.Discounting;
import com.tulingchain.model.bill.Issuance;
import com.tulingchain.model.bill.Payment;
import com.tulingchain.model.bill.Payoff;
import com.tulingchain.model.bill.Payroll;
import com.tulingchain.service.bill.BillNoderService;
import com.tulingchain.service.bill.DiscountService;
import com.tulingchain.service.bill.DiscountingService;
import com.tulingchain.service.bill.IssuanceService;
import com.tulingchain.service.bill.PaymentService;
import com.tulingchain.service.bill.PayoffService;
import com.tulingchain.service.bill.PayrollService;
/**
 * @author Administrator
 * 六大票据操作:    签发、承贴、支付、发薪、提薪、贴现
 * 
 *      
 */
@Controller
public class BillController {
	
	@Autowired
	public IssuanceService issuanceService;
	
	@Autowired
	public DiscountingService discountingService;
	
	@Autowired
	public  PaymentService paymentService;
	
	@Autowired
	public PayoffService payoffService;
	
	@Autowired
	public PayrollService  payrollService;
	
	@Autowired
	public DiscountService discountServie;
	
	@Autowired
	public BillNoderService billNoderService;
	
	
	//签发
	@RequestMapping(value="/issuanceBill",method=RequestMethod.POST)
	public  @ResponseBody String saveInssuance(@RequestBody Issuance issuance){
		String re=issuanceService.insert(issuance);
		System.out.println("BillController-log"+issuance.getIs_id());
		return re;
	}
	//查询签发历史
	@RequestMapping(value="/issuanceHistory/{id}",method=RequestMethod.GET)
	public @ResponseBody String queryInssuanceBills(@PathVariable("id") int id){
		List<Issuance> list=issuanceService.listAll(id);
		for(Issuance li:list){
			System.out.println(li);
		}
		return JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	//承贴
	@RequestMapping(value="/discountingBill/{id}",method=RequestMethod.GET)
	public@ResponseBody String saveDsicounting(@PathVariable("id") String id){
		System.out.println(id);
		JSONObject obj=billNoderService.ensureDiscounting(id);
		return obj.toJSONString();
	}
	
	//承贴放需要承贴的票据
	@RequestMapping(value="/needDiscounting/{id}",method=RequestMethod.GET)
	public@ResponseBody String needDiscounting(@PathVariable int  id){
		List<Issuance> list=issuanceService.listNeedDiscounting(id);
		return JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	//承贴签发历史
	@RequestMapping(value="/discoutingHistory/{id}",method=RequestMethod.GET)
	public @ResponseBody String queryDiscoutingBills(@PathVariable("id") int id){
		List<Discounting> list=discountingService.listAll(id);
		for(Discounting li:list){
			System.out.println(li);
		}
		return JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	
	
	
	//支付
	@RequestMapping(value="/paymentBill",method=RequestMethod.POST)
	public  @ResponseBody String savePayment(@RequestBody Payment payment){
		String re=paymentService.save(payment);
		System.out.println("BillController-log"+payment.getPay_id());
		return re;
	}
	
	//支付签发历史
		@RequestMapping(value="/paymentHistory/{id}",method=RequestMethod.GET)
		public @ResponseBody String queryPaymentBills(@PathVariable("id") int id){
			List<Payment> list=paymentService.listAll(id);
			for(Payment li:list){
				System.out.println(li);
			}
			return JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
		}
	
	
	//发薪
	@RequestMapping(value="/payoffBill",method=RequestMethod.POST)
	public @ResponseBody String savePayoff(@RequestBody Payoff payoff){
		String re=payoffService.save(payoff);
		System.out.println("BillController-log"+payoff.getPayoff_id());
		return re;
	}
	
	//发薪签发历史
	@RequestMapping(value="/payoffHistory/{id}",method=RequestMethod.GET)
	public @ResponseBody String queryPayoffBills(@PathVariable("id") int id){
		List<Payoff> list=payoffService.listAll(id);
		for(Payoff li:list){
			System.out.println(li);
		}
		return JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	//提薪
	@RequestMapping(value="/payrollBill",method=RequestMethod.POST)
	public @ResponseBody String savePayroll(@RequestBody Payroll payroll){
		String re=payrollService.save(payroll);
		System.out.println("BillController-log"+payroll.getPayroll_id());
		return re;
	}
	
	//提薪签发历史
	@RequestMapping(value="/payrollHistory/{id}",method=RequestMethod.GET)
	public @ResponseBody String queryPayrollBills(@PathVariable("id") int id){
		List<Payroll> list=payrollService.listAll(id);
		for(Payroll li:list){
			System.out.println(li);
		}
		return JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	//贴现
	@RequestMapping(value="/discountBill",method=RequestMethod.POST)
	public @ResponseBody String saveDiscount(@RequestBody Discount discount){
		String re=discountServie.save(discount);
		System.out.println("BillController-log"+discount.getDicount_id());
		return re;
	}
	//贴现签发历史
	@RequestMapping(value="/discountHistory/{id}",method=RequestMethod.GET)
	public @ResponseBody String queryDiscountBills(@PathVariable("id") int id){
		List<Discount> list=discountServie.listAll(id);
		for(Discount li:list){
			System.out.println(li);
		}
		return JSON.toJSONString(list,SerializerFeature.DisableCircularReferenceDetect);
	}
	
	//我的票据查询
	@RequestMapping(value="/billHistory/{pubk}",method=RequestMethod.GET)
	public @ResponseBody String queryBillHistory(@PathVariable("pubk") String pubk){
		JSONArray array=billNoderService.queryMyBills(pubk);
		System.out.println(array);
		return array.toJSONString();
	}
	
	//首页测试api
	@RequestMapping(value="/testApi",method=RequestMethod.POST)
	public  @ResponseBody String testApi(@RequestBody JSONObject object){
		JSONObject obj=billNoderService.testApi(object);
		String txid=obj.getString("id");
		return txid;
	}
	
}
