package com.tulingchain.service;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tulingchain.model.Noder;
import com.tulingchain.model.bill.BillNoder;

@WebService
@Path("/noder")
public interface NoderService {
	
	public void addNoder(Noder noder);
	
	public void addBillNoder(BillNoder billNoder); //BillNoder
	
	public void delete(Integer id);
	
	public void deleteBill(Integer id);//BillNoder
	
	public List<Noder> listAll();
	
	public List<BillNoder> listAllBill();//BillNoder

	public Noder findNoderByName(String noderName);
	
	public BillNoder findBillNoderByName(String noderName);//BillNoder
	
	public Noder findNoderByEmail(String email);
	
	public BillNoder findBillNoderByEmail(String email);//BillNoder

	public Noder queryLogin(Noder noder);
	
	public BillNoder queryLogin(BillNoder noder); //BillNoder，方法重载

	public Noder findByComNum(String comNum);
	
	public BillNoder findBillByComNum(String comNum); //BillNoder，

	public Noder findByComName(String comName);
	
	public BillNoder findBillByComName(String comName); //BillNoder，

	public String passNoder(Noder noder);

	public List<Noder> listAllByState();

	public String failNoder(Noder noder);

	public Noder findNoderById(int id);
	
	public List<Noder> listAllByState2();
	
	public String deleteNoder(Noder noder);

	public void upGrade(Noder noder);
	
	@GET
	@Path("/query/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Noder queryNoderServer(@PathParam("id")int id);
	
	@GET
	@Path("/queryNoderIp/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String queryNoderIpServer(@PathParam("id")int id);
	
	@GET
	@Path("/queryNoderPK/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String queryNoderPubKeyServer(@PathParam("id")int id);
	
	@GET
	@Path("/queryNoderRD/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Date queryNoderRegDateServer(@PathParam("id")int id);
	
	@GET
	@Path("/queryNoderCount/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public String queryNoderRegUserCountServer(@PathParam("id")int id);

	public void upNoderImg(Noder noder);

	public void updatePwd(String noderName, String newPassword);

	

}
